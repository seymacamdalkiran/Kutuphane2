package kutuphane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Insanlar extends Kutuphane {

     String name;
     String id;
     String tip;


    static int counter;

    public Insanlar(String name, Sifat sft){
        this.name=name;
        this.tip= sft.name();
        counter++;
        this.id=""+sft+counter;

    }


    public Insanlar() {}


    public abstract void oduncKitapAl();
    public abstract void getAlinabilecekKitapListesi();
    public abstract void kitapTeslimEt();        //else durumuna bi bak!!! böyle bir kitap yok de
    public abstract void personelEkle();
    public abstract void getKitapListesi();
    public abstract void kitapEkle();
    public abstract void kitapSil();
    public abstract void personelleriListele();
    public abstract void adminleriListele();
    public abstract void uyeleriListele();
    public abstract void personelSil();
    public abstract void benimKitaplarım();
   public static void personelEkle(Insanlar kisi){
        if(kisi.tip.equalsIgnoreCase("üye")){
            insan.add(kisi);
            uyeler.add((Uyeler) kisi);
        } else if (kisi.tip.equalsIgnoreCase("admin")) {
            insan.add(kisi);
            adminler.add((Admin) kisi);
        }
    }


    public void anaSayfa() {
        System.out.println("----------------------------------------------------");

        scan.nextLine();

        System.out.println("Lütfen id numaranızı yazın.");
        String idNo = scan.nextLine();
        for (int i = 0; i < adminler.size(); i++) {
            if(idNo.equals(adminler.get(i).id)){
                Admin ad=new Admin();
                ad.adminIslemleri();
            }
        }
        for (int i = 0; i < uyeler.size() ; i++) {
            if(idNo.equals(uyeler.get(i).id)){
                Uyeler u=new Uyeler();
                u.uyeIslemleri();
            }
        }

        anaSayfa();
    }
}
