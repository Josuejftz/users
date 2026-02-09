package org.example.users.entity;
import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity //Le dice a spring que esto es una tabla
@Table(name = "users")  // identico ala base de datos
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incrementable
    private Long id;

    // @NotBlank: valida que no sea null si esta vacio ("") ni sea solo espacios
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    //@Email: Valida que tenga el formato correcto (example@example.com)
    @NotBlank(message =  "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    @Column(unique = true)// Esto es para la BD (mysql) no es validacion de JAVA
    private String email;

    //@Size: Valida longitud minima o maxima
    @NotBlank(message = "La contraseña es obligatorio")
    @Size(min = 6,message = "La contraseña debe tener al menos 6 caracteres")
    private String password;


    //Constructores, getters y setters (Obligatorios)
    public User(){}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

}
