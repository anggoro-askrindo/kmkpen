package id.co.askrindo.kmkpen.model.postgreSql;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Anggoro Biandono on 29/04/2021.
 */

@Entity
@Table(name = "t_klaim")
public class Klaim implements Serializable {
    private static final long serialVersionUID = 2688023751366517240L;

//    COLUMN_NAME               DATA_TYPE  DATA_LENGTH  DATA_PRECISION  DATA_SCALE  NULLABLE  DATA_DEFAULT
// ------------------------  ---------  -----------  --------------  ----------  --------  ------------
//    id_klaim                  uuid                                                NO
    @Id
    @Column(name = "id_klaim")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="pg-uuid")
    @JsonIgnore
    private UUID idKlaim;

//    id_penjaminan             int8                                                NO
    @Column(name = "id_penjaminan")
    private Long idPenjaminan;

//    no_sertifikat             varchar    30                                       NO
    @Column(name = "no_sertifikat")
    private String noSertifikat;

//    no_registrasi_klaim       varchar    30                                       NO
    @Column(name = "no_registrasi_klaim")
    private String noRegistrasiKlaim;

//    no_klaim                  varchar    30                                       YES
    @Column(name = "no_klaim")
    private String noKlaim;

//    kode_cabang_bank          varchar    8                                        NO
    @Column(name = "kode_cabang_bank")
    private String kodeCabangBank;

//    kode_cabang_askrindo      varchar    3                                        NO
    @Column(name = "kode_cabang_askrindo")
    private String kodeCabangAskrindo;

//    no_pengajuan_klaim        varchar    100                                      NO
    @Column(name = "no_pengajuan_klaim")
    private String noPengajuanKlaim;

//    tgl_pengajuan_klaim       date                                                NO
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_pengajuan_klaim")
    private Date tglPengajuanKlaim;

//    no_tambahan_data_klaim    varchar    100                                      YES
    @Column(name = "no_tambahan_data_klaim")
    private String noTambahanDataKlaim;

//    tgl_tambahan_data_klaim   date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_tambahan_data_klaim")
    private Date tglTambahanDataKlaim;

//    kolektibilitas_kredit     int2                                                NO
    @Column(name = "kolektibilitas_kredit")
    private Integer kolektibilitasKredit;

//    id_penyebab_klaim         int4                                                NO
    @Column(name = "id_penyebab_klaim")
    private Integer idPenyebabKlaim;

//    deskripsi_penyebab_klaim  varchar    1000                                     NO
    @Column(name = "deskripsi_penyebab_klaim")
    private String deskripsiPenyebabKlaim;

//    keterangan                varchar    500                                      YES
    @Column(name = "keterangan")
    private String keterangan;

//    date_of_loss              date                                                NO
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_loss")
    private Date dateOfLoss;

//    plafon_kredit             numeric                 18              2           NO        0
    @Column(name = "plafon_kredit", length = 18, precision = 2)
    private BigDecimal plafonKredit;

//    baki_debet                numeric                 18              2           NO        0
    @Column(name = "baki_debet", length = 18, precision = 2)
    private BigDecimal bakiDebet;

//    tunggakan_pokok           numeric                 18              2           NO        0
    @Column(name = "tunggakan_pokok", length = 18, precision = 2)
    private BigDecimal tunggakanPokok;

//    tunggakan_denda           numeric                 18              2           YES       0
    @Column(name = "tunggakan_denda", length = 18, precision = 2)
    private BigDecimal tunggakanDenda;

//    tunggakan_bunga           numeric                 18              2           YES       0
    @Column(name = "tunggakan_bunga", length = 18, precision = 2)
    private BigDecimal tunggakanBunga;

//    tuntutan_klaim            numeric                 18              2           NO        0
    @Column(name = "tuntutan_klaim", length = 18, precision = 2)
    private BigDecimal tuntutanKlaim;

//    nilai_kerugian_askrindo   numeric                 18              2           NO        0
    @Column(name = "nilai_kerugian_askrindo", length = 18, precision = 2)
    private BigDecimal nilaiKerugianAskrindo;

//    coverage                  numeric                 5               2           NO
    @Column(name = "coverage", length = 5, precision = 2)
    private BigDecimal coverage;

//    net_klaim                 numeric                 18              2           NO        0
    @Column(name = "net_klaim", length = 18, precision = 2)
    private BigDecimal netKlaim;

//    klaim_disetujui           numeric                 18              2           YES       0
    @Column(name = "klaim_disetujui", length = 18, precision = 2)
    private BigDecimal klaimDisetujui;

//    porsi_ask                 numeric                 18              2           YES       0
    @Column(name = "porsi_ask", length = 18, precision = 2)
    private BigDecimal porsiAsk;

//    porsi_regulator           numeric                 18              2           YES       0
    @Column(name = "porsi_regulator", length = 18, precision = 2)
    private BigDecimal porsiRegulator;

//    no_rek_pembayaran_klaim   varchar    50                                       YES
    @Column(name = "no_rek_pembayaran_klaim")
    private String noRekPembayaranKlaim;

//    nama_rekening_klaim       varchar    255                                      YES
    @Column(name = "nama_rekening_klaim")
    private String namaRekeningKlaim;

//    sumber                    int2                                                NO
    @Column(name = "sumber")
    private Integer sumber;

//    is_cac                    bool                                                YES       true
    @Column(name = "is_cac")
    private Boolean isCac;

//    kode_status               int2                                                NO
    @Column(name = "kode_status")
    private Integer kodeStatus;

//    keputusan_klaim           varchar    30                                       YES
    @Column(name = "keputusan_klaim")
    private Boolean keputusanKlaim;

//    is_dokumen_lengkap        bool                                                NO        false
    @Column(name = "is_dokumen_lengkap")
    private Boolean isDokumenLengkap;

//    is_hak_klaim              bool                                                NO        false
    @Column(name = "is_hak_klaim")
    private Boolean isHakKlaim;

//    is_daluarsa               bool                                                NO        false
    @Column(name = "is_daluarsa")
    private Boolean isDaluarsa;

//    is_daluarsa_tamdat        bool                                                NO        false
    @Column(name = "is_daluarsa_tamdat")
    private Boolean isDaluarsaTamdat;

//    is_banding                bool                                                NO        false
    @Column(name = "is_banding")
    private Boolean isBanding;

//    is_survey                 bool                                                NO        false
    @Column(name = "is_survey")
    private Boolean isSurvey;

//    tgl_klaim_lengkap         date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_klaim_lengkap")
    private Date tglKlaimLengkap;

//    tgl_persetujuan_klaim     date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_persetujuan_klaim")
    private Date tglPersetujuanKlaim;

//    tgl_klaim_ditolak         date                                                YES
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tgl_klaim_ditolak")
    private Date tglKlaimDitolak;

//    status_sikp               bool                                                YES       false
    @Column(name = "status_sikp")
    private Boolean statusSikp;

//    ket_audit_trail           varchar    2000                                     YES
    @Column(name = "ket_audit_trail")
    private String ketAuditTrail;

//    status_lunas_ijp          bool                                                YES       false
    @Column(name = "status_lunas_ijp")
    private Boolean statusLunasIjp;

//    status_cetak              int2                                                NO
    @Column(name = "status_cetak")
    private Integer statusCetak;

//    alasan_penolakan          varchar    2000                                     YES
    @Column(name = "alasan_penolakan")
    private String alasanPenolakan;

//    no_sppb                   varchar    50                                       YES
    @Column(name = "no_sppb")
    private String noSppb;

    @Column(name = "id_jurnal_produksi_klaim")
    private Long idJurnalProduksiKlaim;

    public UUID getIdKlaim() {
        return idKlaim;
    }

    public void setIdKlaim(UUID idKlaim) {
        this.idKlaim = idKlaim;
    }

    public Long getIdPenjaminan() {
        return idPenjaminan;
    }

    public void setIdPenjaminan(Long idPenjaminan) {
        this.idPenjaminan = idPenjaminan;
    }

    public String getNoSertifikat() {
        return noSertifikat;
    }

    public void setNoSertifikat(String noSertifikat) {
        this.noSertifikat = noSertifikat;
    }

    public String getNoRegistrasiKlaim() {
        return noRegistrasiKlaim;
    }

    public void setNoRegistrasiKlaim(String noRegistrasiKlaim) {
        this.noRegistrasiKlaim = noRegistrasiKlaim;
    }

    public String getNoKlaim() {
        return noKlaim;
    }

    public void setNoKlaim(String noKlaim) {
        this.noKlaim = noKlaim;
    }

    public String getKodeCabangBank() {
        return kodeCabangBank;
    }

    public void setKodeCabangBank(String kodeCabangBank) {
        this.kodeCabangBank = kodeCabangBank;
    }

    public String getKodeCabangAskrindo() {
        return kodeCabangAskrindo;
    }

    public void setKodeCabangAskrindo(String kodeCabangAskrindo) {
        this.kodeCabangAskrindo = kodeCabangAskrindo;
    }

    public String getNoPengajuanKlaim() {
        return noPengajuanKlaim;
    }

    public void setNoPengajuanKlaim(String noPengajuanKlaim) {
        this.noPengajuanKlaim = noPengajuanKlaim;
    }

    public Date getTglPengajuanKlaim() {
        return tglPengajuanKlaim;
    }

    public void setTglPengajuanKlaim(Date tglPengajuanKlaim) {
        this.tglPengajuanKlaim = tglPengajuanKlaim;
    }

    public String getNoTambahanDataKlaim() {
        return noTambahanDataKlaim;
    }

    public void setNoTambahanDataKlaim(String noTambahanDataKlaim) {
        this.noTambahanDataKlaim = noTambahanDataKlaim;
    }

    public Date getTglTambahanDataKlaim() {
        return tglTambahanDataKlaim;
    }

    public void setTglTambahanDataKlaim(Date tglTambahanDataKlaim) {
        this.tglTambahanDataKlaim = tglTambahanDataKlaim;
    }

    public Integer getKolektibilitasKredit() {
        return kolektibilitasKredit;
    }

    public void setKolektibilitasKredit(Integer kolektibilitasKredit) {
        this.kolektibilitasKredit = kolektibilitasKredit;
    }

    public Integer getIdPenyebabKlaim() {
        return idPenyebabKlaim;
    }

    public void setIdPenyebabKlaim(Integer idPenyebabKlaim) {
        this.idPenyebabKlaim = idPenyebabKlaim;
    }

    public String getDeskripsiPenyebabKlaim() {
        return deskripsiPenyebabKlaim;
    }

    public void setDeskripsiPenyebabKlaim(String deskripsiPenyebabKlaim) {
        this.deskripsiPenyebabKlaim = deskripsiPenyebabKlaim;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getDateOfLoss() {
        return dateOfLoss;
    }

    public void setDateOfLoss(Date dateOfLoss) {
        this.dateOfLoss = dateOfLoss;
    }

    public BigDecimal getPlafonKredit() {
        return plafonKredit;
    }

    public void setPlafonKredit(BigDecimal plafonKredit) {
        this.plafonKredit = plafonKredit;
    }

    public BigDecimal getBakiDebet() {
        return bakiDebet;
    }

    public void setBakiDebet(BigDecimal bakiDebet) {
        this.bakiDebet = bakiDebet;
    }

    public BigDecimal getTunggakanPokok() {
        return tunggakanPokok;
    }

    public void setTunggakanPokok(BigDecimal tunggakanPokok) {
        this.tunggakanPokok = tunggakanPokok;
    }

    public BigDecimal getTunggakanDenda() {
        return tunggakanDenda;
    }

    public void setTunggakanDenda(BigDecimal tunggakanDenda) {
        this.tunggakanDenda = tunggakanDenda;
    }

    public BigDecimal getTunggakanBunga() {
        return tunggakanBunga;
    }

    public void setTunggakanBunga(BigDecimal tunggakanBunga) {
        this.tunggakanBunga = tunggakanBunga;
    }

    public BigDecimal getTuntutanKlaim() {
        return tuntutanKlaim;
    }

    public void setTuntutanKlaim(BigDecimal tuntutanKlaim) {
        this.tuntutanKlaim = tuntutanKlaim;
    }

    public BigDecimal getNilaiKerugianAskrindo() {
        return nilaiKerugianAskrindo;
    }

    public void setNilaiKerugianAskrindo(BigDecimal nilaiKerugianAskrindo) {
        this.nilaiKerugianAskrindo = nilaiKerugianAskrindo;
    }

    public BigDecimal getCoverage() {
        return coverage;
    }

    public void setCoverage(BigDecimal coverage) {
        this.coverage = coverage;
    }

    public BigDecimal getNetKlaim() {
        return netKlaim;
    }

    public void setNetKlaim(BigDecimal netKlaim) {
        this.netKlaim = netKlaim;
    }

    public BigDecimal getKlaimDisetujui() {
        return klaimDisetujui;
    }

    public void setKlaimDisetujui(BigDecimal klaimDisetujui) {
        this.klaimDisetujui = klaimDisetujui;
    }

    public BigDecimal getPorsiAsk() {
        return porsiAsk;
    }

    public void setPorsiAsk(BigDecimal porsiAsk) {
        this.porsiAsk = porsiAsk;
    }

    public BigDecimal getPorsiRegulator() {
        return porsiRegulator;
    }

    public void setPorsiRegulator(BigDecimal porsiRegulator) {
        this.porsiRegulator = porsiRegulator;
    }

    public String getNoRekPembayaranKlaim() {
        return noRekPembayaranKlaim;
    }

    public void setNoRekPembayaranKlaim(String noRekPembayaranKlaim) {
        this.noRekPembayaranKlaim = noRekPembayaranKlaim;
    }

    public String getNamaRekeningKlaim() {
        return namaRekeningKlaim;
    }

    public void setNamaRekeningKlaim(String namaRekeningKlaim) {
        this.namaRekeningKlaim = namaRekeningKlaim;
    }

    public Integer getSumber() {
        return sumber;
    }

    public void setSumber(Integer sumber) {
        this.sumber = sumber;
    }

    public Boolean getCac() {
        return isCac;
    }

    public void setCac(Boolean cac) {
        isCac = cac;
    }

    public Integer getKodeStatus() {
        return kodeStatus;
    }

    public void setKodeStatus(Integer kodeStatus) {
        this.kodeStatus = kodeStatus;
    }

    public Boolean getKeputusanKlaim() {
        return keputusanKlaim;
    }

    public void setKeputusanKlaim(Boolean keputusanKlaim) {
        this.keputusanKlaim = keputusanKlaim;
    }

    public Boolean getDokumenLengkap() {
        return isDokumenLengkap;
    }

    public void setDokumenLengkap(Boolean dokumenLengkap) {
        isDokumenLengkap = dokumenLengkap;
    }

    public Boolean getHakKlaim() {
        return isHakKlaim;
    }

    public void setHakKlaim(Boolean hakKlaim) {
        isHakKlaim = hakKlaim;
    }

    public Boolean getDaluarsa() {
        return isDaluarsa;
    }

    public void setDaluarsa(Boolean daluarsa) {
        isDaluarsa = daluarsa;
    }

    public Boolean getDaluarsaTamdat() {
        return isDaluarsaTamdat;
    }

    public void setDaluarsaTamdat(Boolean daluarsaTamdat) {
        isDaluarsaTamdat = daluarsaTamdat;
    }

    public Boolean getBanding() {
        return isBanding;
    }

    public void setBanding(Boolean banding) {
        isBanding = banding;
    }

    public Boolean getSurvey() {
        return isSurvey;
    }

    public void setSurvey(Boolean survey) {
        isSurvey = survey;
    }

    public Date getTglKlaimLengkap() {
        return tglKlaimLengkap;
    }

    public void setTglKlaimLengkap(Date tglKlaimLengkap) {
        this.tglKlaimLengkap = tglKlaimLengkap;
    }

    public Date getTglPersetujuanKlaim() {
        return tglPersetujuanKlaim;
    }

    public void setTglPersetujuanKlaim(Date tglPersetujuanKlaim) {
        this.tglPersetujuanKlaim = tglPersetujuanKlaim;
    }

    public Date getTglKlaimDitolak() {
        return tglKlaimDitolak;
    }

    public void setTglKlaimDitolak(Date tglKlaimDitolak) {
        this.tglKlaimDitolak = tglKlaimDitolak;
    }

    public Boolean getStatusSikp() {
        return statusSikp;
    }

    public void setStatusSikp(Boolean statusSikp) {
        this.statusSikp = statusSikp;
    }

    public String getKetAuditTrail() {
        return ketAuditTrail;
    }

    public void setKetAuditTrail(String ketAuditTrail) {
        this.ketAuditTrail = ketAuditTrail;
    }

    public Boolean getStatusLunasIjp() {
        return statusLunasIjp;
    }

    public void setStatusLunasIjp(Boolean statusLunasIjp) {
        this.statusLunasIjp = statusLunasIjp;
    }

    public Integer getStatusCetak() {
        return statusCetak;
    }

    public void setStatusCetak(Integer statusCetak) {
        this.statusCetak = statusCetak;
    }

    public String getAlasanPenolakan() {
        return alasanPenolakan;
    }

    public void setAlasanPenolakan(String alasanPenolakan) {
        this.alasanPenolakan = alasanPenolakan;
    }

    public String getNoSppb() {
        return noSppb;
    }

    public void setNoSppb(String noSppb) {
        this.noSppb = noSppb;
    }

    public Long getIdJurnalProduksiKlaim() {
        return idJurnalProduksiKlaim;
    }

    public void setIdJurnalProduksiKlaim(Long idJurnalProduksiKlaim) {
        this.idJurnalProduksiKlaim = idJurnalProduksiKlaim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klaim klaim = (Klaim) o;
        return Objects.equals(idKlaim, klaim.idKlaim) && Objects.equals(idPenjaminan, klaim.idPenjaminan) && Objects.equals(noSertifikat, klaim.noSertifikat) && Objects.equals(noRegistrasiKlaim, klaim.noRegistrasiKlaim) && Objects.equals(noKlaim, klaim.noKlaim) && Objects.equals(kodeCabangBank, klaim.kodeCabangBank) && Objects.equals(kodeCabangAskrindo, klaim.kodeCabangAskrindo) && Objects.equals(noPengajuanKlaim, klaim.noPengajuanKlaim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idKlaim, idPenjaminan, noSertifikat, noRegistrasiKlaim, noKlaim, kodeCabangBank, kodeCabangAskrindo, noPengajuanKlaim);
    }

    @Override
    public String toString() {
        return "Klaim{" +
                "idKlaim=" + idKlaim +
                ", idPenjaminan=" + idPenjaminan +
                ", noSertifikat='" + noSertifikat + '\'' +
                ", noRegistrasiKlaim='" + noRegistrasiKlaim + '\'' +
                ", noKlaim='" + noKlaim + '\'' +
                ", kodeCabangBank='" + kodeCabangBank + '\'' +
                ", kodeCabangAskrindo='" + kodeCabangAskrindo + '\'' +
                ", noPengajuanKlaim='" + noPengajuanKlaim + '\'' +
                '}';
    }
}
