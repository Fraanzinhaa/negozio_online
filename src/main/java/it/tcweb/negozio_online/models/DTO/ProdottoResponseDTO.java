package it.tcweb.negozio_online.models.DTO;

import java.math.BigDecimal;

public class ProdottoResponseDTO {

    private Integer id;
    private String nome;
    private BigDecimal prezzo;

    private Integer categoriaId;
    private String categoriaNome;

    private Integer stock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }
}
