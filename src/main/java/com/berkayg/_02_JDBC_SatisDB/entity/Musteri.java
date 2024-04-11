package com.berkayg._02_JDBC_SatisDB.entity;

public class Musteri extends BaseEntity {
    private Integer id;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private Long dtarih;
    private String email;
    private String tel;

    public Musteri() {
    }

    public Musteri(String ad, String soyad, String cinsiyet, Long dtarih, String email, String tel) {
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dtarih = dtarih;
        this.email = email;
        this.tel = tel;
    }

    public Musteri(Integer id, String ad, String soyad, String cinsiyet, Long dtarih, String email, String tel) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dtarih = dtarih;
        this.email = email;
        this.tel = tel;
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

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Long getDtarih() {
        return dtarih;
    }

    public void setDtarih(Long dtarih) {
        this.dtarih = dtarih;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Musteri{");
        sb.append("id='").append(id).append('\'');
        sb.append(", ad='").append(ad).append('\'');
        sb.append(", soyad='").append(soyad).append('\'');
        sb.append(", cinsiyet='").append(cinsiyet).append('\'');
        sb.append(", dtarih=").append(dtarih);
        sb.append(", email='").append(email).append('\'');
        sb.append(", tel='").append(tel).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
