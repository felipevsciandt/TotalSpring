package br.com.desafio.totalshake.dto;


import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.Status;

import java.time.LocalDate;

public class PedidoDto {
    private Long id;
    private LocalDate data;
    private Status status;

    public PedidoDto() {}

    public PedidoDto(Long id, Status status) {
        this.id = id;
        this.status = status;
    }

    public PedidoDto(Pedido entity) {
        this.id = entity.getId();
        this.data = entity.getDataHora();
        this.status = entity.getStatus();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }
}
