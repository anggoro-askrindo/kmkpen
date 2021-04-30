package id.co.askrindo.kmkpen.model.sybase;

import id.co.askrindo.kmkpen.utils.Constants;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Entity
@Table(name = "transaksi_master")
public class TransaksiMaster implements Serializable {
    private static final long serialVersionUID = 4599663396401123645L;

//    COLUMN_NAME         DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT  IDENTITY
//------------------  ---------  -----------  --------------  ----------  --------  ------------  --------
    @EmbeddedId
    private TransaksiMasterPK pk;

//    kode_jurnal         char       1                                        NO
    @Column(name = "kode_jurnal")
    private String kodeJurnal = Constants.KodeJurnalSAA.MEMORIAL;

//    tanggal             date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal")
    private Date tanggal;

//    sumber              char       20                                       NO
    @Column(name = "sumber")
    private String sumber;

//    keterangan          char       60                                       YES
    @Column(name = "keterangan")
    private String keterangan;

//    user_id             float                                               YES
    @Column(name = "user_id")
    private Double userId;

//    tanggal_entri       date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal_entri")
    private Date tanggalEntri;

//    posted              numeric                 1               0           YES
    @Column(name = "posted", length = 1, precision = 0)
    private BigDecimal posted = BigDecimal.ZERO;

//    window_edit         numeric                 1               0           YES
    @Column(name = "window_edit", length = 1, precision = 0)
    private BigDecimal windowEdit = BigDecimal.ONE;

//    nama_id             float                                               YES
    @Column(name = "nama_id")
    private Double namaId = 0D;

//    flag_uang_muka      numeric                 1               0           YES
    @Column(name = "flag_uang_muka", length = 1, precision = 0)
    private BigDecimal flagUangMuka = BigDecimal.ZERO;

//    bulan               numeric                 2               0           YES
    @Column(name = "bulan", length = 2, precision = 0)
    private BigDecimal bulan;

//    tahun               numeric                 4               0           YES
    @Column(name = "tahun", length = 4, precision = 0)
    private BigDecimal tahun;

//    perkiraan_id        float                                               YES
    @Column(name = "perkiraan_id")
    private Double perkiraanId;

//    jumlah              decimal                 19              2           YES
    @Column(name = "jumlah", length = 19, precision = 2)
    private BigDecimal jumlah;

//    s_unit              char       10                                       YES
    @Column(name = "s_unit")
    private String sUnit;

//    sbu_induk           char       2                                        YES
    @Column(name = "sbu_induk")
    private String sbuInduk;

//    id_sbu_pusat        char       2                                        YES
    @Column(name = "id_sbu_pusat")
    private String idSbuPusat;

//    prod_nonprod        char       1                                        YES
    @Column(name = "prod_nonprod")
    private String prodNonprod = Constants.KodeProdNonProdSAA.PRODUKSI;

//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE}
//            , mappedBy = "transaksiMaster", orphanRemoval = true)
//    private List<TransaksiDetil> transaksiDetilList;

    public TransaksiMasterPK getPk() {
        return pk;
    }

    public void setPk(TransaksiMasterPK pk) {
        this.pk = pk;
    }

    public String getKodeJurnal() {
        return kodeJurnal;
    }

    public void setKodeJurnal(String kodeJurnal) {
        this.kodeJurnal = kodeJurnal;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Double getUserId() {
        return userId;
    }

    public void setUserId(Double userId) {
        this.userId = userId;
    }

    public Date getTanggalEntri() {
        return tanggalEntri;
    }

    public void setTanggalEntri(Date tanggalEntri) {
        this.tanggalEntri = tanggalEntri;
    }

    public BigDecimal getPosted() {
        return posted;
    }

    public void setPosted(BigDecimal posted) {
        this.posted = posted;
    }

    public BigDecimal getWindowEdit() {
        return windowEdit;
    }

    public void setWindowEdit(BigDecimal windowEdit) {
        this.windowEdit = windowEdit;
    }

    public Double getNamaId() {
        return namaId;
    }

    public void setNamaId(Double namaId) {
        this.namaId = namaId;
    }

    public BigDecimal getFlagUangMuka() {
        return flagUangMuka;
    }

    public void setFlagUangMuka(BigDecimal flagUangMuka) {
        this.flagUangMuka = flagUangMuka;
    }

    public BigDecimal getBulan() {
        return bulan;
    }

    public void setBulan(BigDecimal bulan) {
        this.bulan = bulan;
    }

    public BigDecimal getTahun() {
        return tahun;
    }

    public void setTahun(BigDecimal tahun) {
        this.tahun = tahun;
    }

    public Double getPerkiraanId() {
        return perkiraanId;
    }

    public void setPerkiraanId(Double perkiraanId) {
        this.perkiraanId = perkiraanId;
    }

    public BigDecimal getJumlah() {
        return jumlah;
    }

    public void setJumlah(BigDecimal jumlah) {
        this.jumlah = jumlah;
    }

    public String getsUnit() {
        return sUnit;
    }

    public void setsUnit(String sUnit) {
        this.sUnit = sUnit;
    }

    public String getSbuInduk() {
        return sbuInduk;
    }

    public void setSbuInduk(String sbuInduk) {
        this.sbuInduk = sbuInduk;
    }

    public String getIdSbuPusat() {
        return idSbuPusat;
    }

    public void setIdSbuPusat(String idSbuPusat) {
        this.idSbuPusat = idSbuPusat;
    }

    public String getProdNonprod() {
        return prodNonprod;
    }

    public void setProdNonprod(String prodNonprod) {
        this.prodNonprod = prodNonprod;
    }

//    public List<TransaksiDetil> getTransaksiDetilList() {
//        return transaksiDetilList;
//    }
//
//    public void setTransaksiDetilList(List<TransaksiDetil> transaksiDetilList) {
//        this.transaksiDetilList = transaksiDetilList;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransaksiMaster that = (TransaksiMaster) o;
        return Objects.equals(pk, that.pk) && Objects.equals(kodeJurnal, that.kodeJurnal) && Objects.equals(userId, that.userId) && Objects.equals(tanggalEntri, that.tanggalEntri) && Objects.equals(posted, that.posted) && Objects.equals(bulan, that.bulan) && Objects.equals(tahun, that.tahun) && Objects.equals(sUnit, that.sUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, kodeJurnal, userId, tanggalEntri, posted, bulan, tahun, sUnit);
    }

    @Override
    public String toString() {
        return "TransaksiMaster{" +
                "pk=" + pk +
                ", kodeJurnal=" + kodeJurnal +
                ", tanggal=" + tanggal +
                ", sumber='" + sumber + '\'' +
                ", keterangan='" + keterangan + '\'' +
                ", userId=" + userId +
                ", tanggalEntri=" + tanggalEntri +
                ", posted=" + posted +
                ", windowEdit=" + windowEdit +
                ", namaId=" + namaId +
                ", flagUangMuka=" + flagUangMuka +
                ", bulan=" + bulan +
                ", tahun=" + tahun +
                ", perkiraanId=" + perkiraanId +
                ", jumlah=" + jumlah +
                ", sUnit='" + sUnit + '\'' +
                ", sbuInduk='" + sbuInduk + '\'' +
                ", idSbuPusat='" + idSbuPusat + '\'' +
                ", prodNonprod='" + prodNonprod + '\'' +
//                ", transaksiDetilList=" + transaksiDetilList +
                '}';
    }
}
