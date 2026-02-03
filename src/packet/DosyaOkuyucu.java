/**
*
* @author Ali Selman ERKAN   ,  selman.erkan@ogr.sakrya.edu.tr
* @since Programın yazıldığı tarih    26.04.2025
* <p>
* DOSYA OKUYUCU ( FİLE READER  ) SINIFI  
* </p>
*/

package packet;

import java.io.*;
import java.util.*;

public class DosyaOkuyucu {
    public static Map<String, Gezegen> gezegenleriOku(String yol) throws Exception {
        Map<String, Gezegen> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(yol))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("#");
                map.put(p[0], new Gezegen(p[0], Integer.parseInt(p[1]), p[2]));
            }
        }
        return map;
    }

    public static List<Arac> araclariOku(String yol) throws Exception {
        List<Arac> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(yol))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("#");
                list.add(new Arac(p[0], p[1], p[2], p[3], Double.parseDouble(p[4])));
            }
        }
        return list;
    }

    public static List<Kisi> kisileriOku(String yol) throws Exception {
        List<Kisi> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(yol))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split("#");
                if (p.length == 4) {
                    list.add(new Kisi(p[0], Integer.parseInt(p[1]), Long.parseLong(p[2]), p[3]));
                } else {
                    System.out.println("Hatalı satır atlandı: " + line);
                }
            }
        }
        return list;
    }
}
