package app.dalva.depositoapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import app.dalva.depositoapi.model.dto.DepositoDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepositoListResponse implements Serializable {
    private List<DepositoDto> depositos;
}
