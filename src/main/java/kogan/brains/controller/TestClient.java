package kogan.brains.controller;

import static kogan.brains.api.UserRequestMethods.*;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kogan.brains.api.UserData;

public class TestClient {
	
	
	static RestTemplate restTemplate = new RestTemplate();
	static String url = "http://localhost:8080/";

	public static void main(String[] args) throws JsonProcessingException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		
		// Registration Test
		
		/*
		UserData userData = new UserData("username22", "email22", "password22");
		String json = mapper.writeValueAsString(userData);

		HttpEntity<String> request = new HttpEntity<>(json, headers);

		ResponseEntity<String> response = restTemplate.exchange(url + REGISTRATION, HttpMethod.POST, request,
				new ParameterizedTypeReference<String>() {
				});
		
		System.out.println(REGISTRATION + " " + response.getBody());
		*/
		// Login Test
		
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		mapper = new ObjectMapper();

		UserData userData = new UserData("username20", "password11");
		String json = mapper.writeValueAsString(userData);

		HttpEntity<String> request = new HttpEntity<>(json, headers);

		ResponseEntity<String> response = restTemplate.exchange(url + LOGIN, HttpMethod.POST, request,
				new ParameterizedTypeReference<String>() {
				});
		
		System.out.println(LOGIN + " " + response.getBody());
		
	}

}
