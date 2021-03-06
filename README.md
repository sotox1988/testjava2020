# Readme
Construcción de API REST para evaluación de un test solicitado.

Para el desarrollo del proyecto se utilizo java 11, Sprinboot 2.3.3, Maven con las dependencias (JPA, Spring Web, H2 Database, Spring security Oauth2),
JPA para la persistencia y consultas de las peticiones en la Base de datos mediante el uso de JPA Named Queries,
Spring Web para la construcción de los servicios REST,
H2 para la persistencia de los datos en RAM (Para motivos de pruebas) y
Spring security para la protección de la API mediante OAUTH2 y JWT.

Para el despliegue se utilizaron los servicios ofrecidos por la plataforma Heroku y Google Cloud Platform con App Engine:

# Descripción de la Api:

La api esta compuesta por 2 endpoints principales:
Uno para COURSES y otro para STUDENTS, cada ruta posee sus metodos GET, POST, PUT y DELETE.
Se desplego la aplicación en los servicios ofrecidos en la nube por Heroku y Google cloud platform mediante App Engine.

**URL GCP:**
```
https://testjava2020.rj.r.appspot.com/ 
```

**URL HEROKU:**
```
https://test-app-java-2020.herokuapp.com/
```

**La ruta para COURSES sería (.../courses/)**
```

GET (Trae todos los cursos):                              https://testjava2020.rj.r.appspot.com/courses/

GET (Trae un curso por su código):                        https://testjava2020.rj.r.appspot.com/courses/{codigo-curso}

POST (Persiste un curso con la estructura JSON dada):     https://testjava2020.rj.r.appspot.com/courses/

PUT (Modifica un curso por su código):                    https://testjava2020.rj.r.appspot.com/courses/{codigo-curso}

DELETE (Borra un curso por su código):                    https://testjava2020.rj.r.appspot.com/courses/{codigo-curso}

La estructura de los JSON de COURSES sería:
{
        "code": "0001",
        "name": "Math"
}
```

**La ruta para STUDENTS sería (/students/)**
```

GET (Trae todos los estudiantes):                                https://testjava2020.rj.r.appspot.com/students/

GET (Trae un estudiante por su rut):                             https://testjava2020.rj.r.appspot.com/students/{rut-sin-digito-verificador-y-sin-puntos}

POST (Persiste un estudiante con la estructura JSON dada):       https://testjava2020.rj.r.appspot.com/students/

PUT (Modifica un estudiante por su rut):                         https://testjava2020.rj.r.appspot.com/students/{rut-sin-digito-verificador-y-sin-puntos}

DELETE (Borra un estudiante por su rut):                         https://testjava2020.rj.r.appspot.com/students/{rut-sin-digito-verificador-y-sin-puntos}

La estructura de los JSON de STUDENTS sería:
{
        "rut": "11.800.819-7",
        "name": "Mario",
        "lastName": "Bros",
        "age": 32,
        "course": {
            "code": "0002",
            "name": "History and geography"
        }
}
```
**NOTA: La rama  MASTER tiene la implementación de Spring security con Oauth2, se logro generar el token en la URL /oauth/token/ , pero no se logro validar la rutas protegidas de los endpoint /courses/ , /students/ ... por motivo de lo anterior se opta subir la rama sin spring security para validar el funcionamiento de la API REST.**

**Ramas:**

```
master: Tiene implementación de spring security Oauth2, pero no se logra hacer que funcione el token para acceder a las rutas protegidas.

api-whitout-security: Tiene el desarrollo de la api sin spring security.
```
