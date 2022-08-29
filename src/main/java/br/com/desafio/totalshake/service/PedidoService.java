package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.dto.PedidoDto;
import br.com.desafio.totalshake.model.EmumStatus;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import br.com.desafio.totalshake.service.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
    @Transactional
    public PedidoDto findById(Long id) {
        Optional<Pedido> object = pedidoRepository.findById(id);
        Pedido entity = object.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new PedidoDto(entity);
    }

    @Transactional
    public Pedido post(PedidoDto pedidoDto) {
        pedidoDto.setData(LocalDate.now());
        pedidoDto.setEmumStatus(EmumStatus.REALIZADO);
        return this.pedidoRepository.save(modelMapper.map(pedidoDto, Pedido.class));
    }

}
