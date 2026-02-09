# Crud de Usuarios en java spring 

Este proyecto es para aprender java spring

## Descripción

Este proyecto es para aprender java spring con la ayuda de gemini ia y con algunos libros que dejaré en un carpeta

Estare usando Intellij con la licencia de estudiante de universidad, cabe recalcar que estoy usando Mysql de xampp espero ponerlo 
mas adelante en un docker ya veremos como vamos. 

## 

### Dependencias

* JDA para mysql
```
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>


<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

validaciones 
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```


### Executing program

* 1 hacer la conexion con la base de datos en properties 
* 2 descargar o actualizar maven 

application.properties
```
spring.application.name=users

# Conexión a Base de Datos
spring.datasource.url=jdbc:mysql://localhost:3306/db_users
spring.datasource.username=root
spring.datasource.password=
# (Si en XAMPP tienes clave, ponla arriba. Por defecto es vacío)

# Configuración de JPA (Hibernate)
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Ayuda

Puedes siempre consultar a la Ia según el nivel que este
```
claude 
```

## Autor

Contributors names and contact info

ex. Josuejftz
ex. [@Josuejftz](https://webencusco.com/)

## Version History

* no se usar todavia
    

## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Acknowledgments

Inspiration, code snippets, etc.
* [awesome-readme](https://github.com/matiassingers/awesome-readme)
* [PurpleBooth](https://gist.github.com/PurpleBooth/109311bb0361f32d87a2)
* [dbader](https://github.com/dbader/readme-template)
* [zenorocha](https://gist.github.com/zenorocha/4526327)
* [fvcproductions](https://gist.github.com/fvcproductions/1bfc2d4aecb01a834b46)