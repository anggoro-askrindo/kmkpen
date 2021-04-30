package id.co.askrindo.kmkpen.service.sybase;

import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetil;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMaster;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMasterPK;
import id.co.askrindo.kmkpen.service.IGenericService;

import java.util.Date;
import java.util.Map;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */
public interface ITransaksiMasterService extends IGenericService<TransaksiMaster, TransaksiMasterPK> {
    public TransaksiMaster convertFromJurnalIjpPenDto(IJurnalProduksiIjpDTO jurnalProduksiIjpDTO, Date tglJurnal);
    public TransaksiMaster convertFromJurnalKlaimPenDto(IJurnalProduksiKlaimDTO jurnalProduksiKlaimDTO, Date tglJurnal);
}
