package id.co.askrindo.kmkpen.service.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiIjp;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IRincianJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.service.IGenericService;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IJurnalProduksiIjpService extends IGenericService<JurnalProduksiIjp, Long> {
    public List<IJurnalProduksiIjpDTO> getJurnalProduksiIjpListFromRincian(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir);
    public List<IRincianJurnalProduksiIjpDTO> getRincianJurnalProduksiIjpListFromRincian(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir);
    public List<IJurnalProduksiIjpDTO> getJurnalByStatusByMonthByYear(Boolean status, int bulan, int tahun);
    public Long getMaxIdVal();
    public void updateNoJurnal(Long idJurnalProduksiIjp, String noJurnal, Date tglJurnal);
}
