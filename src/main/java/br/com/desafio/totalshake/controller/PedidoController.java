package br.com.desafio.totalshake.controller;
import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidosList = service.findAll();
        return ResponseEntity.ok().body(pedidosList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id) {
        PedidoDto pedidoDto = service.findById(id);
        return ResponseEntity.ok().body(pedidoDto);
    }

    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody PedidoDto pedidoDto) {
        Pedido pedido = service.cadastrarPedido(pedidoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pedidoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

    @PutMapping(value = "/cancelar/{id}")
    public ResponseEntity<Pedido> cancelarPedido(@PathVariable Long id) {
        return ResponseEntity.ok(service.cancelarPedido(id));
    }

    @PutMapping
    public ResponseEntity<Pedido> atualizarPedido(@RequestBody PedidoDto pedidoDto) {
        return ResponseEntity.ok(service.atualizarPedido(pedidoDto));
    }

    @DeleteMapping(value = "/{id}")
    public void deletarPedido(@PathVariable Long id) {
        service.deletarPedido(id);
    }

}
