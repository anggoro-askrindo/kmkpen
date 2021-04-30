package id.co.askrindo.kmkpen.model.sybase;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Entity
@Table(name = "no_transaksi")
public class NoTransaksi implements Serializable {
    private static final long serialVersionUID = 4039492797586817145L;

    //    sbu_id + kur_nonkur + tahun + Right( "00000" + n_transaksi, 5 ) contoh : 111201900022
    static public final String TRANSAKSI_ID_PATTERN = "{0}{1}{2}{3,number,00000}";

    @EmbeddedId
    private NoTransaksiPK pk;
//    COLUMN_NAME   DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT  IDENTITY
// ------------  ---------  -----------  --------------  ----------  --------  ------------  --------
//    noreg         numeric                 6               0           YES
    @Column(name = "noreg", length = 6, precision = 0)
    private BigDecimal noreg = BigDecimal.ZERO;

    public NoTransaksi() {
    }

    public NoTransaksi(String sbuId, BigDecimal tahun, String kurNonkur) {
        this.pk = new NoTransaksiPK(sbuId, tahun, kurNonkur);
    }

    public NoTransaksiPK getPk() {
        return pk;
    }

    public void setPk(NoTransaksiPK pk) {
        this.pk = pk;
    }

    public BigDecimal getNoreg() {
        return noreg;
    }

    public void setNoreg(BigDecimal noreg) {
        this.noreg = noreg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoTransaksi that = (NoTransaksi) o;
        return Objects.equals(pk, that.pk) && Objects.equals(noreg, that.noreg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, noreg);
    }

    @Override
    public String toString() {
        return "NoTransaksi{" +
                "pk=" + pk +
                ", noreg=" + noreg +
                '}';
    }
}
