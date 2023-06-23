package uz.pdp.projectmaxway.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.projectmaxway.entity.User;
import java.util.Collection;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class UserPrinsipal implements UserDetails {

    private final User user;

    private UUID id;

    private Collection<? extends GrantedAuthority> authorities;

    private String password;

    private String username;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

}
