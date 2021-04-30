package id.co.askrindo.kmkpen.model.postgreSql.dto;

import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Anggoro Biandono on 29/04/2021.
 */
public interface IJurnalProduksiKlaimDTO {
    public Long getIdJurnalProduksiKlaim();
    public String getIdCabang();
    public String getKodeCabang();
    public String getKodeBank();
    public String getNamaBank();
    public Integer getBulan();
    public Integer getTahun();
    public Date getPeriodeAwal();
    public Date getPeriodeAkhir();
    public BigDecimal getNilaiKlaim();
    public String getNoJurnal();
    public Date getTglJurnal();
    public Boolean getKoreksi();
}