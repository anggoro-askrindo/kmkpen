package id.co.askrindo.kmkpen.service.impl.sybase;

import id.co.askrindo.kmkpen.model.sybase.NoSumber;
import id.co.askrindo.kmkpen.model.sybase.NoSumberPK;
import id.co.askrindo.kmkpen.model.sybase.NoTransaksi;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import id.co.askrindo.kmkpen.repository.sybase.INoSumberRepository;
import id.co.askrindo.kmkpen.service.sybase.INoSumberService;
import id.co.askrindo.kmkpen.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * Created by Anggoro Biandono on 28/04/2021.
 */

@Service
public class NoSumberServiceImpl extends GenericSybaseSqlServiceImpl<NoSumber, NoSumberPK> implements INoSumberService {
    private INoSumberRepository noSumberRepository;

    @Autowired
    public NoSumberServiceImpl(INoSumberRepository noSumberRepository) {
        super(noSumberRepository);
        this.noSumberRepository = noSumberRepository;
    }

    @Override
    public NoSumber getNoSumber(String sbuId, BigDecimal tahun, BigDecimal bulan, String kodeJurnal, String kurNonkur, Double idPerkiraan) {
        NoSumber noSumber = noSumberRepository.getSumberByPk(sbuId, tahun, bulan, kodeJurnal, kurNonkur, idPerkiraan);

        if(noSumber != null){
            noSumber.setSumber(noSumber.getSumber().add(BigDecimal.ONE));
        }else{
            noSumber = new NoSumber(sbuId, tahun, bulan, kodeJurnal, kurNonkur, idPerkiraan);
            noSumber.setSumber(BigDecimal.ONE);
        }

        noSumberRepository.save(noSumber);

        return noSumber;
    }

    @Override
    @Transactional("sybaseSqlTransactionManager")
    public String generateNoSumber(String sbuId, BigDecimal tahun, BigDecimal bulan, String kodeJurnal, String kurNonkur, Double idPerkiraan) {
        NoSumber noSumber = getNoSumber(sbuId, tahun, bulan, kodeJurnal, kurNonkur, idPerkiraan);

        Object[] arguments = new Object[6];

        arguments[0] = Constants.getNamaJurnalMap().get(noSumber.getPk().getKodeJurnal());
        arguments[1] = noSumber.getPk().getKurNonkur();
        arguments[2] = noSumber.getPk().getSbuId();
        arguments[3] = noSumber.getPk().getTahun().toPlainString();
        arguments[4] = noSumber.getPk().getBulan();
        arguments[5] = noSumber.getSumber();

        String number = MessageFormat.format(NoSumber.NO_JURNAL_PATTERN, arguments);

        return number;
    }
}
