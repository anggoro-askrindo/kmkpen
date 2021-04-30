package id.co.askrindo.kmkpen.service.impl.sybase;

import id.co.askrindo.kmkpen.model.sybase.NoTransaksi;
import id.co.askrindo.kmkpen.model.sybase.NoTransaksiPK;
import id.co.askrindo.kmkpen.repository.sybase.INoTransaksiRepository;
import id.co.askrindo.kmkpen.service.sybase.INoTransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Service
public class NoTransaksiServiceImpl extends GenericSybaseSqlServiceImpl<NoTransaksi, NoTransaksiPK> implements INoTransaksiService {
    private INoTransaksiRepository noTransaksiRepository;

    @Autowired
    public NoTransaksiServiceImpl(INoTransaksiRepository noTransaksiRepository) {
        super(noTransaksiRepository);
        this.noTransaksiRepository = noTransaksiRepository;
    }

    /***
     * Fungsi Untuk mendapatkan objek no transaksi dengan no registrasi / no urut yang sudah terincrement
     * Jika saat pengecekan tidak terdapat data no transaksi berdasarkan parameter, maka akan dibentuk record baru dengan no reg = 1
     * Jika ada maka akan mengupdate no reg untuk di tambahkan sebesar 1
     * @param sbuId kode cabang
     * @param tahun tahun posting
     * @param kurNonkur 1 Non Kur; 2 Kur
     * @return objek no transaksi
     */
    @Override
    public NoTransaksi getNoTransaksi(String sbuId, BigDecimal tahun, String kurNonkur) {
        NoTransaksi noTransaksi = noTransaksiRepository.getNoTransaksi(sbuId, tahun, kurNonkur);

        if(noTransaksi != null){
            noTransaksi.setNoreg(noTransaksi.getNoreg().add(BigDecimal.ONE));
        }else{
            noTransaksi = new NoTransaksi(sbuId, tahun, kurNonkur);
            noTransaksi.setNoreg(BigDecimal.ONE);
        }

        noTransaksiRepository.save(noTransaksi);

        return noTransaksi;
    }

    /***
     * Generate no trnasaksi berdasarkan format sbu_id + kur_nonkur + tahun + Right( "00000" + n_transaksi, 5 ) contoh : 111201900022
     * @param sbuId kode cabang
     * @param tahun tahun posting
     * @param kurNonkur 1 Non Kur; 2 Kur
     * @return String no transaksi yang sudah diformat
     */
    @Override
    @Transactional("sybaseSqlTransactionManager")
    public String generateNoTransaksi(String sbuId, BigDecimal tahun, String kurNonkur) {
        NoTransaksi noTransaksi = getNoTransaksi(sbuId, tahun, kurNonkur);

        Object[] arguments = new Object[4];

        arguments[0] = noTransaksi.getPk().getSbuId();
        arguments[1] = noTransaksi.getPk().getKurNonkur();
        arguments[2] = noTransaksi.getPk().getTahun().toPlainString();
        arguments[3] = noTransaksi.getNoreg();

        String number = MessageFormat.format(NoTransaksi.TRANSAKSI_ID_PATTERN, arguments);

        return number;
    }
}
