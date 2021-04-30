package id.co.askrindo.kmkpen.service.impl;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiIjp;
import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiKlaim;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IRincianJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetil;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMaster;
import id.co.askrindo.kmkpen.repository.postgreSql.IJurnalProduksiIjpRepository;
import id.co.askrindo.kmkpen.repository.postgreSql.IJurnalProduksiKlaimRepository;
import id.co.askrindo.kmkpen.repository.postgreSql.IKlaimRepository;
import id.co.askrindo.kmkpen.service.IPenjurnalanService;
import id.co.askrindo.kmkpen.service.postgreSql.IJurnalProduksiIjpService;
import id.co.askrindo.kmkpen.service.postgreSql.IPenjaminanIjpService;
import id.co.askrindo.kmkpen.service.sybase.ITransaksiDetilService;
import id.co.askrindo.kmkpen.service.sybase.ITransaksiMasterService;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Service
public class PenjurnalanServiceImpl implements IPenjurnalanService {

    @Autowired
    private IJurnalProduksiIjpService jurnalProduksiIjpService;

    @Autowired
    private IJurnalProduksiKlaimRepository jurnalProduksiKlaimRepository;

    @Autowired
    private IPenjaminanIjpService penjaminanIjpService;

    @Autowired
    private IKlaimRepository klaimRepository;

    @Autowired
    private ITransaksiMasterService transaksiMasterService;

    @Autowired
    private ITransaksiDetilService transaksiDetilService;

    @Override
    @Transactional("postgreSqlTransactionManager")
    public List<JurnalProduksiIjp> prosesRekapJurnalProduksiIjp(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir) {
        List<IRincianJurnalProduksiIjpDTO> rincianDtoList = jurnalProduksiIjpService.getRincianJurnalProduksiIjpListFromRincian(bulan, tahun, tglPremiAwal, tglPremiAkhir);
        //Key kode Cabang, Kode Bank, Is Koreksi
        Map<Triplet<String, String, Boolean>, JurnalProduksiIjp> jurnalProduksiMap = new HashMap<>();

        Triplet<String, String, Boolean> keyJurnalIjp = null;
        JurnalProduksiIjp jurnalProduksiIjp = null;
        Long id = jurnalProduksiIjpService.getMaxIdVal() + 1L;

        for(IRincianJurnalProduksiIjpDTO dto : rincianDtoList) {
            keyJurnalIjp = Triplet.with(dto.getIdCabang(), dto.getKodeBank(), dto.getKoreksi());
            if(jurnalProduksiMap.containsKey(keyJurnalIjp)){
                jurnalProduksiIjp = jurnalProduksiMap.get(keyJurnalIjp);
                jurnalProduksiIjp.setNilaiIjp(jurnalProduksiIjp.getNilaiIjp().add(dto.getNilaiIjp()));
                jurnalProduksiIjp.setNilaiCadangan(jurnalProduksiIjp.getNilaiCadangan().add(dto.getNilaiCadangan()));

            }else{
                jurnalProduksiIjp = new JurnalProduksiIjp(dto);
                jurnalProduksiIjp.setIdJurnalProduksiIjp(id);
                jurnalProduksiIjp.setStatus(Boolean.FALSE);
                jurnalProduksiIjp.setVersion(1);
                jurnalProduksiIjp.setCreatedDate(new Date());
                jurnalProduksiIjp.setCreatedBy("system");
                id++;
            }
            jurnalProduksiMap.put(keyJurnalIjp, jurnalProduksiIjp);
        }

        List<JurnalProduksiIjp> JurnalProduksiIjpList = new ArrayList<>(jurnalProduksiMap.values());

        jurnalProduksiIjpService.saveAll(JurnalProduksiIjpList);
        penjaminanIjpService.updateIdJurnalIjp(tglPremiAwal, tglPremiAkhir);

        return JurnalProduksiIjpList;
    }

    @Override
    @Transactional("postgreSqlTransactionManager")
    public List<JurnalProduksiKlaim> prosesRekapJurnalProduksiKlaim(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir) {
        List<IJurnalProduksiKlaimDTO> rincianDtoList = jurnalProduksiKlaimRepository.getRincianJurnalProduksiIjpListFromRincian(bulan, tahun, tglPremiAwal, tglPremiAkhir);
        //Key kode Cabang, Kode Bank, Is Koreksi
        Map<Triplet<String, String, Boolean>, JurnalProduksiKlaim> jurnalProduksiMap = new HashMap<>();

        Triplet<String, String, Boolean> keyJurnalIjp = null;
        JurnalProduksiKlaim jurnalProduksiKlaim = null;
        Long id = jurnalProduksiKlaimRepository.getMaxIdVal() + 1L;

        for(IJurnalProduksiKlaimDTO dto : rincianDtoList) {
            keyJurnalIjp = Triplet.with(dto.getIdCabang(), dto.getKodeBank(), dto.getKoreksi());
            if(jurnalProduksiMap.containsKey(keyJurnalIjp)){
                jurnalProduksiKlaim = jurnalProduksiMap.get(keyJurnalIjp);
                jurnalProduksiKlaim.setNilaiKlaim(dto.getNilaiKlaim());
            }else{
                jurnalProduksiKlaim = new JurnalProduksiKlaim(dto);
                jurnalProduksiKlaim.setIdJurnalProduksiKlaim(id);
                jurnalProduksiKlaim.setStatus(Boolean.FALSE);
                jurnalProduksiKlaim.setVersion(1);
                jurnalProduksiKlaim.setCreatedDate(new Date());
                jurnalProduksiKlaim.setCreatedBy("system");
                id++;
            }
            jurnalProduksiMap.put(keyJurnalIjp, jurnalProduksiKlaim);
        }

        List<JurnalProduksiKlaim> JurnalProduksiKlaimList = new ArrayList<>(jurnalProduksiMap.values());

        jurnalProduksiKlaimRepository.saveAll(JurnalProduksiKlaimList);
        klaimRepository.updateIdJurnalKLaim(tglPremiAwal, tglPremiAkhir);

        return JurnalProduksiKlaimList;
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public List<TransaksiMaster> prosesJurnalIjpSaa(int bulan, int tahun, Date tglJurnal) {
        List<IJurnalProduksiIjpDTO> jurnalProduksiIjpDTOList = jurnalProduksiIjpService.getJurnalByStatusByMonthByYear(false, bulan,tahun);
        List<TransaksiMaster> transaksiMasterList = new ArrayList<>(jurnalProduksiIjpDTOList.size());

        for(IJurnalProduksiIjpDTO jurnalProduksiIjpDTO : jurnalProduksiIjpDTOList){
            TransaksiMaster transaksiMaster = transaksiMasterService.convertFromJurnalIjpPenDto(jurnalProduksiIjpDTO, tglJurnal);

            transaksiMasterService.save(transaksiMaster);

            Map<Integer, TransaksiDetil> transaksiDetilMap = null;

            if(jurnalProduksiIjpDTO.getKoreksi())
                transaksiDetilMap = transaksiDetilService.createTransaksiDetailKoreksi(transaksiMaster, jurnalProduksiIjpDTO);
            else
                transaksiDetilMap = transaksiDetilService.createTransaksiDetail(transaksiMaster, jurnalProduksiIjpDTO);

//            transaksiMaster.setTransaksiDetilList(new ArrayList<>(transaksiDetilMap.size()));

//            for(int key = 1 ; key <= 4 ; key++)
//                transaksiMaster.getTransaksiDetilList().add(transaksiDetilMap.get(key));

            transaksiDetilService.saveAll(transaksiDetilMap.values());

            jurnalProduksiIjpService.updateNoJurnal(jurnalProduksiIjpDTO.getIdJurnalProduksiIjp(), transaksiMaster.getSumber(), tglJurnal);

            transaksiMasterList.add(transaksiMaster);
        }

        return transaksiMasterList;
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public List<TransaksiMaster> prosesJurnalKlaimSaa(int bulan, int tahun, Date tglJurnal) {
        List<IJurnalProduksiKlaimDTO> jurnalProduksiKlaimDTOList = jurnalProduksiKlaimRepository.getJurnalByStatusByMonthByYear(false, bulan,tahun);
        List<TransaksiMaster> transaksiMasterList = new ArrayList<>(jurnalProduksiKlaimDTOList.size());

        for(IJurnalProduksiKlaimDTO jurnalProduksiKlaimDTO : jurnalProduksiKlaimDTOList){
            TransaksiMaster transaksiMaster = transaksiMasterService.convertFromJurnalKlaimPenDto(jurnalProduksiKlaimDTO, tglJurnal);

            transaksiMasterService.save(transaksiMaster);

            Map<Integer, TransaksiDetil> transaksiDetilMap = null;

            transaksiDetilMap = transaksiDetilService.createTransaksiDetailKlaim(transaksiMaster, jurnalProduksiKlaimDTO);

            transaksiDetilService.saveAll(transaksiDetilMap.values());

            jurnalProduksiKlaimRepository.updateNoJurnal(jurnalProduksiKlaimDTO.getIdJurnalProduksiKlaim(), transaksiMaster.getSumber(), tglJurnal);

            transaksiMasterList.add(transaksiMaster);
        }

        return transaksiMasterList;
    }
}
