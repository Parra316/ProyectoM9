package dgtic.core.maquetado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(name = "nombre")
    @NotNull
    @NotBlank(message = "El nombre no puede ser vacia")
    private String nombre;
    @Column(name = "apellido")
    @NotNull
    @NotBlank(message = "El apellido no puede ser vacia")
    private String apellido;
    @Column(name = "correo")
    @Email
    @NotNull
    @NotBlank(message = "El correo no puede ser vacia")
    private String correo;
    @Column(name = "contrasena")
    @NotNull
    @NotBlank(message = "La contrasena no puede ser vacia")
    private String contrasena;
    @Column(name = "telefono")
    @Size(min = 10, max = 10)
    @NotNull
    @NotBlank(message = "El telefono no puede ser vacia")
    private String telefono;
    @Column(name = "registro")
    private LocalDateTime registro;
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "usuarioroles",  // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "usuario_id"),  // FK hacia Usuario
            inverseJoinColumns = @JoinColumn(name = "rol_id")  // FK hacia Rol
    )
    private Set<Rol> roles;
    @OneToMany(mappedBy = "dispoUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Disponibilidad> disponibles;
    @OneToMany(mappedBy = "citaUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Cita> citaUser;
    @OneToMany(mappedBy = "citaMasajista", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Cita> citaAdmin;
}

