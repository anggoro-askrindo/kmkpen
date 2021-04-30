package id.co.askrindo.kmkpen.repository.sybase;

import id.co.askrindo.kmkpen.model.sybase.NoTransaksi;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMaster;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMasterPK;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Repository
public interface ITransaksiMasterRepository extends IGenericRepository<TransaksiMaster, TransaksiMasterPK> {
    @Query(value = "SELECT TOP 1\n" +
            "    unit_id\n" +
            "FROM  \n" +
            "    password_master\n" +
            "WHERE \n" +
            "    password_master.sbu_id = :sbuId ", nativeQuery = true)
    public String getUnitId(@Param("sbuId") String sbuId);
}
