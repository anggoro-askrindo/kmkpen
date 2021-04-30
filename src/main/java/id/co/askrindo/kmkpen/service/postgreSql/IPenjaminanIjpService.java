package id.co.askrindo.kmkpen.service.postgreSql;

import id.co.askrindo.kmkpen.model.postgreSql.PenjaminanIjp;
import id.co.askrindo.kmkpen.service.IGenericService;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IPenjaminanIjpService extends IGenericService<PenjaminanIjp, Long> {
    List<PenjaminanIjp> getPenjaminanIjpByTglPremi( Date tglMulai, Date tglAkhir);
    void updateIdJurnalIjp(Date periodeAwal, Date periodeAkhir);
}
