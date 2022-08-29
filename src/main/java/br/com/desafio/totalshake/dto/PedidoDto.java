package br.com.desafio.totalshake.dto;


import br.com.desafio.totalshake.model.EmumStatus;
import br.com.desafio.totalshake.model.Pedido;

import java.time.LocalDate;

public class PedidoDto {
    private Long id;
    private LocalDate data;
    private EmumStatus emumStatus;

    public PedidoDto() {}

    public PedidoDto(Long id, EmumStatus emumStatus) {
        this.id = id;
        this.emumStatus = emumStatus;
    }

    public PedidoDto(Pedido entity) {
        this.id = entity.getId();
        this.data = entity.getDataHora();
        this.emumStatus = entity.getStatus();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public EmumStatus getStatus() {
        return emumStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setEmumStatus(EmumStatus emumStatus) {
        this.emumStatus = emumStatus;
    }
}
