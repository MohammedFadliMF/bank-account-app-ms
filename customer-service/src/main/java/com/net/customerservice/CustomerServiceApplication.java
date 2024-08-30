package com.net.customerservice;

import com.net.customerservice.config.GlobalConfig;
import com.net.customerservice.entities.Customer;
import com.net.customerservice.reppository.CustomerRepositoy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepositoy customerRepositoy){
		return args -> {

			List<Customer> listCustomers=List.of(
					Customer.builder()
							.firstName("omar")
							.lastName("zinane")
							.email("omar@gmail.com")
							.build(),
					Customer.builder()
							.firstName("mohammed")
							.lastName("fadli")
							.email("mohammed@gmail.com")
							.build()
			);
			customerRepositoy.saveAll(listCustomers);
		};
	}
}
