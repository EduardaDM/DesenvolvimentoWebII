package com.locadora.api;

/*
@SpringBootApplication é uma combinação de três anotações
@SpringBootConfiguration: Diz ao Spring que esta é a classe de configuração principal.
@EnableAutoConfiguration: faz o Spring verificar todas as
dependências que você colocou no pom.xml e configura tudo automaticamente.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}