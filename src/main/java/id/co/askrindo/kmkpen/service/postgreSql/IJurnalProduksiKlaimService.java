package id.co.askrindo.kmkpen.service.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiKlaim;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;
import id.co.askrindo.kmkpen.service.IGenericService;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 30/04/2021.
 */
public interface IJurnalProduksiKlaimService extends IGenericService<JurnalProduksiKlaim, Long> {
    public List<IJurnalProduksiKlaimDTO> getRincianJurnalProduksiIjpListFromRincian(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir);
    public Long getMaxIdVal();
    public List<IJurnalProduksiKlaimDTO> getJurnalByStatusByMonthByYear(Boolean status, int bulan, int tahun);
    public void updateNoJurnal(Long idJurnalProduksiKlaim, String noJurnal, Date tglJurnal);
}
