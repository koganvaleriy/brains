package kogan.brains.controller;


import static kogan.brains.api.UserRequestMethods.*;

import java.io.IOException;


//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kogan.brains.api.UserData;
import kogan.brains.authentification.Token;
import kogan.brains.dao.UsersOrm;
import kogan.brains.entities.User;
import kogan.brains.model.UserStatus;


@RestController
@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class RESTController {
	
	@Autowired
	public UsersOrm usersRepository;
	
	@RequestMapping(CHECK)
	@ResponseBody
	public String checkAuthentification() {
		return "OK";
	}
	
	@CrossOrigin
	@RequestMapping(value=REGISTRATION, method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody String userDataJson) {
		
		Token token = new Token();
		ObjectMapper mapper = new ObjectMapper();
		UserData userData;
		UserStatus userStatus = new UserStatus();
		
		try {
			userData = mapper.readValue(userDataJson, UserData.class);
			userData.setToken(token);
			userData.setScore(0);
			userData.setUserStatus(userStatus.getUserStatuses().get(0));
			userData.setLevelNumber(1);
			
			if (usersRepository.addUser(userData) == true){
				String json;
				try {
					//status code 200
					json = mapper.writeValueAsString(userData);
					return new ResponseEntity<>(json, HttpStatus.OK);
	
				} catch (JsonProcessingException e) {
					//status code 406
					return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
				}
			} else {
				//status code 409, username already exists
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		} catch (IOException e1) {
			//status code 406
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value=LOGIN, method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody String userDataJson) {
		
		ObjectMapper mapper = new ObjectMapper();
		UserData userData;
		
		try {
			userData = mapper.readValue(userDataJson, UserData.class);
			
			//Check username existing in DB
			User user = usersRepository.getUserByUsername(userData);
			if (user != null && usersRepository.checkPassword(userData)){
				String json;
				try {
					//status code 200
					json = mapper.writeValueAsString(user);
					return new ResponseEntity<>(json, HttpStatus.OK);
	
				} catch (JsonProcessingException e) {
					//status code 406
					return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
				}
				
			} else {
				
				//Check email existing in DB if username not exists
				user = usersRepository.getUserByEmail(userData);
				if (user != null && usersRepository.checkPassword(userData)){
					String json;
					try {
						//status code 200
						json = mapper.writeValueAsString(user);
						return new ResponseEntity<>(json, HttpStatus.OK);
		
					} catch (JsonProcessingException e) {
						//status code 406
						return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
					}
				} else {
					//status code 401, username and email were not found or password incorrect 
					return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
				}
			}
		} catch (IOException e1) {
			//status code 406
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	/*
	@CrossOrigin
	@RequestMapping(value=LEVELS_LIST, method = RequestMethod.GET, consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getLevelsList() {
		
		Token token = new Token();
		ObjectMapper mapper = new ObjectMapper();
		UserData userData;
		UserStatus userStatus = new UserStatus();
		//HandlerInterceptor.preHandle()
		
		try {
			userData = mapper.readValue(userDataJson, UserData.class);
			userData.setToken(token);
			userData.setScore(0);
			userData.setUserStatus(userStatus.getUserStatuses().get(0));
			userData.setLevelNumber(1);
			
			if (usersRepository.addUser(userData) == true){
				String json;
				try {
					//status code 200
					json = mapper.writeValueAsString(userData);
					return new ResponseEntity<>(json, HttpStatus.OK);
	
				} catch (JsonProcessingException e) {
					//status code 406
					return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
				}
			} else {
				//status code 409, username already exists
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
		} catch (IOException e1) {
			//status code 406
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	*/

	public static void main(String[] args) {
		SpringApplication.run(RESTController.class, args);
		System.out.println("Server is on");
	}

}
