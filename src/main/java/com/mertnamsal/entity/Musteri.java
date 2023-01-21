package com.mertnamsal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "müşteri")
public class Musteri {
	
	@Id
	@Column(unique=true)
	private long tcKimlik;
	
	private String ad;
	
	private String soyad;
	@Column(unique=true, length = 15)
	private long cepNo;
	
	@Column(length =65)
	private String sifre;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private MusteriDetay musteriDetay;
	
	public Musteri() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Musteri(long tcKimlik, String ad, String soyad, long cepNo,String sifre,MusteriDetay musteriDetay) {
		super();
		this.tcKimlik = tcKimlik;
		this.ad = ad;
		this.soyad = soyad;
		this.cepNo = cepNo;
		this.sifre = sifre;
		this.musteriDetay= musteriDetay;
	}

	public Musteri(String ad, String soyad, long cepNo,String sifre) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.cepNo = cepNo;
		this.sifre = sifre;
	}

	public long getTcKimlik() {
		return tcKimlik;
	}

	public void setTcKimlik(long tcKimlik) {
		this.tcKimlik = tcKimlik;
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

	public long getCepNo() {
		return cepNo;
	}

	public void setCepNo(long cepNo) {
		this.cepNo = cepNo;
	}

	
	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	

	public MusteriDetay getMusteriDetay() {
		return musteriDetay;
	}

	public void setMusteriDetay(MusteriDetay musteriDetay) {
		this.musteriDetay = musteriDetay;
	}

	@Override
	public String toString() {
		return "Musteri [tcKimlik=" + tcKimlik + ", ad=" + ad + ", soyad=" + soyad + ", cepNo=" + cepNo + "]";
	}

	
	
}
