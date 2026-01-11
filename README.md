# core-bancario-microservicios

Microservicios bancarios sencillos: `clientes-service` y `cuentas-service`.

## Estructura

- `clientes-service/` — servicio de clientes
- `cuentas-service/` — servicio de cuentas
- `docker-compose.yml` — orquesta servicios y dependencias (p. ej. base de datos)

## Requisitos

- JDK 17 (el proyecto está configurado actualmente para Java 17)
  - Ruta de ejemplo en Windows: `C:\Program Files\Java\jdk-17`
- Maven 3.6+
- Docker y Docker Compose (opcional, para levantar la base de datos y contenedores)
- PostgreSQL (si no usa Docker)

## Compilar

Desde la raíz del repositorio:

```bash
mvn -T1C -DskipTests package
```

Esto compila ambos módulos y genera los JAR en `target/`.

## Ejecutar (local)

Ejecutar un servicio a la vez:

```bash
mvn -pl clientes-service spring-boot:run
mvn -pl cuentas-service spring-boot:run
```

O ejecutar ambos mediante Docker Compose:

```bash
docker-compose up --build
```

## Base de datos

Cada módulo incluye `src/main/resources/schema.sql` con el DDL inicial.
Si usas PostgreSQL local, crea la base de datos y ejecuta el SQL. Con Docker Compose se puede aprovisionar automáticamente si el `docker-compose.yml` lo define.

## Configuración

Los archivos `application.properties` de cada servicio están en `src/main/resources/`.
Modifica las propiedades de conexión a la base de datos y puertos según tu entorno.

## Tests

Para ejecutar pruebas:

```bash
1. Levantar el Docker Engine
2. Compilar y empaqiuetar el proyecto 
   mvn clean install
3. Comprobar los servicios (Verificación de los archivos JAR)
   3.1 Para el servicio de clientes 
       java -jar target/clientes-service-0.0.1-SNAPSHOT.jar
   3.2 Para el servicio de cuentas
       java -jar target/cuentas-service-0.0.1-SNAPSHOT.jar
4. Levantar los contenedores
    docker-compose up --build -d
5. Probando los servicios clientes y cuentas mediante Swagger UI
   5.1 Acceder a Swagger UI del servicio de clientes
       http://localhost:8081/swagger-ui.html
   5.2 Acceder a Swagger UI del servicio de cuentas
       http://localhost:8082/swagger-ui.html

```

## Notas sobre actualización a Java 21

- Actualmente los módulos usan `<java.version>17` en sus `pom.xml`.

## Contribuir

1. Haz fork o crea una rama nueva.
2. Añade cambios y pruebas.
3. Abre un Pull Request describiendo la motivación y los pasos para probar.

## Contacto

Para dudas o ayuda con la migración a Java 21 pide al mantenedor o escribe aquí y te acompaño en el proceso.
