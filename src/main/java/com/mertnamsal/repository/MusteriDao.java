package com.mertnamsal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.mertnamsal.entity.Musteri;
import com.mertnamsal.entity.MusteriDetay;
import com.mertnamsal.util.HibernateUtils;

public class MusteriDao implements ICrud<Musteri> {

	@Override
	public void save(Musteri musteri) {
		Transaction transaction =null;
		try(Session session = databaseConnectionHibernate()){
			transaction = session.beginTransaction();
			session.save(musteri);
			transaction.commit();
			session.close();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Saved Error...");
		}
		
	}

	@Override
	public void update(Musteri t, long tc) {
		Transaction transaction =null;
		try(Session session = databaseConnectionHibernate()){
			transaction = session.beginTransaction();
			
			//session.update(t);
			transaction.commit();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Saved Error...");
		}
		
	}

	@Override
	public void delete(int tc) {
		Transaction transaction = null;
		try(Session session = databaseConnectionHibernate()){
			Musteri musteri = musteriGetir(tc);
			transaction = session.beginTransaction();
			session.delete(musteri);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Saved Error...");
		}
		
	}


	public boolean girisKontrol(String tcKimlik, String sifre) {
		Transaction transaction = null;
		List<Musteri>musteri = null;
		try(Session session = databaseConnectionHibernate()){
			transaction = session.beginTransaction();
			musteri = session.createQuery("Select müşteri from Musteri as müşteri where müşteri.tcKimlik ='"+tcKimlik+"' and müşteri.sifre ='"+sifre+"'",Musteri.class).list();	
			transaction.commit();
			if(!musteri.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Giriş Başarılı");
				return true;
			}
			
		
		
		}
		JOptionPane.showMessageDialog(null,"Giriş Başarısız");
		return false;
	}

	public void bakiyeGuncelle(int tc,double bakiye) {
		Transaction transaction =null;
		try(Session session = databaseConnectionHibernate()){
			
			MusteriDetay musteriDetay = musteriDetayGetir(tc);
			musteriDetay.setBakiye(bakiye);
			transaction = session.beginTransaction();
			session.update(musteriDetay);
			transaction.commit();
			session.close();
			
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			
		}
		
	}

	public MusteriDetay musteriDetayGetir(int tc) {
		Transaction transaction =null;
		MusteriDetay musteriDetay = null;
		try(Session session = databaseConnectionHibernate()){
			transaction = session.beginTransaction();
			musteriDetay = (MusteriDetay)session.createQuery("select musteridetay from MusteriDetay as musteridetay where musteridetay.id = '"+tc+"'").getSingleResult();
			transaction.commit();
			session.close();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			
		}
		
		return musteriDetay;
	}
	
	public Musteri musteriGetir(int tc) {
		Transaction transaction =null;
		Musteri musteri = null;
		try(Session session = databaseConnectionHibernate()){
			transaction = session.beginTransaction();
			musteri = (Musteri)session.createQuery("select müşteri from Musteri as müşteri where müşteri.tcKimlik ='"+tc+"'").getSingleResult();
			transaction.commit();
			session.close();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			
		}
		
		return musteri;
	}

	public void sifreDegistir(int tc, String yeniSifre) {
		Musteri musteri =musteriGetir(tc);
		musteri.setSifre(yeniSifre);
		
		Transaction transaction =null;
		try(Session session = databaseConnectionHibernate()){
			transaction = session.beginTransaction();
			session.update(musteri);
			transaction.commit();
			session.close();
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			System.out.println("Şifre değişirken hatayla karşılaşıldı.");
		}
	}

	public void borcGuncelle(int tc, double borc) {
		Transaction transaction =null;
		try(Session session = databaseConnectionHibernate()){
			
			MusteriDetay musteriDetay = musteriDetayGetir(tc);
			musteriDetay.setBorc(borc);
			transaction = session.beginTransaction();
			session.update(musteriDetay);
			transaction.commit();
			session.close();
			
		}catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			
		}
		
	}

	

	
}
