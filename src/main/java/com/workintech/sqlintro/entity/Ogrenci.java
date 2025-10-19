package com.workintech.sqlintro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ogrenci")
public class Ogrenci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ogrno;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String sinif;
    private int puan;
    @Column(nullable = true)
    private String dtarih;


    public Long getOgrno() {
        return ogrno;
    }

    public void setOgrno(Long ogrno) {
        this.ogrno = ogrno;
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

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public String getDtarih() {
        return dtarih;
    }

    public void setDtarih(String dtarih) {
        this.dtarih = dtarih;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ogrenci ogrenci = (Ogrenci) o;
        return puan == ogrenci.puan && Objects.equals(ogrno, ogrenci.ogrno) && Objects.equals(ad, ogrenci.ad) && Objects.equals(soyad, ogrenci.soyad) && Objects.equals(cinsiyet, ogrenci.cinsiyet) && Objects.equals(sinif, ogrenci.sinif) && Objects.equals(dtarih, ogrenci.dtarih);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ogrno, ad, soyad, cinsiyet, sinif, puan, dtarih);
    }


}