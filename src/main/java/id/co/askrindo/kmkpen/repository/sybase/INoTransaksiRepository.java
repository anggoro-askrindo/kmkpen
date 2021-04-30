package id.co.askrindo.kmkpen.repository.sybase;

import id.co.askrindo.kmkpen.model.sybase.NoTransaksi;
import id.co.askrindo.kmkpen.model.sybase.NoTransaksiPK;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.math.BigDecimal;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Repository
public interface INoTransaksiRepository extends IGenericRepository<NoTransaksi, NoTransaksiPK> {
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "SELECT\n" +
            "    *\n" +
            "FROM\n" +
            "    no_transaksi\n" +
            "WHERE\n" +
            "    sbu_id = :sbuId AND tahun = :tahun AND kur_nonkur = :kurNonkur ", nativeQuery = true)
    public NoTransaksi getNoTransaksi(@Param("sbuId") String sbuId, @Param("tahun") BigDecimal tahun, @Param("kurNonkur") String kurNonkur);
}
