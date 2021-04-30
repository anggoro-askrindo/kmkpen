package id.co.askrindo.kmkpen.repository.sybase;

import id.co.askrindo.kmkpen.model.sybase.TransaksiDetil;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetilPK;
import id.co.askrindo.kmkpen.repository.IGenericRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Anggoro Biandono on 28/04/2021.
 */

@Repository
public interface ITransaksiDetilRepository extends IGenericRepository<TransaksiDetil, TransaksiDetilPK> {
}
