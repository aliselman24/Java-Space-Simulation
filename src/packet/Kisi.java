/**
*
* @author Ali Selman ERKAN   ,  selman.erkan@ogr.sakrya.edu.tr
* @since Programın yazıldığı tarih    26.04.2025
* <p>
* KİŞİ SINIFI 
* </p>
*/

package packet;

public class Kisi {
    private String isim;
    private long kalanOmur;
    private String aracAdi;
    private boolean hayatta;

    public Kisi(String isim, int yas, long kalanOmur, String aracAdi) {
        this.isim = isim;
        this.kalanOmur = kalanOmur;
        this.aracAdi = aracAdi;
        this.hayatta = true;
    }

    public String getIsim() {
        return isim;
    }

    public String getAracAdi() {
        return aracAdi;
    }

    public boolean hayattaMi() {
        return hayatta;
    }

    public void saatIlerle() {
        if (hayatta) {
            kalanOmur--;
            if (kalanOmur <= 0) hayatta = false;
        }
    }
}
