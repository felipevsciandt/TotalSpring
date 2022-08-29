package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import br.com.desafio.totalshake.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public PedidoDto findById(Long id) {
        Optional<Pedido> object = pedidoRepository.findById(id);
        Pedido entity = object.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PedidoDto(entity);
    }

    @Transactional
    public PedidoDto post(PedidoDto pedidoDto) {
        Pedido pedido = new Pedido();
        pedido = pedidoRepository.save(Pedido.converterParaClasse(pedidoDto));
        return new PedidoDto(pedido);
    }
}
