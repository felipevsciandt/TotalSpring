package br.com.desafio.totalshake.dto;


import br.com.desafio.totalshake.model.EnumStatus;
import br.com.desafio.totalshake.model.Pedido;

import java.time.LocalDate;

public class PedidoDto {
    private Long id;
    private LocalDate data;
    private EnumStatus enumStatus;

    public PedidoDto() {}

    public PedidoDto(Long id, EnumStatus enumStatus) {
        this.id = id;
        this.enumStatus = enumStatus;
    }

    public PedidoDto(Pedido entity) {
        this.id = entity.getId();
        this.data = entity.getDataHora();
        this.enumStatus = entity.getEnumStatus();
    }



    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public EnumStatus getEnumStatus() {
        return enumStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setEmumStatus(EnumStatus enumStatus) {
        this.enumStatus = enumStatus;
    }

    public Pedido converterDtoParaPedido() {
        return new Pedido(this.getId(), this.getData(), this.getEnumStatus());
    }
}
