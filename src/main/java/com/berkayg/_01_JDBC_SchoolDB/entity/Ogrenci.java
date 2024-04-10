package com.berkayg._01_JDBC_SchoolDB.entity;

public class Ogrenci {
    Integer id;
    String ad;
    String soyad;
    Integer yas;
    String veliadi;
    String iletisimtel;

    public Ogrenci() {
    }

    public Ogrenci(String ad, String soyad, Integer yas, String veliadi, String iletisimtel) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.veliadi = veliadi;
        this.iletisimtel = iletisimtel;
    }

    public Ogrenci(Integer id, String ad, String soyad, Integer yas, String veliadi, String iletisimtel) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.veliadi = veliadi;
        this.iletisimtel = iletisimtel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    public String getVeliadi() {
        return veliadi;
    }

    public void setVeliadi(String veliadi) {
        this.veliadi = veliadi;
    }

    public String getIletisimtel() {
        return iletisimtel;
    }

    public void setIletisimtel(String iletisimtel) {
        this.iletisimtel = iletisimtel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ogrenci{");
        sb.append("id=").append(id);
        sb.append(", ad='").append(ad).append('\'');
        sb.append(", soyad='").append(soyad).append('\'');
        sb.append(", yas=").append(yas);
        sb.append(", veliadi='").append(veliadi).append('\'');
        sb.append(", iletisimtel='").append(iletisimtel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
