package uz.pdp.projectmaxway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.projectmaxway.entity.Role;
import uz.pdp.projectmaxway.entity.enums.RoleTypeEnum;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByRoleTypeEnum(RoleTypeEnum user);
}
