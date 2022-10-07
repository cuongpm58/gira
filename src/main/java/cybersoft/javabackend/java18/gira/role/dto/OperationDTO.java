package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleCode;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleName;
import lombok.*;

import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationDTO {
    private UUID id;
    private String name;
    private String code;
    private String description;

    private Operation.Type type;
}
