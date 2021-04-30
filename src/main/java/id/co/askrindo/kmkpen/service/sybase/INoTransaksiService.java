package id.co.askrindo.kmkpen.service.sybase;

import id.co.askrindo.kmkpen.model.sybase.NoTransaksi;
import id.co.askrindo.kmkpen.model.sybase.NoTransaksiPK;
import id.co.askrindo.kmkpen.service.IGenericService;

import java.math.BigDecimal;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */
public interface INoTransaksiService extends IGenericService<NoTransaksi, NoTransaksiPK> {
    /***
     * Fungsi Untuk mendapatkan objek no transaksi dengan no registrasi / no urut yang sudah terincrement
     * Jika saat pengecekan tidak terdapat data no transaksi berdasarkan parameter, maka akan dibentuk record baru dengan no reg = 1
     * Jika ada maka akan mengupdate no reg untuk di tambahkan sebesar 1
     * @param sbuId kode cabang
     * @param tahun tahun posting
     * @param kurNonkur 1 Non Kur; 2 Kur
     * @return objek no transaksi
     */
    public NoTransaksi getNoTransaksi(String sbuId, BigDecimal tahun, String kurNonkur);

    /***
     * Generate no trnasaksi berdasarkan format sbu_id + kur_nonkur + tahun + Right( "00000" + n_transaksi, 5 ) contoh : 111201900022
     * @param sbuId kode cabang
     * @param tahun tahun posting
     * @param kurNonkur 1 Non Kur; 2 Kur
     * @return String no transaksi yang sudah diformat
     */
    public String generateNoTransaksi(String sbuId, BigDecimal tahun, String kurNonkur);
}
