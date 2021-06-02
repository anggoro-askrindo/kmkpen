package id.co.askrindo.kmkpen.repository.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiKlaim;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 29/04/2021.
 */

@Repository
public interface IJurnalProduksiKlaimRepository extends IGenericRepository<JurnalProduksiKlaim, Long> {
    @Query(value = "SELECT\n" +
            "    cabang_ask.id_cabang AS idCabang, \n" +
            "    cabang_ask.kode_cabang AS kodeCabang, \n" +
            "    bank.kode_bank AS kodeBank, \n" +
            "    bank.nama_bank AS namaBank,\n" +
            "    :bulan AS bulan, :tahun AS tahun, \n" +
            "    TO_DATE(:tglPremiAwal,'yyyy-MM-dd') AS periodeAwal,\n" +
            "    TO_DATE(:tglPremiAkhir,'yyyy-MM-dd') AS periodeAkhir,\n" +
            "    klaim.klaim_disetujui as nilaiKlaim,\n" +
            "    false AS koreksi\n" +
            "FROM\n" +
            "    t_penjaminan penjaminan inner join t_klaim klaim on penjaminan.id_penjaminan = klaim.id_penjaminan\n" +
            "    inner join m_bank bank on penjaminan.kode_bank = bank.kode_bank\n" +
            "    inner join m_cabang cabang_ask on penjaminan.kode_cabang_askrindo = cabang_ask.kode_cabang\n" +
            "    and cabang_ask.group_id = 2\n" +
            "WHERE\n" +
            "    klaim.kode_status = 3  AND klaim.tgl_persetujuan_klaim between :tglPremiAwal AND :tglPremiAkhir AND klaim.id_jurnal_produksi_klaim IS NULL \n" +
            "ORDER BY\n" +
            "    cabang_ask.id_cabang, bank.kode_bank", nativeQuery = true)
    public List<IJurnalProduksiKlaimDTO> getRincianJurnalProduksiIjpListFromRincian(@Param("bulan") int bulan, @Param("tahun") int tahun, @Param("tglPremiAwal") Date tglPremiAwal, @Param("tglPremiAkhir") Date tglPremiAkhir);

    @Query(value = "SELECT\n" +
            "    COALESCE(MAX(id_jurnal_produksi_klaim), 0) AS maxId\n" +
            "FROM\n" +
            "    t_jurnal_produksi_klaim ", nativeQuery = true)
    public Long getMaxIdVal();

    @Query(value = "SELECT\n" +
            "    a.id_jurnal_produksi_klaim AS idJurnalProduksiKlaim, \n" +
            "    b.kode_cabang AS kodeCabang, \n" +
            "    a.kode_bank AS kodeBank, \n" +
            "    c.nama_bank AS namaBank, \n" +
            "    a.bulan AS bulan, \n" +
            "    a.tahun AS tahun, \n" +
            "    a.nilai_klaim AS nilaiKlaim, \n" +
            "    a.is_koreksi AS koreksi\n" +
            "FROM\n" +
            "    t_jurnal_produksi_klaim a INNER JOIN m_cabang b ON a.id_cabang = b.id_cabang\n" +
            "    INNER JOIN m_bank c ON a.kode_bank = c.kode_bank\n" +
            "WHERE\n" +
            "    status = :status AND bulan = :bulan AND tahun =:tahun ", nativeQuery = true)
    public List<IJurnalProduksiKlaimDTO> getJurnalByStatusByMonthByYear(@Param("status") Boolean status, @Param("bulan") int bulan, @Param("tahun") int tahun);

    @Modifying
    @Query(value = "UPDATE\n" +
            "    t_jurnal_produksi_klaim\n" +
            "SET\n" +
            "    no_jurnal = :noJurnal , tgl_jurnal = :tglJurnal, status = true, modified_by = 'system', modified_date = current_date, version = version + 1 \n" +
            "WHERE\n" +
            "    id_jurnal_produksi_klaim = :idJurnalProduksiKlaim", nativeQuery = true)
    public void updateNoJurnal(@Param("idJurnalProduksiKlaim") Long idJurnalProduksiKlaim, @Param("noJurnal") String noJurnal, @Param("tglJurnal") Date tglJurnal);
}
