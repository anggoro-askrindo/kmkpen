package id.co.askrindo.kmkpen.repository.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.Klaim;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Anggoro Biandono on 29/04/2021.
 */

@Repository
public interface IKlaimRepository extends IGenericRepository<Klaim, UUID> {
    @Modifying
    @Query(value = "UPDATE\n" +
            "    t_klaim\n" +
            "SET\n" +
            "    id_jurnal_produksi_klaim = SUB.id_jurnal_produksi_klaim\n" +
            "FROM\n" +
            "(\n" +
            "    SELECT\n" +
            "        b.id_klaim, d.id_jurnal_produksi_klaim\n" +
            "    FROM\n" +
            "        t_penjaminan a INNER JOIN t_klaim b ON a.id_penjaminan = b.id_penjaminan\n" +
            "        INNER JOIN m_cabang c ON a.kode_cabang_askrindo = c.kode_cabang\n" +
            "        AND c.group_id = 2\n" +
            "        INNER JOIN t_jurnal_produksi_klaim d ON d.id_cabang = c.id_cabang \n" +
            "        AND d.kode_bank = a.kode_bank\n" +
            "        --AND b.is_koreksi = d.is_koreksi\n" +
            "        AND b.tgl_persetujuan_klaim BETWEEN d.periode_awal AND d.periode_akhir\n" +
            "    WHERE\n" +
            "        b.kode_status = 3 AND b.tgl_persetujuan_klaim BETWEEN :periodeAwal AND :periodeAkhir\n" +
            ") AS SUB\n" +
            "WHERE\n" +
            "    t_klaim.tgl_persetujuan_klaim between :periodeAwal AND :periodeAkhir\n" +
            "    AND t_klaim.id_klaim = SUB.id_klaim ", nativeQuery = true)
    void updateIdJurnalKLaim(@Param("periodeAwal") Date periodeAwal, @Param("periodeAkhir") Date periodeAkhir);
}
