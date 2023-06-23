package uz.pdp.projectmaxway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.projectmaxway.entity.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial,Integer> {
}
