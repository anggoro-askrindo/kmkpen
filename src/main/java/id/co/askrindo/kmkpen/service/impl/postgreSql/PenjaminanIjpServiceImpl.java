package id.co.askrindo.kmkpen.service.impl.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.PenjaminanIjp;
import id.co.askrindo.kmkpen.repository.postgreSql.IPenjaminanIjpRepository;
import id.co.askrindo.kmkpen.service.postgreSql.IPenjaminanIjpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PenjaminanIjpServiceImpl extends GenericPostgreSqlServiceImpl<PenjaminanIjp,Long>  implements IPenjaminanIjpService{
    private IPenjaminanIjpRepository penjaminanIjpRepository;

    @Autowired
    public PenjaminanIjpServiceImpl( IPenjaminanIjpRepository penjaminanIjpRepository) {
        super(penjaminanIjpRepository);
        this.penjaminanIjpRepository = penjaminanIjpRepository;
    }

    @Override
    public List<PenjaminanIjp> getPenjaminanIjpByTglPremi(Date tglMulai, Date tglAkhir) {
        return penjaminanIjpRepository.getPenjaminanIjpByTglPremi(tglMulai, tglAkhir);
    }

    @Override
    @Transactional("postgreSqlTransactionManager")
    public void updateIdJurnalIjp(Date periodeAwal, Date periodeAkhir) {
        penjaminanIjpRepository.updateIdJurnalIjp(periodeAwal, periodeAkhir);
    }
}
