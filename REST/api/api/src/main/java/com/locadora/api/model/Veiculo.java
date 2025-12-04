package com.locadora.api.model;
/*
Onde defini minhas Entidades (Veiculo, Locadora,
Usuario) mapeadas diretamente para o banco de dados
usando anotações como @Entity e @OneToMany.
 */
import jakarta.persistence.*;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String placa;
    private Double valorDiaria;

    //Relacionamento N-1 (Muitos veículos pertencem a uma Locadora)
    @ManyToOne
    @JoinColumn(name = "locadora_id")
    private Locadora locadora;

    public Veiculo() {
    }

    public Veiculo(Long id, String modelo, String placa, Double valorDiaria, Locadora locadora) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.locadora = locadora;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Locadora getLocadora() {
        return locadora;
    }

    public void setLocadora(Locadora locadora) {
        this.locadora = locadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
