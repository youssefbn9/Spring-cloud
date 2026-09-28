package org.example.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Serveur de registre Eureka.
 *
 * @EnableEurekaServer active le tableau de bord Eureka accessible sur :
 *   http://localhost:8761
 *
 * Les microservices song et instrument s'enregistreront automatiquement
 * dès qu'ils démarrent avec la dépendance eureka-client configurée.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
