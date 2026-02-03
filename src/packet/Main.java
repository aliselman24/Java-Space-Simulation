/**
 *
 * @author Ali Selman ERKAN , selman.erkan@ogr.sakrya.edu.tr
 * @since Programın yazıldığı tarih 26.04.2025
 * <p>
 * ANA (SİMÜLASYON SINIFI)
 * </p>
 */
package packet;

import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<String, Gezegen> gezegenler = DosyaOkuyucu.gezegenleriOku("./dist/Gezegenler.txt");
        List<Arac> araclar = DosyaOkuyucu.araclariOku("./dist/Araclar.txt");
        List<Kisi> kisiler = DosyaOkuyucu.kisileriOku("./dist/Kisiler.txt");

        Map<String, Integer> gezegenNufus = new HashMap<>();
        for (String gezegenAdi : gezegenler.keySet()) {
            gezegenNufus.put(gezegenAdi, new Random().nextInt(26) + 5); // 5-30 arası rastgele
        }

        for (Arac arac : araclar) {
            arac.hesaplaVarisTarihi(gezegenler.get(arac.getHedef()));
        }

        // İlk başta, araçların çıkışı olduğu anda çıkış gezegeninden yolcuları eksiltelim
        for (Arac arac : araclar) {
            int yolcuSayisi = 0;
            for (Kisi kisi : kisiler) {
                if (kisi.getAracAdi().equals(arac.getAd()) && kisi.hayattaMi()) {
                    yolcuSayisi++;
                }
            }
            int mevcutNufus = gezegenNufus.getOrDefault(arac.getCikis(), 0);
            gezegenNufus.put(arac.getCikis(), Math.max(0, mevcutNufus - yolcuSayisi));
        }

        // Simülasyonu başlat
        int iterasyonSayisi = 1;
        boolean simulasyonDevamEdiyor = true;

        while (simulasyonDevamEdiyor) {
            clearConsole();

            System.out.println("İterasyon: " + iterasyonSayisi);

            // Gezegenlerin durumu
            System.out.println("Gezegenler :");
            System.out.printf("%-15s", " ");
            for (String gezegenAdi : gezegenler.keySet()) {
                System.out.printf("%-15s", gezegenAdi);
            }
            System.out.println();

            System.out.print("Tarih      : ");
            for (String gezegenAdi : gezegenler.keySet()) {
                Gezegen g = gezegenler.get(gezegenAdi);
                System.out.printf("%-15s", g.getTarihStr());
            }
            System.out.println();

            System.out.print("Nüfus      : ");
            for (String gezegenAdi : gezegenler.keySet()) {
                System.out.printf("%-15d", gezegenNufus.get(gezegenAdi));
            }
            System.out.println("\n");

            // Uzay araçlarının durumu
            System.out.println("Uzay Araçları:");
            System.out.printf("%-15s | %-10s | %-6s | %-6s | %-17s | %-25s%n",
                    "Araç Adı", "Durum", "Çıkış", "Varış", "Hedefe Kalan Saat", "Hedefe Varacağı Tarih");

            for (Arac arac : araclar) {
                Gezegen cikisGezegen = gezegenler.get(arac.getCikis());
                arac.durumGuncelle(cikisGezegen);
                arac.ekipKontrol(kisiler);

                // Eğer araç hedefe vardıysa ve henüz eklenmediyse
                if (arac.getDurum().equals("Vardı") && !arac.isHedefeEklendiMi()) {
                    int gelenKisiSayisi = 0;
                    for (Kisi k : kisiler) {
                        if (k.getAracAdi().equals(arac.getAd()) && k.hayattaMi()) {
                            gelenKisiSayisi++;
                        }
                    }
                    gezegenNufus.put(arac.getHedef(), gezegenNufus.get(arac.getHedef()) + gelenKisiSayisi);
                    arac.setHedefeEklendiMi(true); // Aynı araç iki kere eklemesin
                }

                System.out.printf("%-15s | %-10s | %-6s | %-6s | %-17.1f | %-25s%n",
                        arac.getAd(), arac.getDurum(), arac.getCikis(), arac.getHedef(),
                        arac.getKalanSaat(), arac.getVarisTahmini());
            }
            System.out.println();

            // Kişiler her saatte yaşlanacak
            for (Kisi kisi : kisiler) {
                kisi.saatIlerle();
            }

            // Gezegenlerde saat ilerlemesi
            for (Gezegen g : gezegenler.values()) {
                g.birSaatIlerle();
            }

            // Simülasyon devam kontrolü
            simulasyonDevamEdiyor = false;
            for (Arac arac : araclar) {
                if (!arac.getDurum().equals("Vardı") && !arac.getDurum().equals("İMHA")) {
                    simulasyonDevamEdiyor = true;
                    break;
                }
            }

            Thread.sleep(5); //0.005 saniye bekle
            iterasyonSayisi++;
        }

        System.out.println("Simülasyon sonlandı.");
    }

    // Konsolu temizleme fonksiyonu
    public static void clearConsole() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Konsol temizlenemedi: " + ex.getMessage());
        }
    }
}
