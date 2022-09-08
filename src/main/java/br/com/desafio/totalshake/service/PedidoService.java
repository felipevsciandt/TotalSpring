package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.PagamentoDto;
import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.model.EnumStatus;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import br.com.desafio.totalshake.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Pedido> findAll() {
        return repository.findAll();
    }
    @Transactional
    public PedidoDto findById(Long id) {
        Optional<Pedido> object = repository.findById(id);
        Pedido entity = object.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PedidoDto(entity);
    }


    @Transactional
    public Pedido cancelarPedido(Long id) {
        PedidoDto pedidoASerCancelado = findById(id);
        pedidoASerCancelado.setEmumStatus(EnumStatus.CANCELADO);
        return this.repository.save(modelMapper.map(pedidoASerCancelado, Pedido.class));

    }

    @Transactional
    public void deletarPedido(Long id) {
        Pedido pedido = modelMapper.map(findById(id), Pedido.class);
        repository.delete(pedido);
    }

    @Transactional
    public Pedido cadastrarPedido(PedidoDto pedidoDto) {
        Pedido pedido = modelMapper.map(pedidoDto, Pedido.class);
        return repository.save(pedido);

    }

    public Pedido atualizarPedido(PedidoDto pedidoDto) {
        Pedido pedidoASerAtualizado = pedidoDto.converterDtoParaPedido();
        return repository.save(pedidoASerAtualizado);
    }

    public Pedido atualizaPagamentoPedido(PagamentoDto pagamentoDto) {
        var pedido = repository.findById(pagamentoDto.getId());
        if (pedido.isPresent()) {
            pedido.get().setStatus(EnumStatus.PAGO);
            return repository.save(pedido.get());
        }
        else throw new RuntimeException("Pedido não encontrado");
    }
}
