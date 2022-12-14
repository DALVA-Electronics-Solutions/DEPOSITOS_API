package app.dalva.depositoapi.service;

import app.dalva.depositoapi.model.dto.DepositoDto;
import app.dalva.depositoapi.model.request.DepositoRequest;
import app.dalva.depositoapi.model.response.DepositoDeleteResponse;
import app.dalva.depositoapi.model.response.DepositoListResponse;

public interface DepositoService {
    DepositoListResponse getdeposito(Long id);

    DepositoListResponse getAlldepositosFiltroCom(int comunicacao);

    DepositoListResponse getAlldepositosFiltroBody(String body);

    DepositoListResponse getAlldepositos();

    DepositoDto createdeposito(DepositoRequest request);

    DepositoDto updatedeposito(Long id, DepositoRequest request);

    DepositoDeleteResponse deletedeposito(Long id);

    DepositoDeleteResponse deleteAlldepositos();

    DepositoDeleteResponse deleteAlldepositosFiltroBody(String body);


}
