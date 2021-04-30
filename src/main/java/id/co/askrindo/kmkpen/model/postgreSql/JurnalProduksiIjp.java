package id.co.askrindo.kmkpen.model.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IRincianJurnalProduksiIjpDTO;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_jurnal_produksi_ijp")
public class JurnalProduksiIjp implements Persistable<Long> {
    private static final long serialVersionUID = 5095411744284193218L;

    // COLUMN_NAME                                                            DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT
    //---------------------------------------------------------------------  ---------  -----------  --------------  ----------  --------  ---------------------------------------------------------------------
    // id_jurnal_produksi_ijp                                                 int8                                                NO        nextval('t_jurnal_produksi_ijp_id_jurnal_produksi_ijp_seq'::regclass)
    @Id
    @Column(name = "id_jurnal_produksi_ijp")
    private Long idJurnalProduksiIjp;

    // id_cabang                                                              varchar    10                                       NO
    @Column(name = " id_cabang")
    private String idCabang;

    // kode_bank                                                              varchar    8                                        NO
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

    // nilai_ijp                                                              numeric                 18              2           NO        0
    @Column(name = "nilai_ijp", length = 18, precision = 2)
    private BigDecimal nilaiIjp;

    // no_jurnal                                                              varchar    100                                      YES
    @Column(name = "no_jurnal")
    private String noJurnal;

    // tgl_jurnal                                                             date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_jurnal")
    private Date tglJurnal;

    // nilai_cadangan                                                         numeric                 18              2           NO        0
    @Column(name = "nilai_cadangan", length = 18, precision = 2)
    private BigDecimal nilaiCadangan;

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

    // is_koreksi                                                             bool                                                YES       false
    @Column(name = "is_koreksi")
    private Boolean koreksi;

    // no_jurnal_loss_limit                                                   varchar    100                                      YES
    @Column(name = "no_jurnal_loss_limit")
    private String noJurnalLossLimit;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "jurnalProduksiIjp", orphanRemoval = true)
    @Transient
    private List<IRincianJurnalProduksiIjpDTO> rincianJurnalProduksiIjpDTOList;

    @Override
    public Long getId() {
        return this.idJurnalProduksiIjp;
    }

    @Override
    public boolean isNew() {
        return this.idJurnalProduksiIjp == null;
    }

    public JurnalProduksiIjp() {
    }

    public JurnalProduksiIjp(IJurnalProduksiIjpDTO dto) {
        this.idCabang = dto.getIdCabang();
        this.kodeBank = dto.getKodeBank();
        this.bulan = dto.getBulan();
        this.tahun = dto.getTahun();
        this.periodeAwal = dto.getPeriodeAwal();
        this.periodeAkhir = dto.getPeriodeAkhir();
        this.nilaiIjp = dto.getNilaiIjp();
        this.noJurnal = dto.getNoJurnal();
        this.tglJurnal = dto.getTglJurnal();
        this.nilaiCadangan = dto.getNilaiCadangan();
        this.koreksi = dto.getKoreksi();
    }

    public JurnalProduksiIjp(IRincianJurnalProduksiIjpDTO dto) {
        this.idCabang = dto.getIdCabang();
        this.kodeBank = dto.getKodeBank();
        this.bulan = dto.getBulan();
        this.tahun = dto.getTahun();
        this.periodeAwal = dto.getPeriodeAwal();
        this.periodeAkhir = dto.getPeriodeAkhir();
        this.nilaiIjp = dto.getNilaiIjp();
        this.noJurnal = dto.getNoJurnal();
        this.tglJurnal = dto.getTglJurnal();
        this.nilaiCadangan = dto.getNilaiCadangan();
        this.koreksi = dto.getKoreksi();
        if(this.rincianJurnalProduksiIjpDTOList == null)
            this.rincianJurnalProduksiIjpDTOList = new ArrayList<>();
        this.rincianJurnalProduksiIjpDTOList.add(dto);
    }

    public Long getIdJurnalProduksiIjp() {
        return idJurnalProduksiIjp;
    }

    public void setIdJurnalProduksiIjp(Long idJurnalProduksiIjp) {
        this.idJurnalProduksiIjp = idJurnalProduksiIjp;
    }

    public String getIdCabang() {
        return idCabang;
    }

    public void setIdCabang(String idCabang) {
        this.idCabang = idCabang;
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

    public BigDecimal getNilaiIjp() {
        return nilaiIjp;
    }

    public void setNilaiIjp(BigDecimal nilaiIjp) {
        this.nilaiIjp = nilaiIjp;
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

    public BigDecimal getNilaiCadangan() {
        return nilaiCadangan;
    }

    public void setNilaiCadangan(BigDecimal nilaiCadangan) {
        this.nilaiCadangan = nilaiCadangan;
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

    public Boolean getKoreksi() {
        return koreksi;
    }

    public void setKoreksi(Boolean koreksi) {
        this.koreksi = koreksi;
    }

    public String getNoJurnalLossLimit() {
        return noJurnalLossLimit;
    }

    public void setNoJurnalLossLimit(String noJurnalLossLimit) {
        this.noJurnalLossLimit = noJurnalLossLimit;
    }

    public List<IRincianJurnalProduksiIjpDTO> getRincianJurnalProduksiIjpDTOList() {
        return rincianJurnalProduksiIjpDTOList;
    }

    public void setRincianJurnalProduksiIjpDTOList(List<IRincianJurnalProduksiIjpDTO> rincianJurnalProduksiIjpDTOList) {
        this.rincianJurnalProduksiIjpDTOList = rincianJurnalProduksiIjpDTOList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JurnalProduksiIjp that = (JurnalProduksiIjp) o;
        return Objects.equals(idJurnalProduksiIjp, that.idJurnalProduksiIjp) && Objects.equals(idCabang, that.idCabang) && Objects.equals(kodeBank, that.kodeBank) && Objects.equals(bulan, that.bulan) && Objects.equals(tahun, that.tahun) && Objects.equals(koreksi, that.koreksi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJurnalProduksiIjp, idCabang, kodeBank, bulan, tahun, koreksi);
    }

    @Override
    public String toString() {
        return "JurnalProduksiIjp{" +
                "idJurnalProduksiIjp=" + idJurnalProduksiIjp +
                ", idCabang='" + idCabang + '\'' +
                ", kodeBank='" + kodeBank + '\'' +
                ", bulan=" + bulan +
                ", tahun=" + tahun +
                ", periodeAwal=" + periodeAwal +
                ", periodeAkhir=" + periodeAkhir +
                '}';
    }
}
