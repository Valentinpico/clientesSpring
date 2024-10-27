package ec.valentin.cuentamovimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ec.valentin")

public class CuentamovimientoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuentamovimientoApplication.class, args);
	}

}