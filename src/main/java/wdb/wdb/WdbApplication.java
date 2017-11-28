package wdb.wdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;


@SpringBootApplication
@ComponentScan(basePackages = {"api", "connection"})
@EntityScan(basePackages = { "entity" })
public class WdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WdbApplication.class, args);
	}
}
