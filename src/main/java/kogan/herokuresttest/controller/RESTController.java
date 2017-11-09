package kogan.herokuresttest.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ImportResource("classpath:beans.xml")
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
