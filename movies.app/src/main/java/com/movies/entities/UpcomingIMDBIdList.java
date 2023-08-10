package com.movies.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "upcoming_movies")
public class UpcomingIMDBIdList {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column
	String  IMDbId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIMDbId() {
		return IMDbId;
	}

	public void setIMDbId(String response) {
		IMDbId = response;
	}
	
	
	public UpcomingIMDBIdList() {
	}

	public UpcomingIMDBIdList(Long id, String iMDbId) {
		this.id = id;
		this.IMDbId = iMDbId;
	}
	
	@Override
	public String toString() {
		return "IMDbIdList [id=" + id + ", IMDbId=" + IMDbId + "]";
	}

}
