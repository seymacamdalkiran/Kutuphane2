package kutuphane;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Uyeler extends Insanlar {



    public Uyeler(String name, Sifat sifat) {
        super(name, sifat);
    }
    public Uyeler(){}


    @Override
    public void getAlinabilecekKitapListesi() {
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < tumKitaplar.size() ; i++) {
            if(tumKitaplar.get(i).drm==Durum.alinabilir){
            System.out.println(tumKitaplar.get(i).kitapAdi);
        }}
        uyeIslemleri();
    }

    @Override
    public void kitapTeslimEt() {
        System.out.println("----------------------------------------------------");

        scan.nextLine();
        System.out.println("Teslim etmek istediğiniz kitabın id nosunu yazın");
        String ktpID=scan.nextLine();
        loop:   for (int i = 0; i < tumKitaplar.size(); i++) {
            if(ktpID.equals(tumKitaplar.get(i).idKitap)){
                //for (int j = 0; j < alınabilecekKitaplar.size() ; j++) {
                //  if( ktpID.equalsIgnoreCase(alınabilecekKitaplar.get(j).kitapAdi) ){
                //    System.out.println("Bu kitap zaten kütüphanemizde var");
                //  break loop;
                //}
                //    }
                tumKitaplar.get(i).drm=Durum.alinabilir;
                System.out.println("Kitabınızı teslim ettiniz.");
                //  alınabilecekKitaplar.add(tumKitaplar.get(i));
            }
        }
        uyeIslemleri();
    }

    @Override
    public void getKitapListesi() {
        System.out.println("Sadece alabileceğiniz kitapları görebilirsiniz");
    }

    @Override
    public void benimKitaplarım() {
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < uyeBook.size() ; i++) {
            System.out.println(uyeBook.get(i).kitapAdi);
        }
        System.out.println("Elimdeki kitap sayısı = " + uyeBook.size());
            uyeIslemleri();
    }

    @Override
    public void kitapSil() {
        System.out.println("Kitap silme yetkiniz yoktur");
    }

    @Override
    public void kitapEkle() {
        System.out.println("Kitap ekleme yetkiniz yoktur");
    }

    @Override
    public void personelEkle() {
        System.out.println("Personel ekleme yetkiniz yoktur.");
    }

    @Override
    public void personelSil() {
        System.out.println("Personel silme yetkiniz yoktur.");
    }

    @Override
    public void personelleriListele() {
        System.out.println("Personelleri listeleme yetkiniz yoktur.");
    }

    @Override
    public void adminleriListele() {
        System.out.println("Adminleri listeleme yetkiniz yoktur");
    }

    @Override
    public void uyeleriListele() {
        System.out.println("Uyeleri listeleme yetkiniz yoktur");
    }

    public void uyeIslemleri(){
        Scanner scan=new Scanner(System.in);

        System.out.println("----------------------------------------------------");

        System.out.println("Yapmak istediğiniz işlemi yazın");
        System.out.println("Alabileceğiniz kitapları listelemek için => 1\nKütüphanemizden kitap alabilmek için => 2\n" +
                "Daha önce aldığınız kitabı teslim etmek için => 3\nElinizdeki kitapları görebilmek için => 4" +
                "\nBir üst menüye dönmek için => 5\nCıkıs yapmak için => 6");
        try {
            int   secim = scan.nextInt();

            if (secim == 1) {
                getAlinabilecekKitapListesi();
            } else if (secim == 2) {
                oduncKitapAl();
            } else if (secim == 3) {
                kitapTeslimEt();
            } else if(secim==4){
                benimKitaplarım();
            } else if(secim==5){
                anaSayfa();
            } else if (secim == 6) {
                System.exit(0);
            } else {
                System.out.println("Hatalı tuşlama yaptınız");
                uyeIslemleri();
            }
        } catch (Exception e) {
            System.out.println("Hatalı tuşlama yaptınız yeniden denemelisiniz.");

        }
        uyeIslemleri();
    }

    @Override
    public void oduncKitapAl() {
        Scanner scan=new Scanner(System.in);
        System.out.println("----------------------------------------------------");
        System.out.println("myBook.size() ONCE = " + adminBook.size());
        if(adminBook.size()>=3){
            System.out.println("Lütfen kitap almak için kitap teslim ediniz.");
            anaSayfa();
        }
        // scan.nextLine();
        System.out.println("Almak istediğiniz kitabın id nosunu yazın");
        String ktpID=scan.nextLine();
        for (int i = 0; i < tumKitaplar.size() ; i++) {
            if(ktpID.equals(tumKitaplar.get(i).idKitap) && tumKitaplar.get(i).drm==Durum.alinabilir ){
                System.out.println("Kitabı alabilirsiniz. Teslim etmek için 15 gün süreniz var");
                adminBook.add(tumKitaplar.get(i));
                //  alınabilecekKitaplar.remove(alınabilecekKitaplar.get(i));
                tumKitaplar.get(i).drm=Durum.rezerve;
                break;
            }
        }

        for (int i = 0; i <adminBook.size() ; i++) {
            System.out.println("Elimdeki kitaplar "+adminBook.get(i).kitapAdi);
        }
        System.out.println("myBook.size() SONRA = " + adminBook.size());
        System.out.println("Başka bir kitap almak için => 1, Bir üst menüye dönmek için => 2 yi tuşlayın");
        String s=scan.nextLine();
        if(s.equals("1")){
            oduncKitapAl();
        }else {
            uyeIslemleri();
        }
        uyeIslemleri();

    }
}
