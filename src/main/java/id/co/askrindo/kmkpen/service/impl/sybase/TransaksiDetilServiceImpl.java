package id.co.askrindo.kmkpen.service.impl.sybase;

import id.co.askrindo.kmkpen.model.postgreSql.Klaim;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetil;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetilPK;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMaster;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import id.co.askrindo.kmkpen.repository.sybase.ITransaksiDetilRepository;
import id.co.askrindo.kmkpen.service.sybase.ITransaksiDetilService;
import id.co.askrindo.kmkpen.utils.Constants;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anggoro Biandono on 28/04/2021.
 */

@Service
public class TransaksiDetilServiceImpl extends GenericSybaseSqlServiceImpl<TransaksiDetil, TransaksiDetilPK> implements ITransaksiDetilService {
    private ITransaksiDetilRepository transaksiDetilRepository;

    public TransaksiDetilServiceImpl(ITransaksiDetilRepository transaksiDetilRepository) {
        super(transaksiDetilRepository);
        this.transaksiDetilRepository = transaksiDetilRepository;
    }

    @Override
    public Map<Integer, TransaksiDetil> createTransaksiDetail(TransaksiMaster transaksiMaster, IJurnalProduksiIjpDTO jurnalProduksiIjpDTO){
        Map<Integer, TransaksiDetil> transaksiDetailMap = new HashMap<>();
//        Piutang Premi Program PEN     D   11091
//        Premi Program PEN             C   11164
//        Beban Loss Rasio Program PEN  D   11238
//        Utang Loss Ratio Program PEN  C   11231

//        TransaksiDetilPK pk = new TransaksiDetilPK();
        //TransaksiDetilPK pk = new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 1D);
        //TransaksiDetilPK pk, Double lineNo, TransaksiMaster transaksiMaster, Double perkiraanId, Date tanggal, BigDecimal debet, BigDecimal kredit, BigDecimal flagPosted, String keterangan, BigDecimal bulan, BigDecimal tahun, String idSbuPusat, String sbu_induk
        transaksiDetailMap.put(1, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 1D), Constants.IdCoaPenSAA.PIUTANG_PREMI_PEN, transaksiMaster.getTanggal(), jurnalProduksiIjpDTO.getNilaiIjp(), BigDecimal.ZERO, BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));
        transaksiDetailMap.put(2, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 2D), Constants.IdCoaPenSAA.PREMI_PEN, transaksiMaster.getTanggal(), BigDecimal.ZERO, jurnalProduksiIjpDTO.getNilaiIjp(), BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));
        transaksiDetailMap.put(3, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 3D), Constants.IdCoaPenSAA.BEBAN_LOSS_RASIO_PEN, transaksiMaster.getTanggal(), jurnalProduksiIjpDTO.getNilaiCadangan(), BigDecimal.ZERO, BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));
        transaksiDetailMap.put(4, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 4D), Constants.IdCoaPenSAA.UTANG_LOSS_RASIO_PEN, transaksiMaster.getTanggal(), BigDecimal.ZERO, jurnalProduksiIjpDTO.getNilaiCadangan(), BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));

        return transaksiDetailMap;
    }

    @Override
    public Map<Integer, TransaksiDetil> createTransaksiDetailKlaim(TransaksiMaster transaksiMaster, IJurnalProduksiKlaimDTO jurnalProduksiKlaimDTO) {
        Map<Integer, TransaksiDetil> transaksiDetailMap = new HashMap<>();
//        Klaim PEN                 D   11324
//        Utang Klaim Program PEN   C   11121

        transaksiDetailMap.put(1, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 1D), Constants.IdCoaPenSAA.KLAIM_PEN, transaksiMaster.getTanggal(), jurnalProduksiKlaimDTO.getNilaiKlaim(), BigDecimal.ZERO, BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));
        transaksiDetailMap.put(2, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 2D), Constants.IdCoaPenSAA.UTANG_KLAIM_PEN, transaksiMaster.getTanggal(), BigDecimal.ZERO, jurnalProduksiKlaimDTO.getNilaiKlaim(), BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));

        return transaksiDetailMap;
    }

    @Override
    public Map<Integer, TransaksiDetil> createTransaksiDetailKoreksi(TransaksiMaster transaksiMaster, IJurnalProduksiIjpDTO jurnalProduksiIjpDTO){
        Map<Integer, TransaksiDetil> transaksiDetailMap = new HashMap<>();
//        Premi Program PEN	            D   11091
//        Piutang Premi Program PEN		C   11164
//        Utang Loss Ratio Program PEN	D   11238
//        Beban Loss Rasio Program PEN	C   11231

        //TransaksiDetilPK pk, Double lineNo, TransaksiMaster transaksiMaster, Double perkiraanId, Date tanggal, BigDecimal debet, BigDecimal kredit, BigDecimal flagPosted, String keterangan, BigDecimal bulan, BigDecimal tahun, String idSbuPusat, String sbu_induk
//        TransaksiDetilPK pk = new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR);
        transaksiDetailMap.put(1, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 1D), Constants.IdCoaPenSAA.PREMI_PEN, transaksiMaster.getTanggal(), jurnalProduksiIjpDTO.getNilaiIjp(), BigDecimal.ZERO, BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));
        transaksiDetailMap.put(2, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 2D), Constants.IdCoaPenSAA.PIUTANG_PREMI_PEN, transaksiMaster.getTanggal(), BigDecimal.ZERO, jurnalProduksiIjpDTO.getNilaiIjp(), BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));
        transaksiDetailMap.put(3, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 3D), Constants.IdCoaPenSAA.UTANG_LOSS_RASIO_PEN, transaksiMaster.getTanggal(), jurnalProduksiIjpDTO.getNilaiCadangan(), BigDecimal.ZERO, BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));
        transaksiDetailMap.put(4, new TransaksiDetil(new TransaksiDetilPK(transaksiMaster.getPk().getTransaksiId(), transaksiMaster.getPk().getSbuId(), Constants.KodeKurNonKurSAA.NON_KUR, 4D), Constants.IdCoaPenSAA.BEBAN_LOSS_RASIO_PEN, transaksiMaster.getTanggal(), BigDecimal.ZERO, jurnalProduksiIjpDTO.getNilaiCadangan(), BigDecimal.ZERO, transaksiMaster.getKeterangan(), transaksiMaster.getBulan(), transaksiMaster.getTahun(), transaksiMaster.getIdSbuPusat(), transaksiMaster.getSbuInduk()));

        return transaksiDetailMap;
    }
}
