# 🚀 Interstellar Travel Simulation (Yıldızlararası Seyahat Simülasyonu)

![Java](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/Paradigm-Object%20Oriented-blue?style=for-the-badge)
![Simulation](https://img.shields.io/badge/Type-Console%20Simulation-green?style=for-the-badge)

## 🌌 Proje Hakkında (About)
Bu proje, Java kullanılarak geliştirilmiş, metin tabanlı bir **uzay lojistik ve seyahat simülasyonudur**. 

Sistem; farklı gezegenler arasındaki mesafeleri, gezegenlerin kendi dönme sürelerine (bir günün kaç saat olduğu) göre zamanı ve uzay araçlarındaki mürettebatın yaşam sürelerini hesaplar. Simülasyon gerçek zamanlı olarak akar; araçlar yola çıkar, yakıt/zaman tüketir ve mürettebat yaşlanır. Eğer mürettebat yolda hayatını kaybederse araç "İMHA" edilir.

## ✨ Özellikler (Features)

* **Dinamik Zaman Yönetimi:** Her gezegenin kendine özgü bir zaman akışı (saat/gün oranı) vardır ve varış süreleri buna göre hesaplanır.
* **Yaşam Döngüsü Simülasyonu:** Mürettebat üyeleri (`Kisi`), seyahat süresince yaşlanır. Kalan ömürleri tükendiğinde ölürler ve araç sahipsiz kalırsa imha olur.
* **Dosya Tabanlı Veri Girişi:** Gezegenler, Araçlar ve Kişiler `dist` klasöründeki metin dosyalarından (`.txt`) dinamik olarak okunur.
* **Anlık Durum Takibi:** Konsol ekranında simülasyon her adımda (örneğin her saatte) güncellenerek araçların durumu (`Bekliyor`, `Yolda`, `Vardı`, `İMHA`) raporlanır.

## 🛠️ Kullanılan Teknolojiler

* **Dil:** Java (JDK 8+)
* **Mimari:** Nesne Yönelimli Programlama (OOP)
* **Giriş/Çıkış:** Java I/O (BufferedReader, FileReader)
* **Zamanlama:** `Thread` yapısı ile simülasyon akışı.

## 📂 Dosya Yapısı ve Sınıflar

* **`Main.java`**: Simülasyonun başlatıldığı, döngünün döndüğü ve ekranın güncellendiği ana sınıf.
* **`Arac.java`**: Uzay aracının özelliklerini, konumunu ve durumunu (Yolda, Vardı vb.) yönetir.
* **`Gezegen.java`**: Gezegenlerin isim, saat sayısı ve tarih bilgisini tutar.
* **`Kisi.java`**: Mürettebatın ismini ve kalan ömrünü takip eder.
* **`DosyaOkuyucu.java`**: `.txt` dosyalarından verileri okuyup nesnelere dönüştürür.
* **`ZamanHesaplayici.java`**: İki tarih arasındaki farkı ve varış zamanını gezegenin saat dilimine göre hesaplayan yardımcı sınıf.

## ⚙️ Kurulum ve Çalıştırma

1.  Repoyu bilgisayarınıza indirin.
2.  Java derleyicisi (javac) ile dosyaları derleyin:
    ```bash
    javac packet/*.java
    ```
3.  Simülasyonu başlatın:
    ```bash
    java packet.Main
    ```
    *(Not: `dist` klasörü içerisinde `Gezegenler.txt`, `Araclar.txt` ve `Kisiler.txt` dosyalarının bulunduğundan emin olun.)*

## 📄 Veri Giriş Formatı (Input Files)

Proje `dist` klasörü altında şu formatta dosyalar bekler (Ayıraç: `#`):

* **Gezegenler.txt:** `GezegenAdı#GünlükSaat#BaşlangıçTarihi`
    * *Örnek:* `Kripton#30#01.01.2000`
* **Araclar.txt:** `AraçAdı#ÇıkışYeri#Hedef#ÇıkışTarihi#Mesafe`
    * *Örnek:* `Milenyum Şahini#Dünya#Mars#05.05.2025#500`
* **Kisiler.txt:** `İsim#Yaş#KalanÖmür#AraçAdı`
    * *Örnek:* `Han Solo#35#1000#Milenyum Şahini`

---
*Developed by Ali Selman Erkan - Computer Engineering Student at Sakarya University*
