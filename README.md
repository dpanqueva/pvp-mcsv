# PVP-MCSV

Microservicio para la gestión de precios de venta de productos de la marca Inditex.

## Índice

* [Características](#características)
* [Requisitos Previos](#requisitos-previos)
* [Instalación](#instalación)
* [Configuración del Entorno](#configuración-del-entorno)
* [Ejecución](#ejecución)
* [Endpoints Disponibles](#endpoints-disponibles)
* [Documentación de la API](#documentación-de-la-api)
* [Notas de Lanzamiento](#notas-de-lanzamiento)

## Características

* Spring Boot 3.4.3
* Java 21
* Maven como gestor de dependencias


## Requisitos Previos

* Java 21
* Maven 3.9.9 
* H2
* Junit
* Mockito

## Instalación

### Usando Maven

```bash
git clone https://github.com/dpanqueva/pvp-mcsv.git
cd pvp-mcsv
mvn clean package
```


## Configuración del Entorno

Si vas a ejecutarlo a través de un ID, es necesario que crees las variables de entorno:

```plaintext
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

## Ejecución

### Modo Producción

```bash
java -DDB_USERNAME=sa -DDB_PASSWORD=sa -jar target/pvp-mcsv-0.0.1-SNAPSHOT.jar

```

## Endpoints Disponibles

La aplicación expone los siguientes endpoints:
Teniendo en cuenta en que puerto vayas a ejecutar el microservicio

En mi caso: http://localhost:8080

| Endpoint        | Método | Descripción                                                                                                                    |
|-----------------|-------|--------------------------------------------------------------------------------------------------------------------------------|
| `/api-docs`     | GET | Detalle de la configuración del microservicio con swagger                                                                      |
| `/swagger-ui/index.html#/Precios`      | GET | Documento OpenApi 3.1                                                                                                          |
| `api/v1/pvp-prices?applicationDate=2020-06-1421:00:00&productId=35455&brandId=1` | GET | Exposición para dar inicio a la prueba de concepto. Endpoint para obtener pvp de acuerdo a una fecha, un producto y una marca. |

## Documentación de la API

La documentación completa de la API está disponible en:
[enlace-a-documentacion-api]

## Notas de Lanzamiento

### Versión 0.1.0

* Swagger, OpenAPI 3.1, Test Unit >80%
