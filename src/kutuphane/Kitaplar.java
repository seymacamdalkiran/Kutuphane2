package kutuphane;

public class Kitaplar extends Kutuphane{

    String kitapAdi;
    String idKitap;
    String yazarAdi;
    static int countKitap;

    Durum drm;

    public Kitaplar(String kitapAdi,String yazarAdi) {
        this.yazarAdi =yazarAdi;
        this.kitapAdi = kitapAdi;
        countKitap++;
        this.idKitap=kitapAdi.substring(0,1)+countKitap+yazarAdi.substring(0,1);
        drm=Durum.alinabilir;
    }


}
