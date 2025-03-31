package co.accessthreads.gobeyond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.accessthreads.gobeyond")
class GobeyondApplication {
	public static void main(String[] args) {
		SpringApplication.run(GobeyondApplication.class, args);
	}
}
