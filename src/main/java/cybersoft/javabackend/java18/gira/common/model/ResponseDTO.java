package cybersoft.javabackend.java18.gira.common.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ResponseDTO {
    private Object content;
    private boolean hasErrors;
    private List<String> erros;
    private String timeStamp;
    private int status;
}
