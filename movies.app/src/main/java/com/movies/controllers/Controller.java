package com.movies.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movies.entities.PopularIMDbIdList;
import com.movies.entities.UpcomingIMDBIdList;
import com.movies.repository.PopularMovieIMDbRepository;
import com.movies.repository.UpcomingMovieIMDbIdRepository;

@RestController
@RequestMapping("/movies")
public class Controller {
	
	@Autowired
	PopularMovieIMDbRepository iMDbRepository;
	
	@Autowired
	UpcomingMovieIMDbIdRepository upcomingMovieIMDbIdRepository;

	@PostMapping("/post/popular-movies")
	public ResponseEntity<String> postPopularMovieIds(@RequestBody PopularIMDbIdList iMDbIdList) {

		String url = "https://imdb8.p.rapidapi.com/title/get-most-popular-movies";
		String apiKey = "07b1af7d7emshd671abf15c1dfffp1b1f50jsn1323f95b06db";
		String apiHost = "imdb8.p.rapidapi.com";
		
//		3bb2389ea8msh23423ff5fabf584p1c6b54jsn4d69b9591ba2
//		OLD_KEY = 12a7a1ffb6mshb783c3d4e515584p1fe300jsn2e9a61e9f658
		
		HttpHeaders headers = new HttpHeaders();
		 headers.set("X-RapidAPI-Key", apiKey);
		 headers.set("X-RapidAPI-Host", apiHost);
		 headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> requestEntity = new HttpEntity<>(null, headers);

		RestTemplate restTemplate = new RestTemplate();

		 ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		System.out.println(responseEntity);
		String response = responseEntity.getBody();
		System.out.println(response);
		
		String[] parts = response.split(",");
		
		List<String> movieIdList = new ArrayList<>();
		
		for (String part : parts) {
			movieIdList.add(part);
		}

		Long id = (long) 0;
		for(int i = 0; i < movieIdList.size(); i++) {
			iMDbIdList.setIMDbIdArr(movieIdList.get(i));
			id = (long) i + 1;
			iMDbIdList.setId(id);
			iMDbRepository.save(iMDbIdList);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("saved succesfully");
	}
	
	
	@GetMapping("/get/popular-movies")
	public ResponseEntity<?> getPopularMovieIds(){
		
		List<PopularIMDbIdList> responseList = iMDbRepository.findAll();
		
		List<String> IMDbId = new ArrayList<>();
		
		for(int i = 0; i < responseList.size(); i++) {
			IMDbId.add(responseList.get(i).getIMDbIdArr());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(IMDbId);
	}
	
	
	@PostMapping("/post/upcoming-movies")
	public ResponseEntity<String> postUpcomingMovieIds(@RequestBody UpcomingIMDBIdList upcomingIMDbIdList) {

		String url = "https://imdb8.p.rapidapi.com/title/get-coming-soon-movies";
		String apiKey = "07b1af7d7emshd671abf15c1dfffp1b1f50jsn1323f95b06db";
		String apiHost = "imdb8.p.rapidapi.com";
		
//		3bb2389ea8msh23423ff5fabf584p1c6b54jsn4d69b9591ba2
//		OLD_KEY = 12a7a1ffb6mshb783c3d4e515584p1fe300jsn2e9a61e9f658
		
		HttpHeaders headers = new HttpHeaders();
		 headers.set("X-RapidAPI-Key", apiKey);
		 headers.set("X-RapidAPI-Host", apiHost);
		 headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> requestEntity = new HttpEntity<>(null, headers);

		RestTemplate restTemplate = new RestTemplate();

		 ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		System.out.println(responseEntity);
		String response = responseEntity.getBody();
		System.out.println(response);
		
		String[] parts = response.split(",");
		
		List<String> movieIdList = new ArrayList<>();
		
		for (String part : parts) {
			movieIdList.add(part);
		}

		Long id = (long) 0;
		for(int i = 0; i < movieIdList.size(); i++) {
			upcomingIMDbIdList.setIMDbId(movieIdList.get(i));
			id = (long) i + 1;
			upcomingIMDbIdList.setId(id);
			upcomingMovieIMDbIdRepository.save(upcomingIMDbIdList);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("saved succesfully");
	}
	
	@GetMapping("/get/upcoming-movies")
	public ResponseEntity<?> getUpcomingMovieIds(){
		
		List<UpcomingIMDBIdList> UpcomingMovieResponse = upcomingMovieIMDbIdRepository.findAll();
		
		List<String> UpcomingMovieIMDbId = new ArrayList<>();
		
		for(int i = 0; i < UpcomingMovieResponse.size(); i++) {
			UpcomingMovieIMDbId.add(UpcomingMovieResponse.get(i).getIMDbId());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(UpcomingMovieIMDbId);
	}

}
