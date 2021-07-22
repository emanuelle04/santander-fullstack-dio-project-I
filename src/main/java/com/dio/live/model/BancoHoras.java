package com.dio.live.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class BancoHoras {

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class BncoHorasId implements Serializable {
        private Long idBancoHoras;
        private long idMovimentacao;
        private Long idUsuario;
    }
    @Id
    @EmbeddedId
    private BncoHorasId id;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadesHoras;
    private BigDecimal saldoHoras;
}
