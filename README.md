## _API _ PELUQUERIA_

Esta es una API para una peluqueria hecha a modo de practica,
la misma se conforma de Usuarios, Turnos y Peluqueros.
Permite crear turnos asignando un usuario, un peluquero y una fecha, 
solo permite crear un turno si el peluquero cuenta con ese fecha disponible,
en caso contrario se devuelve un error.
Tanto los peluqueros como los usuarios deben estar registriados.

Tambien cuenta con un microservicios el cual almacena la configuracion
tanto del proyecto de API como del proyecto de notificaciones.
Este segundo proyecto se encarga de enviarle un mail al cliente cuando
su turno ya fue confirmado.

## Caracteristicas

- Creacion de entidades en base de datos Postgresql.
- Validacion de datos en cada entidad.
- Validacion de disponibilidad de turnos por parte del peluquero
- Comunicacion entre microservicios
- Envio de mail al reservar un turno

## Paquetes utilizados

Estos son algunos de los paquetes utilizados en el proyecto.

| Paquete | Repositorio |
| ------ | ------ |
| Kafka | [KAFKA_REPO](https://mvnrepository.com/artifact/org.springframework.kafka/spring-kafka) |
| Eureka | [EUREKA_REPO](https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-client) |
| JPA | [JPA_REPO](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa) |
| Lombok | [LOMBOK_REPO](https://mvnrepository.com/artifact/org.projectlombok/lombok) |
| Spring Web | [WEB_REPO](https://mvnrepository.com/artifact/org.springframework/spring-web) |
| Zipkin | [ZIPKIN_REPO](https://mvnrepository.com/artifact/io.zipkin.reporter2/zipkin-reporter) |

Creado por **Santiago Gorbea** 

