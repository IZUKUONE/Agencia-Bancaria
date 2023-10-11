package utlitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
    static NumberFormat formvalores = new DecimalFormat("R$ #,##0.00");
    public static String doubleToString(Double valor) {
        return formvalores.format(valor);
    }
}
