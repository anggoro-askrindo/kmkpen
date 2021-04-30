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
@Table(name = "no_sumber")
public class NoSumber implements Serializable {
    private static final long serialVersionUID = 4205885987407363255L;

    //kd_jurnal + kur_nonkur + '.' + sbu_id + '.'+ tahun + '.' + right( '00' + bulan, 2 ) +'/'+Right( "00000" + urutan, 5 ) contoh :
    // MM1.11.2019.01/00013
    static public final String NO_JURNAL_PATTERN = "{0}{1}.{2}.{3}.{4,number,00}/{5,number,00000}";

    @EmbeddedId
    private NoSumberPK pk;

//    COLUMN_NAME   DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT  IDENTITY
// ------------  ---------  -----------  --------------  ----------  --------  ------------  --------
//    sumber        numeric                 6               0           YES
    @Column(name = "sumber", length = 6, precision = 0)
    private BigDecimal sumber = BigDecimal.ZERO;

    public NoSumber() {
    }

    public NoSumber(String sbuId, BigDecimal tahun, BigDecimal bulan, String kodeJurnal, String kurNonkur, Double idPerkiraan) {
        NoSumberPK pk = new NoSumberPK(sbuId, tahun, bulan, kodeJurnal, kurNonkur, idPerkiraan);
        this.pk = pk;
    }

    public NoSumberPK getPk() {
        return pk;
    }

    public void setPk(NoSumberPK pk) {
        this.pk = pk;
    }

    public BigDecimal getSumber() {
        return sumber;
    }

    public void setSumber(BigDecimal sumber) {
        this.sumber = sumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoSumber noSumber = (NoSumber) o;
        return Objects.equals(pk, noSumber.pk) && Objects.equals(sumber, noSumber.sumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, sumber);
    }

    @Override
    public String toString() {
        return "NoSumber{" +
                "pk=" + pk +
                ", sumber=" + sumber +
                '}';
    }
}
