package br.com.desafio.totalshake.model;

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
    private EmumStatus emumStatus;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedidoList = new ArrayList<>();

    @PrePersist
    void prePersist(){
        this.dataHora = LocalDate.now();
    }


    @Deprecated
    public Pedido() {}

    public Pedido(Long id, LocalDate dataHora, EmumStatus emumStatus, List<ItemPedido> itensPedidoList) {
        this.id = id;
        this.dataHora = dataHora;
        this.emumStatus = emumStatus;
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

    public EmumStatus getStatus() {
        return emumStatus;
    }

    public void setStatus(EmumStatus emumStatus) {
        this.emumStatus = emumStatus;
    }

    public List<ItemPedido> getItensPedidoList() {
        return itensPedidoList;
    }

    public void setItensPedidoList(List<ItemPedido> itensPedidoList) {
        this.itensPedidoList = itensPedidoList;
    }

}
