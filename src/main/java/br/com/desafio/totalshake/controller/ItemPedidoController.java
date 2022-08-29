package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/itens")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService service;

    @GetMapping
    public ResponseEntity<List<ItemPedido>> findAll() {
        List<ItemPedido> itensPedidoList = service.findAll();
        return ResponseEntity.ok().body(itensPedidoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemPedido> findById(@PathVariable Long id) {
        ItemPedido itemPedido = service.findById(id);
        return ResponseEntity.ok().body(itemPedido);
    }
}
