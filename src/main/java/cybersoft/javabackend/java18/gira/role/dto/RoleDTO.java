package cybersoft.javabackend.java18.gira.role.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    // Data transfer Object
    private UUID id;
    @Size(min = 5, max = 100, message = "Role name must have length between {min} and {max}")
    @NotBlank
    private String name;
    @Size(min = 5, max = 10, message = "Role name must have length between {min} and {max}")
    @NotBlank
    private String code;
    @NotBlank(message = "Role description can not be blank")
    private String description;
}
