package br.com.desafio.totalshake.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private LocalDate dataHora;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EnumStatus enumStatus;
    @OneToMany(mappedBy = "pedido")
    @JsonIgnoreProperties("pedido")
    private List<ItemPedido> itensPedidoList = new ArrayList<>();

    @PrePersist
    void prePersist(){
        this.dataHora = LocalDate.now();
    }


    @Deprecated
    public Pedido() {}

    public Pedido(Long id, LocalDate dataHora, EnumStatus enumStatus, List<ItemPedido> itensPedidoList) {
        this.id = id;
        this.dataHora = dataHora;
        this.enumStatus = enumStatus;
        this.itensPedidoList = itensPedidoList;
    }

    public Pedido(Long id, LocalDate data, EnumStatus enumStatus) {
        this.id = id;
        this.dataHora = data;
        this.enumStatus = enumStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public EnumStatus getStatus() {
        return enumStatus;
    }

    public void setStatus(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }

    public List<ItemPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItemPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }


}
