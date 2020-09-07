# Readme
Construcción de API REST para evaluación de un test solicitado.

Para el desarrollo del proyecto se utilizo java 11, Sprinboot 2.3.3, Maven con las dependencias (JPA, Spring Web, H2 Database, Spring security Oauth2). 

JPA para la persistencia y consultas de las peticiones en la Base de datos mediante el uso de JPA Named Queries.
Spring Web para la construcción de los servicios REST.
H2 para la persistencia de los datos, aunque con esta Base de datos solo se persisten en RAM (Para motivos de pruebas).
Spring security para la protección de la API mediante OAUTH2 y JWT.

Para el despliegue se utilizaron los servicios ofrecidos por la plataforma Heroku:

# Descripción de la Api:

La api esta compuesta por 2 endpoints principales:
Uno para COURSES y otro para STUDENTS, cada ruta posee sus metodos GET, POST, PUT y DELETE.
Se desplego la aplicación en los servicios ofrecidos en la nube por Heroku y Google cloud platform mediante App Engine.

URL GCP: https://testjava2020.rj.r.appspot.com/
URL HEROKU: https://test-app-java-2020.herokuapp.com/

La ruta para COURSES sería (**/courses/)

GET:      https://test-app-java-2020.herokuapp.com/courses/

POST:     https://test-app-java-2020.herokuapp.com/courses/

PUT:      https://test-app-java-2020.herokuapp.com/courses/{codigo-curso}

DELETE:   https://test-app-java-2020.herokuapp.com/courses/{codigo-curso}

La estructura de los JSON de COURSES sería:
{
        "code": "0001",
        "name": "Math"
}




La ruta para STUDENTS sería (**/students/)

GET:      https://test-app-java-2020.herokuapp.com/students/

POST:     https://test-app-java-2020.herokuapp.com/students/

PUT:      https://test-app-java-2020.herokuapp.com/students/{rut-sin-digito-verificador-y-sin-puntos}

DELETE:   https://test-app-java-2020.herokuapp.com/students/{rut-sin-digito-verificador-y-sin-puntos}

La estructura de los JSON de COURSES sería:
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
