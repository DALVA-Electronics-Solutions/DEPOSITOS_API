package app.dalva.depositoapi.model.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class DepositoDeleteResponse implements Serializable {
    private Long deleteddepositoCount;
}
