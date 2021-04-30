package id.co.askrindo.kmkpen.service.sybase;

import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiKlaimDTO;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetil;
import id.co.askrindo.kmkpen.model.sybase.TransaksiDetilPK;
import id.co.askrindo.kmkpen.model.sybase.TransaksiMaster;
import id.co.askrindo.kmkpen.service.IGenericService;

import java.util.Map;

/**
 * Created by Anggoro Biandono on 28/04/2021.
 */
public interface ITransaksiDetilService extends IGenericService<TransaksiDetil, TransaksiDetilPK> {
    public Map<Integer, TransaksiDetil> createTransaksiDetail(TransaksiMaster transaksiMaster, IJurnalProduksiIjpDTO jurnalProduksiIjpDTO);
    public Map<Integer, TransaksiDetil> createTransaksiDetailKlaim(TransaksiMaster transaksiMaster, IJurnalProduksiKlaimDTO jurnalProduksiKlaimDTO);
    public Map<Integer, TransaksiDetil> createTransaksiDetailKoreksi(TransaksiMaster transaksiMaster, IJurnalProduksiIjpDTO jurnalProduksiIjpDTO);
}
