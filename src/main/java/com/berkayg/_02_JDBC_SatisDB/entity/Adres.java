package com.berkayg._02_JDBC_SatisDB.entity;

public class Adres extends BaseEntity{
    private Integer id;
    private Integer musteri_id;
    private String il;
    private String ilce;
    private String mahalle;
    private String adres;

    public Adres() {
    }

    public Adres(Integer musteri_id, String il, String ilce, String mahalle, String adres) {
        this.musteri_id = musteri_id;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.adres = adres;
    }

    public Adres(Integer id, Integer musteri_id, String il, String ilce, String mahalle, String adres) {
        this.id = id;
        this.musteri_id = musteri_id;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.adres = adres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(Integer musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Runner{");
        sb.append("id=").append(id);
        sb.append(", musteri_id=").append(musteri_id);
        sb.append(", il='").append(il).append('\'');
        sb.append(", ilce='").append(ilce).append('\'');
        sb.append(", mahalle='").append(mahalle).append('\'');
        sb.append(", adres='").append(adres).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
