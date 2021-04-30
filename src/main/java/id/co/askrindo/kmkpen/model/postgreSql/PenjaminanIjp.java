package id.co.askrindo.kmkpen.model.postgreSql;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_penjaminan_ijp")
public class PenjaminanIjp implements Serializable {
    private static final long serialVersionUID = -2630354109705825929L;

    //COLUMN_NAME                                                  DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT
    //-----------------------------------------------------------  ---------  -----------  --------------  ----------  --------  -----------------------------------------------------------
    //penjaminan_ijp_id                                            int8                                                NO        nextval('t_penjaminan_ijp_penjaminan_ijp_id_seq'::regclass)
    @Id
    @Column(name = "penjaminan_ijp_id")
    private Long penjaminanIjpId;

    //id_penjaminan                                                int8                                                NO
    @Column(name = "id_penjaminan")
    private Long idPenjaminan;

    //tahun_ke                                                     int2                                                NO
    @Column(name = "tahun_ke")
    private Integer tahunKe;

    //tgl_premi                                                    date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_premi")
    private Date tglPremi;

    //premi
    @Column(name = "premi", length = 18, precision = 2)
    private BigDecimal premi;

    //id_jurnal_produksi_ijp                                       int8                                                YES
    @Column(name = "id_jurnal_produksi_ijp")
    private Long idJurnalProduksiIjp;

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = JurnalProduksiIjp.class)
//    @JoinColumn(name = "id_jurnal_produksi_ijp")
//    @JsonIgnore
//    private JurnalProduksiIjp jurnalProduksiIjp;

    //status_sikp                                                  bool                                                NO        false
    @Column(name = "status_sikp")
    private Boolean statusSikp;

    //is_koreksi                                                   bool                                                NO        false
    @Column(name = "is_koreksi")
    private Boolean koreksi;

    //is_bayar_djppr                                               bool                                                YES       false                                                      */
    @Column(name = "is_bayar_djppr")
    private Boolean bayarDjppr;

    public Long getPenjaminanIjpId() {
        return penjaminanIjpId;
    }

    public void setPenjaminanIjpId(Long penjaminanIjpId) {
        this.penjaminanIjpId = penjaminanIjpId;
    }

    public Long getIdPenjaminan() {
        return idPenjaminan;
    }

    public void setIdPenjaminan(Long idPenjaminan) {
        this.idPenjaminan = idPenjaminan;
    }

    public Integer getTahunKe() {
        return tahunKe;
    }

    public void setTahunKe(Integer tahunKe) {
        this.tahunKe = tahunKe;
    }

    public Date getTglPremi() {
        return tglPremi;
    }

    public void setTglPremi(Date tglPremi) {
        this.tglPremi = tglPremi;
    }

    public BigDecimal getPremi() {
        return premi;
    }

    public void setPremi(BigDecimal premi) {
        this.premi = premi;
    }

    public Long getIdJurnalProduksiIjp() {
        return idJurnalProduksiIjp;
    }

    public void setIdJurnalProduksiIjp(Long idJurnalProduksiIjp) {
        this.idJurnalProduksiIjp = idJurnalProduksiIjp;
    }


    /*public JurnalProduksiIjp getJurnalProduksiIjp() {
        return jurnalProduksiIjp;
    }

    public void setJurnalProduksiIjp(JurnalProduksiIjp jurnalProduksiIjp) {
        this.jurnalProduksiIjp = jurnalProduksiIjp;
    }*/

    public Boolean getStatusSikp() {
        return statusSikp;
    }

    public void setStatusSikp(Boolean statusSikp) {
        this.statusSikp = statusSikp;
    }

    public Boolean getKoreksi() {
        return koreksi;
    }

    public void setKoreksi(Boolean koreksi) {
        this.koreksi = koreksi;
    }

    public Boolean getBayarDjppr() {
        return bayarDjppr;
    }

    public void setBayarDjppr(Boolean bayarDjppr) {
        this.bayarDjppr = bayarDjppr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PenjaminanIjp that = (PenjaminanIjp) o;
        return penjaminanIjpId.equals(that.penjaminanIjpId) && idPenjaminan.equals(that.idPenjaminan) && tahunKe.equals(that.tahunKe) && tglPremi.equals(that.tglPremi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(penjaminanIjpId, idPenjaminan, tahunKe, tglPremi);
    }

    @Override
    public String toString() {
        return "PenjaminanIjp{" +
                "penjaminanIjpId=" + penjaminanIjpId +
                ", idPenjaminan=" + idPenjaminan +
                ", tahunKe=" + tahunKe +
                ", tglPremi=" + tglPremi +
                ", premi=" + premi +
                ", statusSikp=" + statusSikp +
                ", koreksi=" + koreksi +
                ", bayarDjppr=" + bayarDjppr +
                '}';
    }
}
