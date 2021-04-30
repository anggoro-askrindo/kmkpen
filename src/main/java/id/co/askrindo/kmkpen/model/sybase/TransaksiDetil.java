package id.co.askrindo.kmkpen.model.sybase;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Entity
@Table(name = "transaksi_detil")
public class TransaksiDetil implements Serializable {
    private static final long serialVersionUID = -6703594303433928090L;

    @EmbeddedId
    private TransaksiDetilPK pk;

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TransaksiMaster.class)
//    @JoinColumns({
//            @JoinColumn(name="transaksi_id", referencedColumnName="transaksi_id", insertable=false, updatable=false),
//            @JoinColumn(name="sbu_id", referencedColumnName="sbu_id", insertable=false, updatable=false),
//            @JoinColumn(name="kur_nonkur", referencedColumnName="kur_nonkur", insertable=false, updatable=false)
//    })
//    @JsonIgnore
//    private TransaksiMaster transaksiMaster;

//    COLUMN_NAME         DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT  IDENTITY
//------------------  ---------  -----------  --------------  ----------  --------  ------------  --------
//    perkiraan_id        float                                               YES
    @Column(name = "perkiraan_id")
    private Double perkiraanId;

//    tanggal             date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tanggal")
    private Date tanggal;

//    debet               decimal                 19              2           YES
    @Column(name = "debet", length = 19, precision = 2)
    private BigDecimal debet = BigDecimal.ZERO;

//    kredit              decimal                 19              2           YES
    @Column(name = "kredit", length = 19, precision = 2)
    private BigDecimal kredit = BigDecimal.ZERO;

//    flag_posted         numeric                 1               0           YES
    @Column(name = "flag_posted", length = 1, precision = 0)
    private BigDecimal flagPosted = BigDecimal.ZERO;

//    keterangan          char       100                                      YES
    @Column(name = "keterangan")
    private String keterangan;

//    bulan               numeric                 2               0           YES
    @Column(name = "bulan", length = 2, precision = 0)
    private BigDecimal bulan;

//    tahun               numeric                 4               0           YES
    @Column(name = "tahun", length = 4, precision = 0)
    private BigDecimal tahun;

//    id_sbu_pusat        char       2                                        YES
    @Column(name = "id_sbu_pusat")
    private String idSbuPusat = "KP";

//    sbu_induk           char       2                                        YES
    @Column(name = "sbu_induk")
    private String sbu_induk;

    public TransaksiDetil() {
    }
    public TransaksiDetil(TransaksiDetilPK pk, Double perkiraanId, Date tanggal, BigDecimal debet, BigDecimal kredit, BigDecimal flagPosted, String keterangan, BigDecimal bulan, BigDecimal tahun, String idSbuPusat, String sbu_induk) {
        this.pk = pk;
//        this.lineNo = lineNo;
//        this.transaksiMaster = transaksiMaster;
        this.perkiraanId = perkiraanId;
        this.tanggal = tanggal;
        this.debet = debet;
        this.kredit = kredit;
        this.flagPosted = flagPosted;
        this.keterangan = keterangan;
        this.bulan = bulan;
        this.tahun = tahun;
        this.idSbuPusat = idSbuPusat;
        this.sbu_induk = sbu_induk;
    }

    public TransaksiDetilPK getPk() {
        return pk;
    }

    public void setPk(TransaksiDetilPK pk) {
        this.pk = pk;
    }

//    public Double getLineNo() {
//        return lineNo;
//    }
//
//    public void setLineNo(Double lineNo) {
//        this.lineNo = lineNo;
//    }

//    public TransaksiMaster getTransaksiMaster() {
//        return transaksiMaster;
//    }
//
//    public void setTransaksiMaster(TransaksiMaster transaksiMaster) {
//        this.transaksiMaster = transaksiMaster;
//    }

    public Double getPerkiraanId() {
        return perkiraanId;
    }

    public void setPerkiraanId(Double perkiraanId) {
        this.perkiraanId = perkiraanId;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public BigDecimal getDebet() {
        return debet;
    }

    public void setDebet(BigDecimal debet) {
        this.debet = debet;
    }

    public BigDecimal getKredit() {
        return kredit;
    }

    public void setKredit(BigDecimal kredit) {
        this.kredit = kredit;
    }

    public BigDecimal getFlagPosted() {
        return flagPosted;
    }

    public void setFlagPosted(BigDecimal flagPosted) {
        this.flagPosted = flagPosted;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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

    public String getIdSbuPusat() {
        return idSbuPusat;
    }

    public void setIdSbuPusat(String idSbuPusat) {
        this.idSbuPusat = idSbuPusat;
    }

    public String getSbu_induk() {
        return sbu_induk;
    }

    public void setSbu_induk(String sbu_induk) {
        this.sbu_induk = sbu_induk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransaksiDetil that = (TransaksiDetil) o;
        return Objects.equals(pk, that.pk) && Objects.equals(perkiraanId, that.perkiraanId) && Objects.equals(bulan, that.bulan) && Objects.equals(tahun, that.tahun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, perkiraanId, bulan, tahun);
    }
}
