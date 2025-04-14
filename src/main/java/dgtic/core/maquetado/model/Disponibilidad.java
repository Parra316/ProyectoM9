package dgtic.core.maquetado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="disponibilidad")
public class Disponibilidad implements Serializable {
    @Id
    @Column(name = "disponibilidad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDisponibilidad;
    @JoinColumn(name = "consultorio_id")
    @ManyToOne
    @JsonIgnore
    private Consultorio dispoConsultorio;
    @JoinColumn(name = "servicio_id")
    @ManyToOne
    @JsonIgnore
    private Servicio dispoServicio;
    @JoinColumn(name = "horario_id")
    @ManyToOne
    @JsonIgnore
    private Horario dispoHorario;
    @JoinColumn(name = "masajista_id")
    @ManyToOne
    @JsonIgnore
    private Usuario dispoUsuario;
}
