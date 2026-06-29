package it.tcweb.negozio_online.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "recensioni")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recensione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il voto è obbligatorio")
    @Min(value= 1, message ="Il voto minimo È 1")
    @Max(value= 5, message ="Il voto massimo È 5")
    private Byte voto;

    @NotBlank(message = "Il commento è obbligatorio")
    @Size(max = 300, message = "Il commento non può superari 300")
    private String commento;

    @ManyToOne
    @JoinColumn(name = "prodotto_id")
    private Prodotto prodotto;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private LocalDate data;
}

