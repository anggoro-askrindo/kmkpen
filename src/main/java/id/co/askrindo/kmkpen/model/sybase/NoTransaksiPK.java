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
public class NoTransaksiPK implements Serializable {
    private static final long serialVersionUID = 2876070544472238820L;

//    COLUMN_NAME   DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT  IDENTITY
// ------------  ---------  -----------  --------------  ----------  --------  ------------  --------
//    sbu_id              char       2                                        NO
    @Column(name = "sbu_id")
    private String sbuId;

//    tahun               numeric                 4               0           YES
    @Column(name = "tahun", length = 4, precision = 0)
    private BigDecimal tahun;

//    kur_nonkur          char       1                                        NO
    @Column(name = "kur_nonkur")
    private String kurNonkur = Constants.KodeKurNonKurSAA.NON_KUR;

    public NoTransaksiPK() {
    }

    public NoTransaksiPK(String sbuId, BigDecimal tahun, String kurNonkur) {
        this.sbuId = sbuId;
        this.tahun = tahun;
        this.kurNonkur = kurNonkur;
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

    public String getKurNonkur() {
        return kurNonkur;
    }

    public void setKurNonkur(String kurNonkur) {
        this.kurNonkur = kurNonkur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoTransaksiPK that = (NoTransaksiPK) o;
        return Objects.equals(sbuId, that.sbuId) && Objects.equals(tahun, that.tahun) && Objects.equals(kurNonkur, that.kurNonkur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sbuId, tahun, kurNonkur);
    }

    @Override
    public String toString() {
        return "NoTransaksiPk{" +
                "sbuId='" + sbuId + '\'' +
                ", tahun=" + tahun +
                ", kurNonkur='" + kurNonkur + '\'' +
                '}';
    }
}
