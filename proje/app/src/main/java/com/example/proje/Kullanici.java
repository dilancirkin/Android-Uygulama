package com.example.proje;

public class Kullanici {

    private int id;
    private String AdSoyad;
    private String asiSirasi;

    public Kullanici(int id, String adSoyad, String asiSirasi) {
        this.id = id;
        AdSoyad = adSoyad;
        this.asiSirasi = asiSirasi;
    }
    public Kullanici()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdSoyad() {
        return AdSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        AdSoyad = adSoyad;
    }

    public String getAsiSirasi() {
        return asiSirasi;
    }

    public void setAsiSirasi(String asiSirasi) {
        this.asiSirasi = asiSirasi;
    }


}