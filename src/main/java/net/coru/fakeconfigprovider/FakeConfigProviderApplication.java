package net.coru.fakeconfigprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class FakeConfigProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeConfigProviderApplication.class, args);
	}

}
