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
public class TransaksiMasterPK implements Serializable {
    private static final long serialVersionUID = 7868978907898082114L;

//    pk_trans_mst (transaksi_id, sbu_id, kode_jurnal, kur_nonkur)
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

    public TransaksiMasterPK() {
    }

    public TransaksiMasterPK(String transaksiId, String sbuId, String kurNonkur) {
        this.transaksiId = transaksiId;
        this.sbuId = sbuId;
        this.kurNonkur = kurNonkur;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransaksiMasterPK that = (TransaksiMasterPK) o;
        return Objects.equals(transaksiId, that.transaksiId) && Objects.equals(sbuId, that.sbuId) && Objects.equals(kurNonkur, that.kurNonkur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaksiId, sbuId, kurNonkur);
    }

    @Override
    public String toString() {
        return "TransaksiMasterPK{" +
                "transaksiId='" + transaksiId + '\'' +
                ", sbuId='" + sbuId + '\'' +
                ", kurNonkur='" + kurNonkur + '\'' +
                '}';
    }
}
