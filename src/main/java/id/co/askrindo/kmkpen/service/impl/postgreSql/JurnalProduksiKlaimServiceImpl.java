package id.co.askrindo.kmkpen.service.impl.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiKlaim;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import id.co.askrindo.kmkpen.repository.postgreSql.IJurnalProduksiKlaimRepository;
import id.co.askrindo.kmkpen.service.postgreSql.IJurnalProduksiKlaimService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Anggoro Biandono on 30/04/2021.
 */

@Service
public class JurnalProduksiKlaimServiceImpl extends GenericPostgreSqlServiceImpl<JurnalProduksiKlaim, Long> implements IJurnalProduksiKlaimService {
    private IJurnalProduksiKlaimRepository jurnalProduksiKlaimRepository;

    public JurnalProduksiKlaimServiceImpl(IJurnalProduksiKlaimRepository jurnalProduksiKlaimRepository) {
        super(jurnalProduksiKlaimRepository);
        this.jurnalProduksiKlaimRepository = jurnalProduksiKlaimRepository;
    }

    @Override
    public List<IJurnalProduksiKlaimDTO> getRincianJurnalProduksiIjpListFromRincian(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir) {
        return jurnalProduksiKlaimRepository.getRincianJurnalProduksiIjpListFromRincian(bulan, tahun, tglPremiAwal, tglPremiAkhir);
    }

    @Override
    public Long getMaxIdVal() {
        return null;
    }

    @Override
    public List<IJurnalProduksiKlaimDTO> getJurnalByStatusByMonthByYear(Boolean status, int bulan, int tahun) {
        return null;
    }

    @Override
    public void updateNoJurnal(Long idJurnalProduksiKlaim, String noJurnal, Date tglJurnal) {

    }
}
