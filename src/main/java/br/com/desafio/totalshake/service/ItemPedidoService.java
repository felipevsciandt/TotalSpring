package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.ItemPedidoDto;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.ItemPedidoRepository;
import br.com.desafio.totalshake.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public List<ItemPedido> findAll() {
        return repository.findAll();
    }

    @Transactional
    public ItemPedidoDto findById(Long id) {
        Optional<ItemPedido> object = repository.findById(id);
        ItemPedido itemPedido = object.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new ItemPedidoDto(itemPedido);
    }

    @Transactional
    public ItemPedido post(ItemPedidoDto itemPedidoDto) {
        ItemPedido object = new ItemPedido();
        object = repository.save(object);
        return this.repository.save(modelMapper.map(object, ItemPedido.class));

    }
}
