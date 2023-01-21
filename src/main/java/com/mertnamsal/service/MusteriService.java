package com.mertnamsal.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.mertnamsal.entity.Musteri;
import com.mertnamsal.entity.MusteriDetay;
import com.mertnamsal.repository.MusteriDao;

public class MusteriService {

	private MusteriDao musteriDao = new MusteriDao();

	public MusteriService() {
		super();
	}

	public void save(Musteri musteri) {
		musteri.setSifre(DigestUtils.sha256Hex(musteri.getSifre()));
		musteriDao.save(musteri);
	}

	public boolean girisKontrol(String tcKimlik, String sifre) {
		boolean kontrol =musteriDao.girisKontrol(tcKimlik,DigestUtils.sha256Hex(sifre));
		return kontrol;
	}

	public void bakiyeGuncelle(int tc,Double bakiye) {
		musteriDao.bakiyeGuncelle(tc,bakiye);
		
	}

	public double bakiyeGetir(int tc) {
		MusteriDetay musteriDetay = musteriDao.musteriDetayGetir(tc);
		return musteriDetay.getBakiye();
		
	}

	public void sifreDegistir(int tc, String yeniSifre) {
		musteriDao.sifreDegistir(tc,DigestUtils.sha256Hex(yeniSifre));
		
	}

	public void hesabiSil(int tc) {
		musteriDao.delete(tc);
		
	}

	public double borcGetir(int tc) {
		MusteriDetay musteriDetay =musteriDao.musteriDetayGetir(tc);
		return musteriDetay.getBorc();
	}

	public void borcGuncelle(int tc,double borc) {
		musteriDao.borcGuncelle(tc,borc);
		
	}

	
	
}
