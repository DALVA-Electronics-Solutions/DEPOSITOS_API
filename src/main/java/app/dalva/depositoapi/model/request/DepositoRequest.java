package app.dalva.depositoapi.model.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;



@Data
@Builder
public class DepositoRequest implements Serializable {
    private String name;
    private String deveui;
    private Integer atual;
    private double lat;
    private double lng;
    private String body;
    private int comunicacao;
    private Long timestamp;
    private Integer maximo;
    private Integer minimo;
    private String alarmJSON;
    private String alarmEmail;
    private String alarmSMS;
    private Integer volumeM3;
    private String grafanaDias;
    private Boolean ignorarAlarm;
}