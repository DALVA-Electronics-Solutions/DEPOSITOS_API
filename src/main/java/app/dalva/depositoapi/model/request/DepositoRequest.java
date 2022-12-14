package app.dalva.depositoapi.model.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class DepositoRequest implements Serializable {
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