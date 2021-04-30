package id.co.askrindo.kmkpen.model.postgreSql;

/**
 * Created by Anggoro Biandono on 29/04/2021.
 */

import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_jurnal_produksi_klaim")
public class JurnalProduksiKlaim implements Serializable {
    private static final long serialVersionUID = 5299113914569380361L;

    // COLUMN_NAME                                                                DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT
    // -------------------------------------------------------------------------  ---------  -----------  --------------  ----------  --------  -------------------------------------------------------------------------
    // id_jurnal_produksi_klaim                                                   int8                                                NO        nextval('t_jurnal_produksi_klaim_id_jurnal_produksi_klaim_seq'::regclass)
    @Id
    @Column(name = "id_jurnal_produksi_klaim")
    private Long idJurnalProduksiKlaim;

    // id_cabang                                                                  varchar    10                                       NO
    @Column(name = "id_cabang")
    private String id_cabang;

    // kode_bank                                                                  varchar    8                                        NO
    @Column(name = "kode_bank")
    private String kodeBank;

    // bulan                                                                  int2                                                NO
    @Column(name = "bulan")
    private Integer bulan;

    // tahun                                                                  int2                                                NO
    @Column(name = "tahun")
    private Integer tahun;

    // periode_awal                                                           date                                                NO
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "periode_awal")
    private Date periodeAwal;

    // periode_akhir                                                          date                                                NO
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "periode_akhir")
    private Date periodeAkhir;

    // nilai_klaim                                                                numeric                 18              2           NO        0
    @Column(name = "nilai_klaim", length = 18, precision = 2)
    private BigDecimal nilaiKlaim;

    // no_jurnal                                                                  varchar    100                                      YES
    @Column(name = "no_jurnal")
    private String noJurnal;

    // tgl_jurnal                                                                 date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_jurnal")
    private Date tglJurnal;

    // status                                                                 bool                                                NO        false
    @Column(name = "status")
    private Boolean status;

    // version                                                                int2                                                NO        1
    @Column(name = "version")
    private Integer version;

    // created_by                                                             varchar    20                                       NO
    @Column(name = "created_by")
    private String createdBy;

    // created_date                                                           timestamp                                           NO        now()
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    // modified_by                                                            varchar    20                                       YES
    @Column(name = "modified_by")
    private String modifiedBy;

    // modified_date                                                          timestamp                                           YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    public JurnalProduksiKlaim() {
    }

    public JurnalProduksiKlaim(IJurnalProduksiKlaimDTO dto) {
        this.id_cabang = dto.getIdCabang();
        this.kodeBank = dto.getKodeBank();
        this.bulan = dto.getBulan();
        this.tahun = dto.getTahun();
        this.periodeAwal = dto.getPeriodeAwal();
        this.periodeAkhir = dto.getPeriodeAkhir();
        this.nilaiKlaim = dto.getNilaiKlaim();
        this.noJurnal = dto.getNoJurnal();
        this.tglJurnal = dto.getTglJurnal();
    }

    public Long getIdJurnalProduksiKlaim() {
        return idJurnalProduksiKlaim;
    }

    public void setIdJurnalProduksiKlaim(Long idJurnalProduksiKlaim) {
        this.idJurnalProduksiKlaim = idJurnalProduksiKlaim;
    }

    public String getId_cabang() {
        return id_cabang;
    }

    public void setId_cabang(String id_cabang) {
        this.id_cabang = id_cabang;
    }

    public String getKodeBank() {
        return kodeBank;
    }

    public void setKodeBank(String kodeBank) {
        this.kodeBank = kodeBank;
    }

    public Integer getBulan() {
        return bulan;
    }

    public void setBulan(Integer bulan) {
        this.bulan = bulan;
    }

    public Integer getTahun() {
        return tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public Date getPeriodeAwal() {
        return periodeAwal;
    }

    public void setPeriodeAwal(Date periodeAwal) {
        this.periodeAwal = periodeAwal;
    }

    public Date getPeriodeAkhir() {
        return periodeAkhir;
    }

    public void setPeriodeAkhir(Date periodeAkhir) {
        this.periodeAkhir = periodeAkhir;
    }

    public BigDecimal getNilaiKlaim() {
        return nilaiKlaim;
    }

    public void setNilaiKlaim(BigDecimal nilaiKlaim) {
        this.nilaiKlaim = nilaiKlaim;
    }

    public String getNoJurnal() {
        return noJurnal;
    }

    public void setNoJurnal(String noJurnal) {
        this.noJurnal = noJurnal;
    }

    public Date getTglJurnal() {
        return tglJurnal;
    }

    public void setTglJurnal(Date tglJurnal) {
        this.tglJurnal = tglJurnal;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JurnalProduksiKlaim that = (JurnalProduksiKlaim) o;
        return Objects.equals(idJurnalProduksiKlaim, that.idJurnalProduksiKlaim) && Objects.equals(id_cabang, that.id_cabang) && Objects.equals(kodeBank, that.kodeBank) && Objects.equals(bulan, that.bulan) && Objects.equals(tahun, that.tahun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJurnalProduksiKlaim, id_cabang, kodeBank, bulan, tahun);
    }

    @Override
    public String toString() {
        return "JurnalProduksiKlaim{" +
                "idJurnalProduksiKlaim=" + idJurnalProduksiKlaim +
                ", id_cabang='" + id_cabang + '\'' +
                ", kodeBank='" + kodeBank + '\'' +
                ", bulan=" + bulan +
                ", tahun=" + tahun +
                ", periodeAwal=" + periodeAwal +
                ", periodeAkhir=" + periodeAkhir +
                ", nilaiKlaim=" + nilaiKlaim +
                ", noJurnal='" + noJurnal + '\'' +
                ", tglJurnal=" + tglJurnal +
                '}';
    }
}
