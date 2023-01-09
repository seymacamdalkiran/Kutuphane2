package kutuphane;

import java.util.Scanner;

public class MainKutuphane {

    public static void main(String[] args) {

      Insanlar admin=new Admin("Harun", Sifat.admin);
      admin.personelEkle(admin);
        admin.anaSayfa();


        // KİTAP ALMAK İÇİN 3 HAK VAR, onu yapamamışsın

        // elimdeki kitaplar metodu çalışmıyor.

    }
}
