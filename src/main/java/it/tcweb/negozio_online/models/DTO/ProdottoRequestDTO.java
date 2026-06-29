package it.tcweb.negozio_online.models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdottoRequestDTO {

    @NotBlank(message = "Nome obbligatorio") //Controlla che il valore non sia null, non sia vuoto e non sia fatto di soli spazi.
    @Size(min = 2, max = 100)
    private String nome;

    @NotNull //Controlla che il valore non sia null — ma accetta stringhe vuote.
    @Positive(message = "Prezzo deve essere positivo")
    private BigDecimal prezzo;

    private Integer stock;

    private Integer categoriaId;  // solo l'id, non l'intero oggetto Categoria

}
