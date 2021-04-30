package id.co.askrindo.kmkpen.service.sybase;

import id.co.askrindo.kmkpen.model.sybase.NoSumber;
import id.co.askrindo.kmkpen.model.sybase.NoSumberPK;
import id.co.askrindo.kmkpen.service.IGenericService;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

/**
 * Created by Anggoro Biandono on 28/04/2021.
 */

public interface INoSumberService extends IGenericService<NoSumber, NoSumberPK> {
    /***
     * Fungsi Untuk mendapatkan objek no sumber dengan kolom sumber / no urut yang sudah ter-increment
     * Jika saat pengecekan tidak terdapat data no sumber berdasarkan parameter, maka akan dibentuk record baru dengan kolom sumber = 1
     * Jika ada maka akan mengupdate kolom sumber untuk di tambahkan sebesar 1
     * @param sbuId kode cabang
     * @param tahun tahun posting
     * @param bulan bulan posting
     * @param kodeJurnal BD (Bank Debet) , MM (Memorial); kur_nonkur : 1 (Non Kur), 2 (Kur); sbu_id : kantor; tahun : tahun jurnal; bulan : bulan jurnal
     * @param kurNonkur 1 Non Kur; 2 Kur
     * @param idPerkiraan id perkiraan jurnal
     * @return objek no sumber
     */
    public NoSumber getNoSumber(String sbuId, BigDecimal tahun, BigDecimal bulan, String kodeJurnal, String kurNonkur, Double idPerkiraan);

    /***
     * Generate no sumber / no jurnal berdasarkan format kd_jurnal + kur_nonkur + '.' + sbu_id + '.'+ tahun + '.' + right( '00' + bulan, 2 ) +'/'+Right( "00000" + urutan, 5 ) contoh : MM1.11.2019.01/00013
     * @param sbuId kode cabang
     * @param tahun tahun posting
     * @param bulan bulan posting
     * @param kodeJurnal BD (Bank Debet) , MM (Memorial); kur_nonkur : 1 (Non Kur), 2 (Kur); sbu_id : kantor; tahun : tahun jurnal; bulan : bulan jurnal
     * @param kurNonkur 1 Non Kur; 2 Kur
     * @param idPerkiraan id perkiraan jurnal
     * @return String no sumber yang sudah diformat
     */
    public String generateNoSumber(String sbuId, BigDecimal tahun, BigDecimal bulan, String kodeJurnal, String kurNonkur, Double idPerkiraan);
}
