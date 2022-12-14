package app.dalva.depositoapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositoDto implements Serializable {
    private Long id;
    private String name;
    private String deveui;
    private Integer porcentagem;
    private double lat;
    private double lng;
    private String body;
    private int comunicacao;
    private Long timestamp;
    private Integer maximo;
    private Integer minimo;
    private Integer alarm;
    private String email;
    private String alarmSMS;

}
