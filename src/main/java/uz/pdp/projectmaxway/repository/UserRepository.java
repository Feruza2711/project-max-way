package uz.pdp.projectmaxway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.projectmaxway.entity.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByPhoneNumber(String s);

    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByVerificationCode(String code);
}
