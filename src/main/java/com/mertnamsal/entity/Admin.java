package com.mertnamsal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@Entity
public class Admin {
	
	@Id
	private int tcKimlik;
	
	private String ad;
	
	private String soyad;
	
	@Column(nullable=false)
	private String sifre;
	
	
}
