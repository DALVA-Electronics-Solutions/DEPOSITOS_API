package app.dalva.depositoapi.model.converter;

import org.springframework.stereotype.Component;

import app.dalva.depositoapi.model.dto.DepositoDto;
import app.dalva.depositoapi.model.entity.DepositoEntity;
import app.dalva.depositoapi.model.request.DepositoRequest;

@Component
public class DepositoConverter {
    public DepositoDto toDto(DepositoEntity entity) {
        if (entity == null) {
            return null;
        } else {
            return DepositoDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .deveui(entity.getDeveui())
            .atual(entity.getAtual())
            .lat(entity.getLat())
            .lng(entity.getLng())
            .body(entity.getBody())
            .comunicacao(entity.getComunicacao())
            .timestamp(entity.getTimestamp())
            .maximo(entity.getMaximo())
            .minimo(entity.getMinimo())
            .alarms_JSON(entity.getAlarms_JSON())
            .alarmEmail(entity.getAlarmEmail())
            .alarmSMS(entity.getAlarmSMS())
            .volumeM3(entity.getVolumeM3())
            .grafanaDias(entity.getGrafanaDias())
            .ignorarAlarm(entity.getIgnorarAlarm())
            .build();
        }
    }

    public DepositoEntity toEntity(DepositoRequest request) {
        if (request == null) {
            return null;
        } else {
            return DepositoEntity.builder()
            .name(request.getName())
            .deveui(request.getDeveui())
            .atual(request.getAtual())
            .lat(request.getLat())
            .lng(request.getLng())
            .body(request.getBody())
            .comunicacao(request.getComunicacao())
            .timestamp(request.getTimestamp())
            .maximo(request.getMaximo())
            .minimo(request.getMinimo())
            .alarmEmail(request.getAlarmEmail())
            .alarms_JSON(request.getAlarmJSON())
            .alarmSMS(request.getAlarmSMS())
            .volumeM3(request.getVolumeM3())
            .grafanaDias(request.getGrafanaDias())
            .ignorarAlarm(request.getIgnorarAlarm())
            .build();
        }
    }

}
