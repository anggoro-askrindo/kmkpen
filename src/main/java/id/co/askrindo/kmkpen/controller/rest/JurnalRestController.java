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
 * Created by Anggoro Biandono on 30/04/2021.
 */
@RestController
@RequestMapping("/api/v1/jurnal")
public class JurnalRestController {
    @Autowired
    public IPenjurnalanService penjurnalanService;

    @RequestMapping("/prosesRekapJurnalIjp")
    public List<JurnalProduksiIjp> prosesRekapJurnalIjp(@RequestParam("bulan") Integer bulan,
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

    @RequestMapping("/prosesJurnalIjpSAA")
    public List<TransaksiMaster> prosesJurnalIjpSAA(@RequestParam("bulan") Integer bulan, @RequestParam("tahun") Integer tahun, @RequestParam("tglJurnal") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglJurnal){
        return penjurnalanService.prosesJurnalIjpSaa(bulan, tahun, tglJurnal);
    }

    @RequestMapping("/prosesJurnalKlaimSAA")
    public List<TransaksiMaster> prosesJurnalKlaimSAA(@RequestParam("bulan") Integer bulan, @RequestParam("tahun") Integer tahun, @RequestParam("tglJurnal") @DateTimeFormat(pattern = "dd-MM-yyyy") Date tglJurnal){
        return penjurnalanService.prosesJurnalKlaimSaa(bulan, tahun, tglJurnal);
    }
}
