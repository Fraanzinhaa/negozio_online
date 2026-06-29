package it.tcweb.negozio_online.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clienti")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;

    @NotBlank(message = "Il nome è obbligatorio")

    @Size(min = 2, max = 100)
    public String nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    @Size(min = 2, max = 100)
    public String cognome;

    @NotBlank(message = "Il email è obbligatorio")
    @Email(message = "Email non è in un formato valido")
    public String email;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Recensione> recensioni;

}
