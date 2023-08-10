package com.movies.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="popular_movies_ids")
public class PopularIMDbIdList {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String  IMDbIdArr;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIMDbIdArr() {
		return IMDbIdArr;
	}

	public void setIMDbIdArr(String response) {
		IMDbIdArr = response;
	}
	
	
	public PopularIMDbIdList() {
	}

	public PopularIMDbIdList(Long id, String iMDbIdArr) {
		this.id = id;
		this.IMDbIdArr = iMDbIdArr;
	}
	
	@Override
	public String toString() {
		return "IMDbIdList [id=" + id + ", IMDbIdArr=" + IMDbIdArr + "]";
	}

}
