package cybersoft.javabackend.java18.gira.role.model;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = RoleEntity.Role.TABLE_NAME)
public class Role extends BaseEntity {
    @Column(name = RoleEntity.Role.NAME, unique = true)
//    @Size(min = 1, max = 100, message = "role name must have length between {min} and {max}")
    @Length(min = 5, max = 100, message = "role name must have length between {min} and {max}")
    private String name;
    @Column(name = RoleEntity.Role.CODE)
    @Length(min = 3, max = 10, message = "role name must have length between {min} and {max}")
    private String code;
    @Column(name = RoleEntity.Role.DESCRIPTION)
    @NotBlank
    private String desciption;
    @ManyToMany
    private Set<Service> services = new LinkedHashSet<>();

    @Override
    public boolean equals(Object obj) {
        Role role = (Role)obj;
        return super.equals(obj)
                && this.name.equals(role)
                && this.code.equals(role);
    }
}
