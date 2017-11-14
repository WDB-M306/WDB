package wdb.wdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"controller"})
public class WdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(WdbApplication.class, args);
	}
}
