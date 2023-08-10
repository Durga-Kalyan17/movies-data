package com.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movies.entities.UpcomingIMDBIdList;

public interface UpcomingMovieIMDbIdRepository extends JpaRepository<UpcomingIMDBIdList, Long>{

}
