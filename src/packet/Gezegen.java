/**
*
* @author Ali Selman ERKAN   ,  selman.erkan@ogr.sakrya.edu.tr
* @since Programın yazıldığı tarih    26.04.2025
* <p>
*  GEZEGEN SINIFI  
* </p>
*/
package packet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Gezegen {
    private String ad;
    private int saatSayisi;
    private Date mevcutTarih;

    public Gezegen(String ad, int saatSayisi, String tarihStr) throws Exception {
        this.ad = ad;
        this.saatSayisi = saatSayisi;
        this.mevcutTarih = new SimpleDateFormat("dd.MM.yyyy").parse(tarihStr);
    }

    public String getAd() {
        return ad;
    }

    public int getSaatSayisi() {
        return saatSayisi;
    }

    public Date getMevcutTarih() {
        return mevcutTarih;
    }

    public String getTarihStr() {
        return new SimpleDateFormat("dd.MM.yyyy").format(mevcutTarih);
    }

    public boolean tarihAyni(String digerTarih) throws Exception {
        Date diger = new SimpleDateFormat("dd.MM.yyyy").parse(digerTarih);
        return mevcutTarih.equals(diger);
    }

    public void birSaatIlerle() {
        mevcutTarih.setTime(mevcutTarih.getTime() + 60L * 60 * 1000);
    }
}
