package com.mertnamsal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
public class MusteriDetay {
	
	@Id
	private long id;
	
	private double bakiye;
	
	private double borc;
	

	
	public MusteriDetay() {
	}

	public MusteriDetay(long id, double bakiye, double borc) {
		super();
		this.id = id;
		this.bakiye = bakiye;
		this.borc = borc;
	}
	
	
	
	
}
