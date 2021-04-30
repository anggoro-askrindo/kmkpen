package id.co.askrindo.kmkpen.repository.sybase;

import id.co.askrindo.kmkpen.model.sybase.NoSumber;
import id.co.askrindo.kmkpen.model.sybase.NoSumberPK;
import id.co.askrindo.kmkpen.model.sybase.NoTransaksi;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import id.co.askrindo.kmkpen.utils.Constants;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.LockModeType;
import java.math.BigDecimal;

/**
 * Created by Anggoro Biandono on 28/04/2021.
 */

@Repository
public interface INoSumberRepository extends IGenericRepository<NoSumber, NoSumberPK> {
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "SELECT\n" +
            "    *\n" +
            "FROM\n" +
            "    no_sumber\n" +
            "WHERE\n" +
            "    sbu_id = :sbuId AND tahun = :tahun AND bulan = :bulan AND kode_jurnal = :kodeJurnal AND kur_nonkur = :kurNonkur AND id_perkiraan = :idPerkiraan ", nativeQuery = true)
    public NoSumber getSumberByPk(@Param("sbuId") String sbuId, @Param("tahun") BigDecimal tahun, @Param("bulan") BigDecimal bulan, @Param("kodeJurnal") String kodeJurnal, @Param("kurNonkur") String kurNonkur, @Param("idPerkiraan") Double idPerkiraan);


}
