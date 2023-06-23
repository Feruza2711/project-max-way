package uz.pdp.projectmaxway.entity;

import jakarta.persistence.*;
import lombok.Getter;
import uz.pdp.projectmaxway.entity.enums.RolePermission;
import uz.pdp.projectmaxway.entity.enums.RoleTypeEnum;

import java.util.Set;

@Entity
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private RoleTypeEnum roleTypeEnum;

    @ElementCollection
    @CollectionTable(
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"role_id", "permissions"})})
    @Enumerated(EnumType.STRING)
    private Set<RolePermission> permissions;

}
