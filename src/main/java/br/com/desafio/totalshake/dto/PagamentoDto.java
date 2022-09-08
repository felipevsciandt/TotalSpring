package br.com.desafio.totalshake.dto;

import br.com.desafio.totalshake.model.EnumStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PagamentoDto {
    private Long id;
    private String status;


}
