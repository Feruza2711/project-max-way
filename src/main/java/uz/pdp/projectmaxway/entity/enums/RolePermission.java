package uz.pdp.projectmaxway.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum RolePermission implements GrantedAuthority {
    CATEGORY_ADD,
    CATEGORY_EDIT,
    CATEGORY_DELETE,
    CATEGORY_GET,

    ;

    @Override
    public String getAuthority() {
        return name();
    }
}
