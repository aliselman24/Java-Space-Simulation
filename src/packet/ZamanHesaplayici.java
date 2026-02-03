/**
*
* @author Ali Selman ERKAN   ,  selman.erkan@ogr.sakrya.edu.tr
* @since Programın yazıldığı tarih    26.04.2025
* <p>
* ZAMAN HESAPLAYICI SINIFI
* </p>
*/

package packet;

import java.text.SimpleDateFormat;
import java.util.*;

public class ZamanHesaplayici {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    public static int saatFarki(String baslangic, String bitis, int saatSayisi) throws Exception {
        Date t1 = sdf.parse(baslangic);
        Date t2 = sdf.parse(bitis);
        long farkGun = (t2.getTime() - t1.getTime()) / (1000 * 60 * 60 * 24);
        return (int) (farkGun * saatSayisi);
    }

    public static String varisTarihi(String cikisTarih, double mesafe, int hedefSaatSayisi) throws Exception {
        int toplamSaat = (int) mesafe;
        int gunEkle = toplamSaat / hedefSaatSayisi;

        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(cikisTarih));
        cal.add(Calendar.DAY_OF_MONTH, gunEkle);

        return sdf.format(cal.getTime());
    }
}
