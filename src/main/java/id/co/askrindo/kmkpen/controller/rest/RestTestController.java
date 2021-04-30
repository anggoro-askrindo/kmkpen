package id.co.askrindo.kmkpen.controller.rest;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiIjp;
import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiKlaim;
import id.co.askrindo.kmkpen.model.postgreSql.PenjaminanIjp;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMaster;
import id.co.askrindo.kmkpen.repository.postgreSql.IJurnalProduksiKlaimRepository;
import id.co.askrindo.kmkpen.service.IPenjurnalanService;
import id.co.askrindo.kmkpen.service.postgreSql.IJurnalProduksiIjpService;
import id.co.askrindo.kmkpen.service.postgreSql.IPenjaminanIjpService;
import id.co.askrindo.kmkpen.service.sybase.INoSumberService;
import id.co.askrindo.kmkpen.service.sybase.INoTransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@RestController
@RequestMapping("/api/v1/test")
public class RestTestController {
    @Autowired
    public IPenjaminanIjpService penjaminanIjpService;

    @Autowired
    public IJurnalProduksiIjpService jurnalProduksiIjpService;

    @Autowired
    public IPenjurnalanService penjurnalanService;

    @Autowired
    public INoSumberService noSumberService;

    @Autowired
    public INoTransaksiService noTransaksiService;

    @Autowired
    public IJurnalProduksiKlaimRepository jurnalProduksiKlaimRepository;

    @RequestMapping("/ping")
    public String ping(){
        return "Hello World";
    }

    @RequestMapping("/getRincianJurnal")
    public List<PenjaminanIjp> index(@RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                     @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir){
        return penjaminanIjpService.getPenjaminanIjpByTglPremi(tglMulai, tglAkhir);
    }

    @RequestMapping("/getJurnalProduksiIjp")
    public List<IJurnalProduksiIjpDTO> getJurnalProduksiIjp(@RequestParam("bulan") Integer bulan,
                                                            @RequestParam("tahun") Integer tahun,
                                                            @RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                                            @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir){
        return jurnalProduksiIjpService.getJurnalProduksiIjpListFromRincian(bulan, tahun, tglMulai, tglAkhir);
    }

    @RequestMapping("/prosesJurnal")
    public List<JurnalProduksiIjp> prosesJunal(@RequestParam("bulan") Integer bulan,
                                                            @RequestParam("tahun") Integer tahun,
                                                            @RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                                            @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir){
        return penjurnalanService.prosesRekapJurnalProduksiIjp(bulan, tahun, tglMulai, tglAkhir);
    }

    @RequestMapping("/prosesRekapJurnalKlaim")
    public List<JurnalProduksiKlaim> prosesRekapJurnalKlaim(@RequestParam("bulan") Integer bulan,
                                                            @RequestParam("tahun") Integer tahun,
                                                            @RequestParam("tglMulai") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglMulai,
                                                            @RequestParam("tglAkhir") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglAkhir){
        return penjurnalanService.prosesRekapJurnalProduksiKlaim(bulan, tahun, tglMulai, tglAkhir);
    }

    @RequestMapping("/generateNoJurnal")
    public String generateNoJurnal(@RequestParam("sbuId") String sbuId,
                                   @RequestParam("tahun") BigDecimal tahun,
                                   @RequestParam("bulan") BigDecimal bulan,
                                   @RequestParam("kodeJurnal") String kodeJurnal,
                                   @RequestParam("kurNonkur") String kurNonkur,
                                   @RequestParam("idPerkiraan") Double idPerkiraan){
        return noSumberService.generateNoSumber(sbuId, tahun, bulan, kodeJurnal, kurNonkur, idPerkiraan);
    }

    @RequestMapping("/generateIdTransaksi")
    public String generateIdTransaksi(@RequestParam("sbuId") String sbuId,
                                   @RequestParam("tahun") BigDecimal tahun,
                                   @RequestParam("kurNonkur") String kurNonkur){
        return noTransaksiService.generateNoTransaksi(sbuId, tahun, kurNonkur);
    }

    @RequestMapping("/getUnprosesJurnal")
    public List<IJurnalProduksiIjpDTO> unprosesJurnal(@RequestParam("status") Boolean status, @RequestParam("bulan") Integer bulan, @RequestParam("tahun") Integer tahun){
        return jurnalProduksiIjpService.getJurnalByStatusByMonthByYear(status, bulan, tahun);
    }

    @RequestMapping("/prosesJurnalSAA")
    public List<TransaksiMaster> prosesJurnalSAA(@RequestParam("bulan") Integer bulan, @RequestParam("tahun") Integer tahun, @RequestParam("tglJurnal") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglJurnal){
        return penjurnalanService.prosesJurnalIjpSaa(bulan, tahun, tglJurnal);
    }

    @RequestMapping("/prosesJurnalKlaimSAA")
    public List<TransaksiMaster> prosesJurnalKlaimSAA(@RequestParam("bulan") Integer bulan, @RequestParam("tahun") Integer tahun, @RequestParam("tglJurnal") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglJurnal){
        return penjurnalanService.prosesJurnalKlaimSaa(bulan, tahun, tglJurnal);
    }
}
