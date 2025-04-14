package dgtic.core.maquetado.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="cita")
public class Cita {
    @Id
    @Column(name = "cita_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCita;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "usuario_id")
    private Usuario citaUsuario;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "masajista_id")
    private Usuario citaMasajista;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "servicio_id")
    private Servicio citaServicio;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "horario_id")
    private Horario citaHorario;
    @Column(name = "fecha_cita")
    private LocalDateTime fechaCita;
    @Column(name = "estatus")
    private String estatus;
    @Column(name = "precio")
    private float precio;
    @JsonIgnore
    @OneToMany(mappedBy = "pagoCita", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pago> pagos;
}

