package com.citaexpressbk.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitaExpressApplication {

	public static void main(String[] args) {
		String environment = System.getenv("ENVIRONMENT");
		if (environment == null || !environment.equals("production")) {
			// Solo carga .env si NO estás en producción
			try {
				// Cargar las variables de entorno desde el archivo .env
				Dotenv dotenv = Dotenv.load();
				System.setProperty("DB_URL", dotenv.get("DB_URL"));
				System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
				System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
				System.out.println("Archivo .env cargado exitosamente.");
			} catch (Exception e) {
				System.out.println("Archivo .env no encontrado. Continuando con variables del sistema.");
			}
		} else {
			System.out.println("Entorno de producción detectado. Usando variables del sistema.");
		}

		// Iniciar la aplicación Spring Boot
		SpringApplication.run(CitaExpressApplication.class, args);
	}
}