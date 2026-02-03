/**
*
* @author Ali Selman ERKAN   ,  selman.erkan@ogr.sakrya.edu.tr
* @since Programın yazıldığı tarih    26.04.2025
* <p>
* ARAÇ SINIFI 
* </p>
*/

package packet;

import java.util.*;

public class Arac {
    private String ad, cikis, hedef, cikisTarih;
    private double mesafe, kalanSaat;
    private String durum;
    private String varisTahmini;
    private boolean imha;
    private boolean hedefeEklendiMi = false;


    public Arac(String ad, String cikis, String hedef, String cikisTarih, double mesafe) {
        this.ad = ad;
        this.cikis = cikis;
        this.hedef = hedef;
        this.cikisTarih = cikisTarih;
        this.mesafe = mesafe;
        this.kalanSaat = mesafe;
        this.durum = "Bekliyor";
        this.varisTahmini = "Hesaplanıyor";
        this.imha = false;
    }

    public void hesaplaVarisTarihi(Gezegen hedefG) throws Exception {
        this.varisTahmini = ZamanHesaplayici.varisTarihi(cikisTarih, mesafe, hedefG.getSaatSayisi());
    }

    public void durumGuncelle(Gezegen simdiGezegen) throws Exception {
        if (imha) {
            durum = "İMHA";
            return;
        }

        if (durum.equals("Bekliyor") && simdiGezegen.getAd().equals(cikis) && simdiGezegen.getTarihStr().equals(cikisTarih)) {
            durum = "Yolda";
        }

        if (durum.equals("Yolda")) {
            kalanSaat -= 1;
            if (kalanSaat <= 0) {
                durum = "Vardı";
                kalanSaat = 0;
            }
        }
    }

    public void ekipKontrol(List<Kisi> kisiler) {
        boolean hayattaVar = kisiler.stream().anyMatch(k -> k.getAracAdi().equals(ad) && k.hayattaMi());
        if (!hayattaVar) {
            imha = true;
            durum = "İMHA";
        }
    }
    public boolean isHedefeEklendiMi() {
        return hedefeEklendiMi;
    }
    public void setHedefeEklendiMi(boolean hedefeEklendiMi) {
        this.hedefeEklendiMi = hedefeEklendiMi;
    }


    public String getDurum() { return durum; }
    public String getAd() { return ad; }
    public String getCikis() { return cikis; }
    public String getHedef() { return hedef; }
    public double getKalanSaat() { return kalanSaat; }
    public String getVarisTahmini() { return imha ? "--" : varisTahmini; }
}
