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
    private Integer atual;
    private double lat;
    private double lng;
    private String body;
    private int comunicacao;
    private Long timestamp;
    private Integer maximo;
    private Integer minimo;
    private String alarms_JSON;
    private String alarmEmail;
    private String alarmSMS;
    private Integer volumeM3;
    private String grafanaDias;
    private Boolean ignorarAlarm;
}
