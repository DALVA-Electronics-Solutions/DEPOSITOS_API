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
            .porcentagem(entity.getPorcentagem())
            .lat(entity.getLat())
            .lng(entity.getLng())
            .body(entity.getBody())
            .comunicacao(entity.getComunicacao())
            .timestamp(entity.getTimestamp())
            .maximo(entity.getMaximo())
            .minimo(entity.getMinimo())
            .alarm(entity.getAlarm())
            .email(entity.getEmail())
            .alarmSMS(entity.getAlarmSMS())
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
            .porcentagem(request.getPorcentagem())
            .lat(request.getLat())
            .lng(request.getLng())
            .body(request.getBody())
            .comunicacao(request.getComunicacao())
            .timestamp(request.getTimestamp())
            .maximo(request.getMaximo())
            .minimo(request.getMinimo())
            .alarm(request.getAlarm())
            .email(request.getEmail())
            .alarmSMS(request.getAlarmSMS())
            .build();
        }
    }

}
