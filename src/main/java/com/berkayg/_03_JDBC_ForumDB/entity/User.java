package com.berkayg._03_JDBC_ForumDB.entity;

public class User {
    private Long id;
    private String ad;
    private String soyad;
    private String username;
    private String password;

    public User() {
    }

    public User(String ad, String soyad, String username, String password) {
        this.ad = ad;
        this.soyad = soyad;
        this.username = username;
        this.password = password;
    }

    public User(Long id, String ad, String soyad, String username, String password) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", ad='").append(ad).append('\'');
        sb.append(", soyad='").append(soyad).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
