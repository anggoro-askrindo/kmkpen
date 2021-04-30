package id.co.askrindo.kmkpen.service.impl.sybase;

import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetil;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetilPK;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMaster;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMasterPK;
import id.co.askrindo.kmkpen.repository.sybase.ITransaksiMasterRepository;
import id.co.askrindo.kmkpen.service.sybase.INoSumberService;
import id.co.askrindo.kmkpen.service.sybase.INoTransaksiService;
import id.co.askrindo.kmkpen.service.sybase.ITransaksiMasterService;
import id.co.askrindo.kmkpen.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Service
public class TransaksiMasterServiceImpl extends GenericSybaseSqlServiceImpl<TransaksiMaster, TransaksiMasterPK> implements ITransaksiMasterService {
    private ITransaksiMasterRepository transaksiMasterRepository;

    @Autowired
    private INoTransaksiService noTransaksiService;

    @Autowired
    private INoSumberService noSumberService;

    @Autowired
    public TransaksiMasterServiceImpl(ITransaksiMasterRepository transaksiMasterRepository) {
        super(transaksiMasterRepository);
        this.transaksiMasterRepository = transaksiMasterRepository;
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public TransaksiMaster convertFromJurnalIjpPenDto(IJurnalProduksiIjpDTO jurnalProduksiIjpDTO, Date tglJurnal) {
        TransaksiMaster transaksiMaster = new TransaksiMaster();
        String noTransaksi = noTransaksiService.generateNoTransaksi(jurnalProduksiIjpDTO.getKodeCabang(), BigDecimal.valueOf(jurnalProduksiIjpDTO.getTahun()), Constants.KodeKurNonKurSAA.NON_KUR);
        TransaksiMasterPK pk = new TransaksiMasterPK(noTransaksi, jurnalProduksiIjpDTO.getKodeCabang(), Constants.KodeKurNonKurSAA.NON_KUR);
        transaksiMaster.setPk(pk);

        transaksiMaster.setTanggal(tglJurnal);
        transaksiMaster.setSumber(noSumberService.generateNoSumber(jurnalProduksiIjpDTO.getKodeCabang(), BigDecimal.valueOf(jurnalProduksiIjpDTO.getTahun()), BigDecimal.valueOf(jurnalProduksiIjpDTO.getBulan()), Constants.KodeJurnalSAA.MEMORIAL, Constants.KodeKurNonKurSAA.NON_KUR, 0D));

        StringBuffer keteranganSB = new StringBuffer();

        //private Double userId;
        transaksiMaster.setUserId(13D); //Ini dummy sementara harus dirubah
        transaksiMaster.setTanggalEntri(tglJurnal);
        transaksiMaster.setBulan(BigDecimal.valueOf(jurnalProduksiIjpDTO.getBulan()));
        transaksiMaster.setTahun(BigDecimal.valueOf(jurnalProduksiIjpDTO.getTahun()));
        transaksiMaster.setJumlah(jurnalProduksiIjpDTO.getNilaiIjp().add(jurnalProduksiIjpDTO.getNilaiCadangan()));
        transaksiMaster.setsUnit(transaksiMasterRepository.getUnitId(jurnalProduksiIjpDTO.getKodeCabang()));
        transaksiMaster.setSbuInduk(jurnalProduksiIjpDTO.getKodeCabang());
        transaksiMaster.setIdSbuPusat("KP");

        //Create transaksi detail
        Map<Integer, TransaksiDetil> transaksiDetilMap;

        if(jurnalProduksiIjpDTO.getKoreksi()) {
            keteranganSB.append("Koreksi ");
        }else {
            keteranganSB.append("Mencatat ");
        }

        keteranganSB.append("IJP PEN dan Beban Loss Rasio bulan ")
                .append(Constants.getNamaBulanMap().get(jurnalProduksiIjpDTO.getBulan()))
                .append(" ").append(jurnalProduksiIjpDTO.getNamaBank());

        transaksiMaster.setKeterangan(keteranganSB.toString());

        return transaksiMaster;
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public TransaksiMaster convertFromJurnalKlaimPenDto(IJurnalProduksiKlaimDTO jurnalProduksiKlaimDTO, Date tglJurnal) {
        TransaksiMaster transaksiMaster = new TransaksiMaster();
        String noTransaksi = noTransaksiService.generateNoTransaksi(jurnalProduksiKlaimDTO.getKodeCabang(), BigDecimal.valueOf(jurnalProduksiKlaimDTO.getTahun()), Constants.KodeKurNonKurSAA.NON_KUR);
        TransaksiMasterPK pk = new TransaksiMasterPK(noTransaksi, jurnalProduksiKlaimDTO.getKodeCabang(), Constants.KodeKurNonKurSAA.NON_KUR);
        transaksiMaster.setPk(pk);

        transaksiMaster.setTanggal(tglJurnal);
        transaksiMaster.setSumber(noSumberService.generateNoSumber(jurnalProduksiKlaimDTO.getKodeCabang(), BigDecimal.valueOf(jurnalProduksiKlaimDTO.getTahun()), BigDecimal.valueOf(jurnalProduksiKlaimDTO.getBulan()), Constants.KodeJurnalSAA.MEMORIAL, Constants.KodeKurNonKurSAA.NON_KUR, 0D));

        StringBuffer keteranganSB = new StringBuffer();

        //private Double userId;
        transaksiMaster.setUserId(13D); //Ini dummy sementara harus dirubah
        transaksiMaster.setTanggalEntri(tglJurnal);
        transaksiMaster.setBulan(BigDecimal.valueOf(jurnalProduksiKlaimDTO.getBulan()));
        transaksiMaster.setTahun(BigDecimal.valueOf(jurnalProduksiKlaimDTO.getTahun()));
        transaksiMaster.setJumlah(jurnalProduksiKlaimDTO.getNilaiKlaim());
        transaksiMaster.setsUnit(transaksiMasterRepository.getUnitId(jurnalProduksiKlaimDTO.getKodeCabang()));
        transaksiMaster.setSbuInduk(jurnalProduksiKlaimDTO.getKodeCabang());
        transaksiMaster.setIdSbuPusat("KP");

        //Create transaksi detail
        Map<Integer, TransaksiDetil> transaksiDetilMap;

        if(jurnalProduksiKlaimDTO.getKoreksi()) {
            keteranganSB.append("Koreksi ");
        }else {
            keteranganSB.append("Mencatat ");
        }

        keteranganSB.append("Produksi Klaim PEN bulan ")
                .append(Constants.getNamaBulanMap().get(jurnalProduksiKlaimDTO.getBulan()))
                .append(" ").append(jurnalProduksiKlaimDTO.getNamaBank());

        transaksiMaster.setKeterangan(keteranganSB.toString());

        return transaksiMaster;
    }
}
