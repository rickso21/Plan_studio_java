package com.example.Plan_estudio_Java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlanEstudioJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanEstudioJavaApplication.class, args);
	}

}

/*

Cómo funciona el proyecto (flujo completo)
Petición HTTP → Llega al ProductoController (ej: GET /api/productos).

Controller → Llama al ProductoService (no accede directamente al repositorio; esto mantiene la lógica separada).

Service → Ejecuta la lógica de negocio (validaciones simples, mapeos) y llama al ProductoRepository.

Repository → Spring Data JPA genera la consulta SQL y la ejecuta contra MySQL.

Respuesta → El resultado se convierte a JSON (gracias a Jackson) y se devuelve al cliente.

Ventajas de esta arquitectura:

Separación de responsabilidades: Controller solo maneja HTTP; Service contiene reglas; Repository solo datos.

Testeable: Puedes hacer tests unitarios del Service sin levantar el servidor web.

Escalable: Si mañana cambias de MySQL a PostgreSQL, solo tocas la configuración.


//////////////////////////////////Log4j2 //////////////////////

Cómo funciona Log4j2 internamente (explicación clara)
Tu código llama a log.info(...) → SLF4J recibe la llamada.

SLF4J busca una implementación → Gracias al starter de Log4j2, encuentra log4j-slf4j-impl y le pasa el mensaje.

Log4j2 lee log4j2-spring.xml → Al arrancar, Spring Boot detecta este archivo y se lo indica a Log4j2.

Log4j2 aplica las reglas:

Si el logger se llama com.ejemplo.demo.controller.ProductoController, coincide con <Logger name="com.ejemplo.demo"> → nivel DEBUG permitido.

El mensaje INFO pasa el filtro (DEBUG es más bajo que INFO).

Se envía a todos los Appenders asociados: Console y Archivo.

PatternLayout formatea el mensaje y se escribe en los destinos.

Si en el futuro quieres subir el nivel a WARN para producción, solo cambias level="debug" a level="warn" en el XML o lo sobrescribes desde application.
properties con logging.level.com.ejemplo.demo=WARN (Spring Boot permite esta mezcla).

Con Log4j2 integrado, el CRUD ahora tiene observabilidad básica. Lo que sigue naturalmente es aplicar SOLID para refactorizar el Service (extraer interfaz e implementación), lo cual además te prepara para escribir tests unitarios más limpios. 
*/