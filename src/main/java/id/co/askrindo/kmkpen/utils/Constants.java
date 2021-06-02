package id.co.askrindo.kmkpen.utils;

import java.util.Map;

/**
 * Created by Anggoro Biandono on 27/04/2021.
 */
public class Constants {
    private Constants() {
    }

    private static Map<String, String> namaJurnalMap;
    private static Map<Integer, String> namaBulanMap;

    public static Map<String, String> getNamaJurnalMap() {
        return namaJurnalMap;
    }

    public static void setNamaJurnalMap(Map<String, String> namaJurnalMap) {
        Constants.namaJurnalMap = namaJurnalMap;
    }

    public static Map<Integer, String> getNamaBulanMap() {
        return namaBulanMap;
    }

    public static void setNamaBulanMap(Map<Integer, String> namaBulanMap) {
        Constants.namaBulanMap = namaBulanMap;
    }

    static public class KodeJurnalSAA {
        final static public String MEMORIAL = "5";
        final static public String KAS_MASUK = "4";
        final static public String KAS_KELUAR = "3";
        final static public String BANK_MASUK = "2";
        final static public String BANK_KELUAR = "1";
    }

    static public class NamaJurnalSAA {
        final static public String MEMORIAL = "MM";
        final static public String KAS_MASUK = "KD";
        final static public String KAS_KELUAR = "KK";
        final static public String BANK_MASUK = "BD";
        final static public String BANK_KELUAR = "BK";
    }

    static public class KodeKurNonKurSAA {
        final static public String NON_KUR = "1";
        final static public String KUR = "2";
    }

    static public class KodeProdNonProdSAA {
        final static public String MANUAL = "1";
        final static public String PRODUKSI = "2";
    }

    static public class IdCoaPenSAA {
        final static public Double PIUTANG_PREMI_PEN = 11091D;
        final static public Double PREMI_PEN = 11164D;
        final static public Double BEBAN_LOSS_RASIO_PEN = 11238D;
        final static public Double UTANG_LOSS_RASIO_PEN = 11231D;
        final static public Double KLAIM_PEN = 11324D;
        final static public Double UTANG_KLAIM_PEN = 11121D;
    }
}
