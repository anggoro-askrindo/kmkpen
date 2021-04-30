package id.co.askrindo.kmkpen.component;

import id.co.askrindo.kmkpen.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anggoro Biandono on 14/10/2020.
 */
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    private static final Logger LOG =
            LoggerFactory.getLogger(CommandLineAppStartupRunner.class);

    /*@Autowired
    private ICabangService cabangService;

    @Autowired
    private IMappingCoaService mappingCoaService;

    @Autowired
    private IAccountBankService accountBankService;
    */

    @Override
    public void run(String...args) throws Exception {
        LOG.info("[INFO] - SET MAPPING NAMA JURNAL");
        Map<String, String> mappingNamaJurnalMap = new HashMap<>(5);
        mappingNamaJurnalMap.put(Constants.KodeJurnalSAA.MEMORIAL,Constants.NamaJurnalSAA.MEMORIAL);
        mappingNamaJurnalMap.put(Constants.KodeJurnalSAA.KAS_MASUK,Constants.NamaJurnalSAA.KAS_MASUK);
        mappingNamaJurnalMap.put(Constants.KodeJurnalSAA.KAS_KELUAR,Constants.NamaJurnalSAA.KAS_KELUAR);
        mappingNamaJurnalMap.put(Constants.KodeJurnalSAA.BANK_MASUK,Constants.NamaJurnalSAA.BANK_MASUK);
        mappingNamaJurnalMap.put(Constants.KodeJurnalSAA.BANK_KELUAR,Constants.NamaJurnalSAA.BANK_KELUAR);
        Constants.setNamaJurnalMap(mappingNamaJurnalMap);

        LOG.info("[INFO] - SET MAPPING NAMA BULAN");
        Map<Integer, String> mappingNamaBulanMap = new HashMap<>(5);
        mappingNamaBulanMap.put(1, "Januari");
        mappingNamaBulanMap.put(2, "Februari");
        mappingNamaBulanMap.put(3, "Maret");
        mappingNamaBulanMap.put(4, "April");
        mappingNamaBulanMap.put(5, "Mei");
        mappingNamaBulanMap.put(6, "Juni");
        mappingNamaBulanMap.put(7, "Juli");
        mappingNamaBulanMap.put(8, "Agustus");
        mappingNamaBulanMap.put(9, "September");
        mappingNamaBulanMap.put(10, "Oktober");
        mappingNamaBulanMap.put(11, "November");
        mappingNamaBulanMap.put(12, "Desember");
        Constants.setNamaBulanMap(mappingNamaBulanMap);

//        LOG.info("[INFO] - SET CABANG VALUE");
//        Constants.setCabangMap(cabangService.getMapAllBranch());
//
//        LOG.info("[INFO] - SET MAPPING COA VALUE");
//        Constants.setMappingCoaMap(mappingCoaService.getAllMappingCoaWithCashflowIdMAP());
//
//        LOG.info("[INFO] - SET MAPPING ACCOUNT BANK VALUE");
//        Constants.setMappingAccountBankMap(accountBankService.getAllAccountBankByLegacyCoaMAP());
//
//        LOG.info("[INFO] - SET MAPPING DOCUMENT TYPE ID VALUE");
//        Map<String, Integer> mappingDocumentTypIDMap = new HashMap<>(5);
//        mappingDocumentTypIDMap.put(Constants.KodeJurnalSAA.MEMORIAL,Constants.DocumentTypID.MEMORIAL);
//        mappingDocumentTypIDMap.put(Constants.KodeJurnalSAA.KAS_MASUK,Constants.DocumentTypID.KAS_MASUK);
//        mappingDocumentTypIDMap.put(Constants.KodeJurnalSAA.KAS_KELUAR,Constants.DocumentTypID.KAS_KELUAR);
//        mappingDocumentTypIDMap.put(Constants.KodeJurnalSAA.BANK_MASUK,Constants.DocumentTypID.BANK_MASUK);
//        mappingDocumentTypIDMap.put(Constants.KodeJurnalSAA.BANK_KELUAR,Constants.DocumentTypID.BANK_KELUAR);
//        Constants.setMappingDocumentTypIDMap(mappingDocumentTypIDMap);
//
//        LOG.info("[INFO] - SET MAPPING TRANSACTION SOURCE ID VALUE");
//        Map<String, Integer> mappingTransactionSourceIdMap = new HashMap<>(5);
//        mappingTransactionSourceIdMap.put(Constants.KodeJurnalSAA.MEMORIAL,Constants.TransactionSourceId.MEMORIAL);
//        mappingTransactionSourceIdMap.put(Constants.KodeJurnalSAA.KAS_MASUK,Constants.TransactionSourceId.KAS_MASUK);
//        mappingTransactionSourceIdMap.put(Constants.KodeJurnalSAA.KAS_KELUAR,Constants.TransactionSourceId.KAS_KELUAR);
//        mappingTransactionSourceIdMap.put(Constants.KodeJurnalSAA.BANK_MASUK,Constants.TransactionSourceId.BANK_MASUK);
//        mappingTransactionSourceIdMap.put(Constants.KodeJurnalSAA.BANK_KELUAR,Constants.TransactionSourceId.BANK_KELUAR);
//        Constants.setMappingTransactionSourceIdMap(mappingTransactionSourceIdMap);
//
//        LOG.info("[INFO] - SET MAPPING DOCUMENT TYPE VALUE");
//        Map<String, String> mappingDocumentTypeMap = new HashMap<>(5);
//        mappingDocumentTypeMap.put(Constants.KodeJurnalSAA.MEMORIAL,Constants.DocumentType.MEMORIAL);
//        mappingDocumentTypeMap.put(Constants.KodeJurnalSAA.KAS_MASUK,Constants.DocumentType.KAS_MASUK);
//        mappingDocumentTypeMap.put(Constants.KodeJurnalSAA.KAS_KELUAR,Constants.DocumentType.KAS_KELUAR);
//        mappingDocumentTypeMap.put(Constants.KodeJurnalSAA.BANK_MASUK,Constants.DocumentType.BANK_MASUK);
//        mappingDocumentTypeMap.put(Constants.KodeJurnalSAA.BANK_KELUAR,Constants.DocumentType.BANK_KELUAR);
//        Constants.setMappingDocumentTypeMap(mappingDocumentTypeMap);
//
//        LOG.info("[INFO] - SET MAPPING ACCOUNT TYPE VALUE");
//        Map<String, String> mappingAccountTypeMap = new HashMap<>(5);
//        mappingAccountTypeMap.put(Constants.KodeJurnalSAA.MEMORIAL,Constants.AccountType.LEDGER);
//        mappingAccountTypeMap.put(Constants.KodeJurnalSAA.KAS_MASUK,Constants.AccountType.CASH);
//        mappingAccountTypeMap.put(Constants.KodeJurnalSAA.KAS_KELUAR,Constants.AccountType.CASH);
//        mappingAccountTypeMap.put(Constants.KodeJurnalSAA.BANK_MASUK,Constants.AccountType.BANK);
//        mappingAccountTypeMap.put(Constants.KodeJurnalSAA.BANK_KELUAR,Constants.AccountType.BANK);
//        Constants.setMappingAccountTypeMap(mappingAccountTypeMap);
//
//        LOG.info("[INFO] - SET MAPPING DEBET CREDIT VALUE");
//        Map<String, String> mappingDebetCreditMap = new HashMap<>(5);
//        mappingDebetCreditMap.put(Constants.KodeJurnalSAA.MEMORIAL,"D");
//        mappingDebetCreditMap.put(Constants.KodeJurnalSAA.KAS_MASUK,"D");
//        mappingDebetCreditMap.put(Constants.KodeJurnalSAA.KAS_KELUAR,"C");
//        mappingDebetCreditMap.put(Constants.KodeJurnalSAA.BANK_MASUK,"D");
//        mappingDebetCreditMap.put(Constants.KodeJurnalSAA.BANK_KELUAR,"C");
//        Constants.setMappingDebetCreditMap(mappingDebetCreditMap);
    }
}