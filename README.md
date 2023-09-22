<a name="readme-top"></a>

# Proyecto My Spotify

## Objetivo
Lo invito a forkear este repositorio si quiere construir una aplicación de **MICROSERVICIOS** usando el **FRAMEWORK** de **SPRING CLOUD**. 

<br />

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Tabla de Contenidos</summary>
  <ol>
    <li>
      <a href="#acerca-del-proyecto">Acerca del Proyecto</a>
      <ul>
        <li><a href="#construido-con">Construido con</a></li>
      </ul>
    </li>
    <li>
      <a href="#Comencemos">Comencemos</a>
      <ul>
        <li><a href="#pre-requisitos">Pre-requisitos</a></li>
        <li><a href="#instalacion">Instalación</a></li>
      </ul>
    </li>
    <li><a href="#contacto">Contacto</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## Acerca del Proyecto

Se trata de un aplicación de microservicios por medio de la cual se puede guardar artistas y canciones y luego hacer consultas rápidas. En el siguiente esquema se puede observar su funcionamiento: 
![image](https://github.com/vlambo3/my-spotify/assets/86501009/e9d46399-7e03-4129-b849-9d282b5fb556)

Se trata de tres microservicios: *API PLAYLIST*, *API SONG* y *API ARTIST*, que se encuentran registrados como clientes de Eureka y registrados en el *EUREKA SERVER*. Utilizan **Open Feign** para la comunicación sincrónica y **RabbitMQ** para la comunicación asincrónica.
Para el desarrollo del proyecto se usaron bases de datos relacionales y no relacionales (**MySQL** y **MongoDB**). 

A traves de *API GATEWAY* se puede acceder a *API PLAYLIST*, desde donde se pueden crear canciones y artistas con su respectivo género musical.
Cuando se crean canciones desde *API PLAYLIST* se persisten esas canciones en la base de datos relacional **MySQL** de *API SONG*, y en ese momennto se envía un mensaje a través de una cola de **RabbitMQ** a *API PLAYLIST* para que también lo persista en su base de datos no relacional **MongoDB**. 
Lo mismo ocurre con artistas, cuando se crean artistas desde *API PLAYLIST* se persisten esos artistas es la base de datos no relacional **MongoDB** de *API ARTIST*, y en ese momento se envía un mensaje a través de una cola de **RabbitMQ** a *API PLAYLIST* para que también lo persista en su base de datos no relacional **MongoDB**.
Luego desde *API PLAYLIST* se pueden consultar tanto los artitas como las canciones filtradas por género musical a su base de datos no relacional **MongoDB**, de manera conjunta y de manera individual.

Para la comunicación entre microservicios se utilizó **Open Feign**. Además está previsto un **Circuit Breaker** y **Retry**, ambos módulos de **Resilience4j**, en caso de que falle la comunicación entre microservicios al consultar por género a canciones. 
Y se creo un método alternativo en caso de falla por medio del cual se consulta directamente a la base de datos no relacional de *API PLAYLIST*, en caso de no poder consultar a *API SONG*.

Adicionalmente se puede observar la **traza distribuida** desde el dashboard de **Zipkin**.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Construido con

El proyecto está construído con jdk 17, usando Spring Boot, Spring JPA, Spring MVC, Spring Cloud, Resilience4j, RabbitMQ, Zipkin, Docker-compose, MySQL, MongoDB, y Maven.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Comencemos

Puede clonar este repositorio ejecutando el comando git clone junto con la url : https://github.com/vlambo3/my-spotify desde su consola de Git Bash
  ```
  git clone https://github.com/vlambo3/my-spotify
  ```


### Pre-requisitos

Una vez que clonó el proyecto puede correr el docker-compose y levantar los servidores de RabbitMQ, Zipkin y una imagen de la base de datos de MySQL. Para ello deberá ejecutar desde la terminal el comando:

  ```
  docker compose up
  ```

### Instalacion

Antes de correr este proyecto lea las siguientes recomendaciones:

 - Previo a correr alguno de los servicios, cree manualmente dos colas en su dashboard de RabbitMQ: ArtistQueue y SongQueue.
   
 - Levante primero el servicio de Eureka Server y luego el resto de los servicios (gateway, ms-playlist, ms-song, ms-artist).

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contacto

Project Link: [https://github.com/vlambo3/my-spotify](https://github.com/vlambo3/my-spotify)

LinkedIn Profile: [https://www.linkedin.com/in/vanina-a-godoy/](https://www.linkedin.com/in/vanina-a-godoy/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
