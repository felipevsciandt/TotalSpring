package br.com.desafio.totalshake.controller;
import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll() {
        List<Pedido> pedidosList = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidosList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id) {
        PedidoDto pedidoDto = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedidoDto);
    }

    @PostMapping
    public ResponseEntity<Pedido> post(@RequestBody PedidoDto pedidoDto) {
        Pedido pedido = pedidoService.post(pedidoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pedidoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }


}
