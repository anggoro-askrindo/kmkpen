package id.co.askrindo.kmkpen.repository.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiIjp;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IRincianJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IJurnalProduksiIjpRepository extends IGenericRepository<JurnalProduksiIjp, Long> {
    @Query(value = "SELECT " +
                    "    cabang_ask.id_cabang AS idCabang, " +
                    "    bank.kode_bank AS kodeBank, " +
                    "    :bulan AS bulan, :tahun AS tahun, " +
                    "    TO_DATE(:tglPremiAwal,'yyyy-MM-dd') AS periodeAwal, " +
                    "    TO_DATE(:tglPremiAkhir,'yyyy-MM-dd') AS periodeAkhir, " +
                    "    SUM(ijp.premi) AS nilaiIjp, " +
                    "    SUM(ijp.cadangan) AS nilaiCadangan, " +
                    "    ijp.is_koreksi AS koreksi " +
                    "FROM " +
                    "    t_penjaminan penjaminan inner join t_penjaminan_ijp ijp on penjaminan.id_penjaminan = ijp.id_penjaminan " +
                    "    inner join m_bank bank on penjaminan.kode_bank = bank.kode_bank " +
                    "    inner join m_cabang cabang_ask on penjaminan.kode_cabang_askrindo = cabang_ask.kode_cabang " +
                    "    and cabang_ask.group_id = 2 " +
                    "WHERE " +
                    "    penjaminan.status_penjaminan_id = 3  AND ijp.tgl_premi between :tglPremiAwal AND :tglPremiAkhir " +
                    "GROUP BY " +
                    "    cabang_ask.id_cabang, bank.kode_bank, ijp.is_koreksi " +
                    "ORDER BY " +
                    "    cabang_ask.id_cabang, bank.kode_bank", nativeQuery = true)
    public List<IJurnalProduksiIjpDTO> getJurnalProduksiIjpListFromRincian(@Param("bulan") int bulan, @Param("tahun") int tahun, @Param("tglPremiAwal") Date tglPremiAwal, @Param("tglPremiAkhir") Date tglPremiAkhir);

    @Query(value = "SELECT " +
            "    ijp.penjaminan_ijp_id AS penjaminanIjpId, " +
            "    cabang_ask.id_cabang AS idCabang, " +
            "    bank.kode_bank AS kodeBank, " +
            "    :bulan AS bulan, :tahun AS tahun, " +
            "    TO_DATE(:tglPremiAwal,'yyyy-MM-dd') AS periodeAwal, " +
            "    TO_DATE(:tglPremiAkhir,'yyyy-MM-dd') AS periodeAkhir, " +
            "    ijp.premi AS nilaiIjp, " +
            "    ijp.cadangan AS nilaiCadangan, " +
            "    ijp.is_koreksi AS koreksi " +
            "FROM " +
            "    t_penjaminan penjaminan inner join t_penjaminan_ijp ijp on penjaminan.id_penjaminan = ijp.id_penjaminan " +
            "    inner join m_bank bank on penjaminan.kode_bank = bank.kode_bank " +
            "    inner join m_cabang cabang_ask on penjaminan.kode_cabang_askrindo = cabang_ask.kode_cabang " +
            "    and cabang_ask.group_id = 2 " +
            "WHERE " +
            "    penjaminan.status_penjaminan_id = 3  AND ijp.tgl_premi between :tglPremiAwal AND :tglPremiAkhir " +
            "ORDER BY " +
            "    cabang_ask.id_cabang, bank.kode_bank, ijp.is_koreksi", nativeQuery = true)
    public List<IRincianJurnalProduksiIjpDTO> getRincianJurnalProduksiIjpListFromRincian(@Param("bulan") int bulan, @Param("tahun") int tahun, @Param("tglPremiAwal") Date tglPremiAwal, @Param("tglPremiAkhir") Date tglPremiAkhir);

    @Query(value = "SELECT " +
            "    COALESCE(MAX(id_jurnal_produksi_ijp), 0) AS maxId " +
            "FROM " +
            "    t_jurnal_produksi_ijp", nativeQuery = true)
    public Long getMaxIdVal();

    @Query(value = "SELECT\n" +
            "    a.id_jurnal_produksi_ijp AS idJurnalProduksiIjp, \n" +
            "    b.kode_cabang AS kodeCabang, \n" +
            "    a.kode_bank AS kodeBank, \n" +
            "    c.nama_bank AS namaBank, \n" +
            "    a.bulan AS bulan, \n" +
            "    a.tahun AS tahun, \n" +
            "    a.nilai_ijp AS nilaiIjp, \n" +
            "    a.nilai_cadangan AS nilaiCadangan,\n" +
            "    a.is_koreksi AS koreksi\n" +
            "FROM\n" +
            "    t_jurnal_produksi_ijp a INNER JOIN m_cabang b ON a.id_cabang = b.id_cabang\n" +
            "    INNER JOIN m_bank c ON a.kode_bank = c.kode_bank\n" +
            "WHERE\n" +
            "    status = :status AND bulan = :bulan AND tahun =:tahun ", nativeQuery = true)
    public List<IJurnalProduksiIjpDTO> getJurnalByStatusByMonthByYear(@Param("status") Boolean status, @Param("bulan") int bulan, @Param("tahun") int tahun);

    @Modifying
    @Query(value = "UPDATE\n" +
            "    t_jurnal_produksi_ijp\n" +
            "SET\n" +
            "    no_jurnal = :noJurnal , no_jurnal_loss_limit = :noJurnal, tgl_jurnal = :tglJurnal, status = true, modified_by = 'system', modified_date = current_date, version = version + 1 \n" +
            "WHERE\n" +
            "    id_jurnal_produksi_ijp = :idJurnalProduksiIjp", nativeQuery = true)
    public void updateNoJurnal(@Param("idJurnalProduksiIjp") Long idJurnalProduksiIjp, @Param("noJurnal") String noJurnal, @Param("tglJurnal") Date tglJurnal);
}
