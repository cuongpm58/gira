package cybersoft.javabackend.java18.gira.role.model;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RoleEntity {
    @UtilityClass
    public static class Role {
        public static final String TABLE_NAME = "G_ROLE";
        public static final String NAME = "G_NAME";
        public static final String DESCRIPTION = "G_DESCRIPTION";
        public static final String CODE = "G_CODE";
    }

    @UtilityClass
    public static class UserGroup {
        public static final String TABLE_NAME = "G_GROUP";
        public static final String NAME = "G_NAME";
        public static final String DESCRIPTION = "G_DESCRIPTION";
        public static final String CODE = "G_CODE";
    }

    @UtilityClass
    public static class Service {
        public static final String TABLE_NAME = "G_SERVICE";
        public static final String NAME = "G_NAME";
        public static final String DESCRIPTION = "G_DESCRIPTION";
        public static final String CODE = "G_CODE";
        public static final String TYPE = "G_TYPE";
    }

    @UtilityClass
    public static class Module {
        public static final String TABLE_NAME = "G_MODULE";
        public static final String NAME = "G_NAME";
        public static final String DESCRIPTION = "G_DESCRIPTION";
        public static final String CODE = "G_CODE";
    }
}
