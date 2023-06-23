package uz.pdp.projectmaxway.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.projectmaxway.entity.enums.Status;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@Setter
public class User extends AbsUUIDEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = false)
    private String phoneNumber;

    private String password;

    @ManyToOne(optional = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private int orderCount;


    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = true;
    private String verificationCode;

    public User(String name, String phoneNumber, String password, Role role) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }
}
