package id.co.askrindo.kmkpen.service;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiIjp;
import id.co.askrindo.kmkpen.model.postgreSql.PenjaminanIjp;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;

import java.util.List;

public interface IConverterService {
    public List<JurnalProduksiIjp> convertToJurnalProduksiIjpFromDTO(List<IJurnalProduksiIjpDTO> jurnalProduksiIjpDTOList);
    public List<JurnalProduksiIjp> convertToJurnalProduksiIjpFromRincianIjp(List<PenjaminanIjp> penjaminanIjpList);
}
