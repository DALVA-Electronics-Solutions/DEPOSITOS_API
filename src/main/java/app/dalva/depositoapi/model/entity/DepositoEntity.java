package app.dalva.depositoapi.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deposito")
@SQLDelete(sql = "UPDATE deposito SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class DepositoEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String deveui;

    @Column
    private Integer atual = 100;

    @Column
    private double lat;

    @Column
    private double lng;

    @Column
    private String body;

    @Column
    private int comunicacao = 0;

    @Column
    private boolean deleted = Boolean.FALSE;

    @Column
    private Long timestamp;

    @Column
    private Integer maximo;

    @Column
    private Integer minimo;

    @Column
    private String alarms_JSON = "[{envioConfig:0},{nivel:0},{enviou:0},{contentEmail: 'conteudo do email'},{contentSMS:'conteudo do SMS'},]";

    @Column
    private String alarmEmail;

    @Column
    private String alarmSMS;

    @Column
    private Integer volumeM3;

    @Column
    private String grafanaDias;

    @Column
    private Boolean ignorarAlarm;


}
