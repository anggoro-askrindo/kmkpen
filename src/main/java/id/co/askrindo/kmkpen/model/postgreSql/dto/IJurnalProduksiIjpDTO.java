package id.co.askrindo.kmkpen.model.postgreSql.dto;

import java.math.BigDecimal;
import java.util.Date;

public interface IJurnalProduksiIjpDTO {
    public Long getIdJurnalProduksiIjp();
    public String getIdCabang();
    public String getKodeCabang();
    public String getKodeBank();
    public String getNamaBank();
    public Integer getBulan();
    public Integer getTahun();
    public Date getPeriodeAwal();
    public Date getPeriodeAkhir();
    public BigDecimal getNilaiIjp();
    public String getNoJurnal();
    public Date getTglJurnal();
    public BigDecimal getNilaiCadangan();
    public Boolean getKoreksi();
    public String getNoJurnalLossLimit();
}
