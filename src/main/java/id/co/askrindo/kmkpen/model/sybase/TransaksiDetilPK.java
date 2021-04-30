package id.co.askrindo.kmkpen.model.sybase;

import id.co.askrindo.kmkpen.utils.Constants;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */

@Embeddable
public class TransaksiDetilPK implements Serializable {
    private static final long serialVersionUID = 4222158371278444043L;

//    pk_trans_dtl (transaksi_id, line_no, sbu_id, kur_nonkur)
//    COLUMN_NAME         DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT  IDENTITY
//------------------  ---------  -----------  --------------  ----------  --------  ------------  --------
//    transaksi_id        char       12                                       NO
    @Column(name = "transaksi_id")
    private String transaksiId;

//    sbu_id              char       2                                        NO
    @Column(name = "sbu_id")
    private String sbuId;

//    kur_nonkur          char       1                                        NO
    @Column(name = "kur_nonkur")
    private String kurNonkur = Constants.KodeKurNonKurSAA.NON_KUR;

//    line_no             float                                               NO
    @Column(name = "line_no")
    private Double lineNo;

    public TransaksiDetilPK() {
    }

    public TransaksiDetilPK(String transaksiId, String sbuId, String kurNonkur, Double lineNo) {
        this.transaksiId = transaksiId;
        this.sbuId = sbuId;
        this.kurNonkur = kurNonkur;
        this.lineNo = lineNo;
    }

    public String getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksiId(String transaksiId) {
        this.transaksiId = transaksiId;
    }

    public String getSbuId() {
        return sbuId;
    }

    public void setSbuId(String sbuId) {
        this.sbuId = sbuId;
    }

    public String getKurNonkur() {
        return kurNonkur;
    }

    public void setKurNonkur(String kurNonkur) {
        this.kurNonkur = kurNonkur;
    }

    public Double getLineNo() {
        return lineNo;
    }

    public void setLineNo(Double lineNo) {
        this.lineNo = lineNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransaksiDetilPK that = (TransaksiDetilPK) o;
        return Objects.equals(transaksiId, that.transaksiId) && Objects.equals(sbuId, that.sbuId) && Objects.equals(kurNonkur, that.kurNonkur) && Objects.equals(lineNo, that.lineNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaksiId, sbuId, kurNonkur, lineNo);
    }

    @Override
    public String toString() {
        return "TransaksiDetilPK{" +
                "transaksiId='" + transaksiId + '\'' +
                ", sbuId='" + sbuId + '\'' +
                ", kurNonkur='" + kurNonkur + '\'' +
                '}';
    }
}
