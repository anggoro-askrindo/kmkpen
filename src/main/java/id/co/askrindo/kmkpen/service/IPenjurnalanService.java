package id.co.askrindo.kmkpen.service;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiIjp;
import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiKlaim;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMaster;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */
public interface IPenjurnalanService {
    public List<JurnalProduksiIjp> prosesRekapJurnalProduksiIjp(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir);
    public List<JurnalProduksiKlaim> prosesRekapJurnalProduksiKlaim(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir);
    public List<TransaksiMaster> prosesJurnalIjpSaa(int bulan, int tahun, Date tglJurnal);
    public List<TransaksiMaster> prosesJurnalKlaimSaa(int bulan, int tahun, Date tglJurnal);
}
