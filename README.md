
# mutant-detection-service
## Sistema de detección de mutantes basados en cadena de ADN

El sistema de detección de mutantes es un proyecto multi-modulo maven.
Los módulos son:

- mutant-detection-parent

- mutant-detection-api

- mutant-detection-rest

## Instalación y Primeros Pasos

Primero navegar hasta la carpeta mutant-detection-parent y hacer un build del proyecto como:
```
mutant-detection-parent$ mvn clean install
```
```
[INFO] Reactor Summary:
[INFO]
[INFO] mutant-detection-api ............................... SUCCESS [ 11.563 s]
[INFO] mutant-detection-rest .............................. SUCCESS [ 16.931 s]
[INFO] mutant-detection-parent ............................ SUCCESS [  0.256 s]
[INFO] ------------------------------------------------------------------------

```

Si todo esta ok, navegar hasta la carpeta mutant-detection-api y ejecutar:
```
mutant-detection-api$ mvn java -jar target/mutant-detection-api-1.0-FINAL-exec.jar "ATGCGA" "CAGTGC" "TTATGT" "AGAAGG" "CCCCTA" "TCACTG"
```
El proyecto mutant-detection-api expone los métodos para detectar si es o no mutante mediante una aplicación spring-boot de consola no web.

El resultado de la validación del ejemplo es:

```
2018-04-22 23:16:15.223  INFO 9476 --- [           main] c.e.api.MutantDetectionApplication       : Started MutantDetectionApplication in 2.892 seconds (JVM running for 3.47)
Starting Mutant Detection API ......starting to process DNA 
DNA Sequence provided result = IS MUTANT!! 

```

## Ejecutar servicios REST

Navegar hasta la carpeta mutant-detection-rest y ejecutar :

```
mutant-detection-rest$  mvn clean spring-boot:run
```

El proyecto corre en una instancia de Tomact server.
Entonces ejecutar los siguientes servicios :

###### POST /mutant

```
curl -H "Content-Type: application/json" -X POST -d '{"dna":["AGAGCA","CAGTGC","TACGTA","AAAACG","CGCACT","TCACTG"]} ' http://localhost:8080/mutant
```

###### GET /stats

```
curl -H "Content-Type: application/json" -X GET http://localhost:8080/stats
```


