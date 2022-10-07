package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = RoleEntity.UserGroup.TABLE_NAME)
public class UserGroup extends BaseEntity {
    @Column(name = RoleEntity.UserGroup.NAME, unique = true)
//    @Size(min = 1, max = 100, message = "role name must have length between {min} and {max}")
    @Length(min = 5, max = 100, message = "role name must have length between {min} and {max}")
    private String name;
    @Column(name = RoleEntity.UserGroup.CODE)
    @Length(min = 3, max = 10, message = "role name must have length between {min} and {max}")
    private String code;
    @Column(name = RoleEntity.UserGroup.DESCRIPTION)
    @NotBlank
    private String desciption;
}
