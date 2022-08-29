package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.ItemPedidoDto;
import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<ItemPedidoDto> findById(@PathVariable Long id) {
        ItemPedidoDto itemPedidoDto = service.findById(id);
        return ResponseEntity.ok().body(itemPedidoDto);
    }

    @PostMapping
    public ResponseEntity<ItemPedido> insert(@RequestBody ItemPedidoDto itemPedidoDto) {
        ItemPedido itemPedido = service.post(itemPedidoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(itemPedidoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(itemPedido);
    }

}
