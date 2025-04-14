package dgtic.core.maquetado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "roles")
public class Rol implements Serializable {

    @Id
    @Column(name = "rol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRol;
    @Column(name = "nombre", unique = true)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    // Relación muchos a muchos con usuarios
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<Usuario> usuarios;
}

