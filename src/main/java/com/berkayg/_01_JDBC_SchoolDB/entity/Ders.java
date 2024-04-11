package com.berkayg._01_JDBC_SchoolDB.entity;

public class Ders {
    private Integer id;
    private String ad;


    public Ders() {
    }

    public Ders(Integer id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public Ders(String ad) {
        this.ad = ad;
    }

    public int getId() {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ders{");
        sb.append("id=").append(id);
        sb.append(", ad='").append(ad).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

