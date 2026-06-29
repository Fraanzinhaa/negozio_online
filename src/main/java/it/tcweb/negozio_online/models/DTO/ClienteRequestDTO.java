package it.tcweb.negozio_online.models.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteRequestDTO {

    @NotBlank(message = "Nome obbligatorio")
    @Size(min = 2, max = 100)
    public String nome;

    @NotBlank(message = "Il cognome è obbligatorio")
    @Size(min = 2, max = 100)
    public String cognome;

    @NotBlank(message = "Il email è obbligatorio")
    @Email(message = "Email non è in un formato valido")
    public String email;

}
