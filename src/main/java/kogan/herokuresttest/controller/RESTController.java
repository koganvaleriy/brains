package kogan.herokuresttest.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class RESTController {
	
	@RequestMapping("/")
	@ResponseBody
	public String checkAuthentification() {
		return "OK";
	}	

	public static void main(String[] args) {
		SpringApplication.run(RESTController.class, args);
		System.out.println("Server is on");
	}

}
