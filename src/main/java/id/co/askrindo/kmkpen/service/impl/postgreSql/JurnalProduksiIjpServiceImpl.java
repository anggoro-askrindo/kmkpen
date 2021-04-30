package id.co.askrindo.kmkpen.service.impl.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiIjp;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IRincianJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.repository.postgreSql.IJurnalProduksiIjpRepository;
import id.co.askrindo.kmkpen.service.postgreSql.IJurnalProduksiIjpService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JurnalProduksiIjpServiceImpl extends GenericPostgreSqlServiceImpl<JurnalProduksiIjp,Long> implements IJurnalProduksiIjpService {
    private IJurnalProduksiIjpRepository jurnalProduksiIjpRepository;

    public JurnalProduksiIjpServiceImpl(IJurnalProduksiIjpRepository jurnalProduksiIjpRepository) {
        super(jurnalProduksiIjpRepository);
        this.jurnalProduksiIjpRepository = jurnalProduksiIjpRepository;
    }

    @Override
    public List<IJurnalProduksiIjpDTO> getJurnalProduksiIjpListFromRincian(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir) {
        return jurnalProduksiIjpRepository.getJurnalProduksiIjpListFromRincian(bulan, tahun, tglPremiAwal, tglPremiAkhir);
    }

    @Override
    public List<IRincianJurnalProduksiIjpDTO> getRincianJurnalProduksiIjpListFromRincian(int bulan, int tahun, Date tglPremiAwal, Date tglPremiAkhir) {
        return jurnalProduksiIjpRepository.getRincianJurnalProduksiIjpListFromRincian(bulan, tahun, tglPremiAwal, tglPremiAkhir);
    }

    @Override
    public List<IJurnalProduksiIjpDTO> getJurnalByStatusByMonthByYear(Boolean status, int bulan, int tahun) {
        return jurnalProduksiIjpRepository.getJurnalByStatusByMonthByYear(status, bulan, tahun);
    }

    @Override
    public Long getMaxIdVal() {
        return jurnalProduksiIjpRepository.getMaxIdVal();
    }

    @Override
    public void updateNoJurnal(Long idJurnalProduksiIjp, String noJurnal, Date tglJurnal) {
        jurnalProduksiIjpRepository.updateNoJurnal(idJurnalProduksiIjp, noJurnal, tglJurnal);
    }
}
