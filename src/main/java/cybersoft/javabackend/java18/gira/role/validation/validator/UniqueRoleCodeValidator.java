package cybersoft.javabackend.java18.gira.role.validation.validator;

import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueRoleCodeValidator implements ConstraintValidator<UniqueRoleCode, String> {
    private String msg;
    private RoleRepository repository;

    public UniqueRoleCodeValidator(RoleRepository repository) {
        this.repository = repository;
    }
    @Override
    public void initialize(UniqueRoleCode constraintAnnotation) {
        msg = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        Role role = repository.findByCode(code);

        if (role == null)
            return true;
        context.buildConstraintViolationWithTemplate(msg)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
