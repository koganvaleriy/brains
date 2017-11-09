package kogan.herokuresttest.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration//(exclude={DataSourceAutoConfiguration.class})
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
