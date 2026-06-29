package it.tcweb.negozio_online.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.tcweb.negozio_online.models.DTO.ProdottoRequestDTO;
import it.tcweb.negozio_online.models.DTO.ProdottoResponseDTO;
import it.tcweb.negozio_online.models.Prodotto;
import it.tcweb.negozio_online.service.ProdottoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Il controller è la classe che riceve le richieste HTTP dall'esterno. E' la porta di ingresso, non fa altro
@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/prodotti")        // prefisso comune per tutti gli endpoint
@Tag(name = "Prodotti", description = "Gestione dei prodotti di negozio online")
public class ProdottoController {

    @Autowired
    private ProdottoService service; // Autowired è un decoratore che serve a Spring per iniettare il service nel controller

    @GetMapping
    @Operation(summary = "Recupera tutti i prodotti",
            description = "Restituisce tutti i prodotti presenti nel database db_negozio_online")
    public ResponseEntity<List<Prodotto>> trovaTutti(){
        return ResponseEntity.ok(service.trovaTutti());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recupera un prodotto tramite l'ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Prodotto trovato"),
            @ApiResponse(responseCode = "404", description = "Prodotto non trovato"),
            @ApiResponse(responseCode = "500", description = "Errore interno del server")
    })
    public ResponseEntity<ProdottoResponseDTO> trovaPerId(@PathVariable Integer id){

        return ResponseEntity.ok(service.trovaPerId(id));
    }

    @PostMapping
    @Operation(summary = "Crea un prodotto")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Prodotto creato"),
            @ApiResponse(responseCode = "400", description = "La tua richiesta è fatta male, mancano dati o sono sbagliati"),
            @ApiResponse(responseCode = "500", description = "Errore interno del server")
    })
    public ResponseEntity<ProdottoResponseDTO> crea(@Valid @RequestBody ProdottoRequestDTO dto){
        return ResponseEntity.status(201).body(service.salva(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Aggiorna un prodotto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Prodotto aggiornato"),
            @ApiResponse(responseCode = "400", description = "La tua richiesta è fatta male, mancano dati o sono sbagliati"),
            @ApiResponse(responseCode = "404", description = "Prodotto non esistente"),
            @ApiResponse(responseCode = "500", description = "Errore interno del server")
    })
    public ResponseEntity<Prodotto> aggiorna( @PathVariable Integer id,
                                              @RequestBody Prodotto prodotto){
        if (service.trovaPerId(id) == null){
            return ResponseEntity.notFound().build();
        }
        prodotto.setId(id);                   // ci serve per assicurarci che l'id del prodotto da modificare sia quello giusto
        return ResponseEntity.ok((service.salva(prodotto)));
    }

    @DeleteMapping("/{id}") //204 404 500
    @Operation(summary = "Elimina un prodotto")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Prodotto cancellato con sucesso"),
            @ApiResponse(responseCode = "404", description = "Prodotto non esistente"),
            @ApiResponse(responseCode = "500", description = "Errore interno del server")
    })
    public ResponseEntity<Void> elimina(@PathVariable Integer id){
        if (service.trovaPerId(id) == null){
            return ResponseEntity.notFound().build();
        }
        service.elimina(id);
        return ResponseEntity.noContent().build();
    }

}
