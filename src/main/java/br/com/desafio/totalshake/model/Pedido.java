package br.com.desafio.totalshake.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataHora;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedidoList = new ArrayList<>();

    @PrePersist
    void prePersist(){
        this.dataHora = LocalDate.now();
    }


    @Deprecated
    public Pedido() {}

    public Pedido(Long id, LocalDate dataHora, Status status, List<ItemPedido> itensPedidoList) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.itensPedidoList = itensPedidoList;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ItemPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItemPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }
}
