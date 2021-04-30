package id.co.askrindo.kmkpen.service.impl;

import id.co.askrindo.kmkpen.model.postgreSql.JurnalProduksiIjp;
import id.co.askrindo.kmkpen.model.postgreSql.PenjaminanIjp;
import id.co.askrindo.kmkpen.model.postgreSql.dto.IJurnalProduksiIjpDTO;
import id.co.askrindo.kmkpen.service.IConverterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterServiceImpl implements IConverterService {

    @Override
    public List<JurnalProduksiIjp> convertToJurnalProduksiIjpFromDTO(List<IJurnalProduksiIjpDTO> jurnalProduksiIjpDTOList) {
        List<JurnalProduksiIjp> result = new ArrayList<>(jurnalProduksiIjpDTOList.size());
        jurnalProduksiIjpDTOList.forEach(dto -> result.add(new JurnalProduksiIjp(dto)));

        return result;
    }

    @Override
    public List<JurnalProduksiIjp> convertToJurnalProduksiIjpFromRincianIjp(List<PenjaminanIjp> penjaminanIjpList) {
        return null;
    }
}
