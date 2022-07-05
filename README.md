# retokruger
 Reto Kruger
<h1>Reto Kruger By MC</h1>

Este programa API-REST llevar un registro del inventario del estado de vacunación de los empleados:

* Registra, edita, lista y elimina a los empleados.
* Los campos contienen validaciones de acuerdo al tipo de dato.
* Crea un usuario y contraseña una ves registrado el empleado.
* Si el empleado está en estado vacunado, se ingresa información de las vacunas


<h1>Usar el proyecto</h1>

* Para usar el proyecto se lo debe clonar o descargar en .zip luego abrir el proyecto con cualquier IDE de desarrollo compatible con el lenguaje de programacion JAVA. 
* Se debe tener instalada la libreria [Lombok](https://projectlombok.org/), la cual permite optimizar codigo evitando declarar los setters, gettets y constructores de la clase.

* Creamos una base de datos en POSTGRESQL con el nombre retoBD.

* En la carpeta resources del proyecto abrimos el archivo application.properties y procedemos a cambiar las credenciales del usuario y contraseña de acceso a la base de datos

  * spring.jpa.database=POSTGRESQL
  * spring.datasource.platform=postgres
  * spring.datasource.url=jdbc:postgresql://localhost:5432/retoBD
  * spring.datasource.username=usuario
  * spring.datasource.password=contraseña
  * spring.jpa.show-sql=true

* Para crear las tablas quitamos el # la primera ves antes de ejecutar la aplicacion y lo volvemos a colocar una ves que se ejecute

  * #spring.jpa.generate-ddl=true
  * #spring.jpa.hibernate.dll-auto=create-drop
  * #spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

* Una vez instalada las librerias necesaria, procedemos a ejecutar el programa principal con el Plugin de Maven sprin-boot:run.

  * #spring.jpa.generate-ddl=true
  * #spring.jpa.hibernate.dll-auto=create-drop
  * #spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true

* El programa se ejecuta en http://localhost:8080.

<h1>Peticiones</h1>

Para hacer las pruebas de las peticiones se puede utilizar [Postman](https://www.postman.com/) copiamos la direccion http://localhost:8080 
<h3>Peticiones Get</h3>

* http://localhost:8080/api/persons devuelve todas las personas como empleados registrados
* http://localhost:8080/api/person/{id} devuelve a la persona con el id enviado 
* http://localhost:8080/api/employee devuelve todas los detalles del empleado
* http://localhost:8080/api/employee/{id} devuelve al empleado con los el id enviado
* http://localhost:8080/api/filterstatusvaccine/{status} devuelve todos los empleados con el estado de vacunado o no vacunado
* http://localhost:8080/api/filternamevaccine/{name} devuelve todos los empleados con el nombre de la vacuna
* http://localhost:8080/api/filterdatevaccine devuelve todos los empleados con el nombre de la vacuna en un rango de fechas

<h3>Peticiones Post</h3>

* http://localhost:8080/api/person inserta a la persona y lo crea como empleado
* http://localhost:8080/api/employeeupdate/{id} actualiza la informacion del empleado
* http://localhost:8080/api/vaccineEmployee/{id} actualiza la vacuna del empleado si el estado es que esta vacunado
