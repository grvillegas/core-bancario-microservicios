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
mvn test
```

## Notas sobre actualización a Java 21

- Actualmente los módulos usan `<java.version>17` en sus `pom.xml`.
- Para actualizar a Java 21 se recomienda:
  1. Instalar JDK 21 en el equipo.
  2. Ejecutar un plan de actualización (analizar dependencias y cambios de código).
  3. Actualizar las propiedades `java.version` en los `pom.xml` al valor `21`.
  4. Compilar y corregir incompatibilidades (migraciones de APIs, cambios de módulos internos).

Si quieres, puedo generar un plan de actualización automatizado y aplicar los cambios necesarios.

## Contribuir

1. Haz fork o crea una rama nueva.
2. Añade cambios y pruebas.
3. Abre un Pull Request describiendo la motivación y los pasos para probar.

## Contacto

Para dudas o ayuda con la migración a Java 21 pide al mantenedor o escribe aquí y te acompaño en el proceso.
