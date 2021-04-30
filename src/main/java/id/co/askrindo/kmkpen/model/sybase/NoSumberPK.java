package id.co.askrindo.kmkpen.model.sybase;

import id.co.askrindo.kmkpen.utils.Constants;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Embeddable
public class NoSumberPK implements Serializable {
    private static final long serialVersionUID = -4922866083640118240L;

//    COLUMN_NAME   DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT  IDENTITY
// ------------  ---------  -----------  --------------  ----------  --------  ------------  --------
//    sbu_id              char       2                                        NO
    @Column(name = "sbu_id")
    private String sbuId;

//    tahun               numeric                 4               0           YES
    @Column(name = "tahun", length = 4, precision = 0)
    private BigDecimal tahun;
//    bulan         numeric                 2               0           NO
    @Column(name = "bulan", length = 2, precision = 0)
    private BigDecimal bulan;

//    kode_jurnal   char       1                                        NO
    @Column(name = "kode_jurnal")
    private String kodeJurnal;

//    kur_nonkur          char       1                                        NO
    @Column(name = "kur_nonkur")
    private String kurNonkur = Constants.KodeKurNonKurSAA.NON_KUR;

//    id_perkiraan  float                                               NO
    @Column(name = "id_perkiraan")
    private Double idPerkiraan = 0D;

    public NoSumberPK() {
    }

    public NoSumberPK(String sbuId, BigDecimal tahun, BigDecimal bulan, String kodeJurnal, String kurNonkur, Double idPerkiraan) {
        this.sbuId = sbuId;
        this.tahun = tahun;
        this.bulan = bulan;
        this.kodeJurnal = kodeJurnal;
        this.kurNonkur = kurNonkur;
        this.idPerkiraan = idPerkiraan;
    }

    public String getSbuId() {
        return sbuId;
    }

    public void setSbuId(String sbuId) {
        this.sbuId = sbuId;
    }

    public BigDecimal getTahun() {
        return tahun;
    }

    public void setTahun(BigDecimal tahun) {
        this.tahun = tahun;
    }

    public BigDecimal getBulan() {
        return bulan;
    }

    public void setBulan(BigDecimal bulan) {
        this.bulan = bulan;
    }

    public String getKodeJurnal() {
        return kodeJurnal;
    }

    public void setKodeJurnal(String kodeJurnal) {
        this.kodeJurnal = kodeJurnal;
    }

    public String getKurNonkur() {
        return kurNonkur;
    }

    public void setKurNonkur(String kurNonkur) {
        this.kurNonkur = kurNonkur;
    }

    public Double getIdPerkiraan() {
        return idPerkiraan;
    }

    public void setIdPerkiraan(Double idPerkiraan) {
        this.idPerkiraan = idPerkiraan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoSumberPK that = (NoSumberPK) o;
        return Objects.equals(sbuId, that.sbuId) && Objects.equals(tahun, that.tahun) && Objects.equals(bulan, that.bulan) && Objects.equals(kodeJurnal, that.kodeJurnal) && Objects.equals(kurNonkur, that.kurNonkur) && Objects.equals(idPerkiraan, that.idPerkiraan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sbuId, tahun, bulan, kodeJurnal, kurNonkur, idPerkiraan);
    }

    @Override
    public String toString() {
        return "NoSumberPK{" +
                "sbuId='" + sbuId + '\'' +
                ", tahun=" + tahun +
                ", bulan=" + bulan +
                ", kodeJurnal='" + kodeJurnal + '\'' +
                ", kurNonkur='" + kurNonkur + '\'' +
                ", idPerkiraan=" + idPerkiraan +
                '}';
    }
}
