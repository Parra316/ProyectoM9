package dgtic.core.maquetado.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="horario")
public class Horario implements Serializable {
    @Id
    @Column(name = "horario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "consultorio_id")
    private Consultorio horarioConsultorio;
    @Column(name = "fecha")
    @NotNull
    private LocalDate fecha;
    @Column(name = "hora_inicio")
    @NotNull
    private LocalTime horaInicio;
    @Column(name = "hora_fin")
    @NotNull
    private LocalTime horaFin;
    @JsonIgnore
    @OneToMany(mappedBy = "dispoHorario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Disponibilidad> disponibles;
    @JsonIgnore
    @OneToMany(mappedBy = "citaHorario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cita> citas;

}
