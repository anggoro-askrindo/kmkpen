package id.co.askrindo.kmkpen.repository.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.PenjaminanIjp;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IPenjaminanIjpRepository extends IGenericRepository<PenjaminanIjp, Long> {
    @Query(value = "SELECT " +
            "    ijp.penjaminan_ijp_id, ijp.id_penjaminan, ijp.tahun_ke, ijp.tgl_premi, ijp.premi, ijp.id_jurnal_produksi_ijp, " +
            "    ijp.status_sikp, ijp.is_koreksi, ijp.is_bayar_djppr " +
            "FROM " +
            "    t_penjaminan penjaminan inner join t_penjaminan_ijp ijp on penjaminan.id_penjaminan = ijp.id_penjaminan " +
            "WHERE " +
            "    penjaminan.status_penjaminan_id = 3 AND ijp.tgl_premi BETWEEN :tglMulai AND :tglAkhir ", nativeQuery = true)
    List<PenjaminanIjp> getPenjaminanIjpByTglPremi(@Param("tglMulai") Date tglMulai, @Param("tglAkhir") Date tglAkhir);

    @Modifying
    @Query(value = "UPDATE\n" +
            "    t_penjaminan_ijp\n" +
            "SET\n" +
            "    id_jurnal_produksi_ijp = SUB.id_jurnal_produksi_ijp\n" +
            "FROM\n" +
            "(\n" +
            "    SELECT\n" +
            "        b.penjaminan_ijp_id, d.id_jurnal_produksi_ijp\n" +
            "    FROM\n" +
            "        t_penjaminan a inner join t_penjaminan_ijp b ON a.id_penjaminan = b.id_penjaminan\n" +
            "        inner join m_cabang c ON a.kode_cabang_askrindo = c.kode_cabang\n" +
            "        AND c.group_id = 2\n" +
            "        inner join t_jurnal_produksi_ijp d ON d.id_cabang = c.id_cabang \n" +
            "        AND d.kode_bank = a.kode_bank\n" +
            "        AND b.is_koreksi = d.is_koreksi\n" +
            "        AND b.tgl_premi BETWEEN d.periode_awal AND d.periode_akhir\n" +
            "    WHERE\n" +
            "        a.status_penjaminan_id = 3 AND b.tgl_premi between :periodeAwal AND :periodeAkhir\n" +
            ") AS SUB\n" +
            "WHERE\n" +
            "    tgl_premi between :periodeAwal AND :periodeAkhir\n" +
            "    AND t_penjaminan_ijp.penjaminan_ijp_id = SUB.penjaminan_ijp_id", nativeQuery = true)
    void updateIdJurnalIjp(@Param("periodeAwal") Date periodeAwal, @Param("periodeAkhir") Date periodeAkhir);
}
