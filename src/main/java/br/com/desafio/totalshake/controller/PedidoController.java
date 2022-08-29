package br.com.desafio.totalshake.controller;
import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<String> findAll() {
        return ResponseEntity.ok().body("Find All funcionou");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id) {
        PedidoDto pedidoDto = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedidoDto);
    }

    @PostMapping
    public ResponseEntity<PedidoDto> post(@RequestBody PedidoDto pedidoDto) {
        pedidoDto = pedidoService.post(pedidoDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pedidoDto.getId()).toUri();
        return ResponseEntity.created(uri).body(pedidoDto);
    }


}
