package uz.pdp.projectmaxway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.projectmaxway.entity.Food;

import java.util.List;
import java.util.UUID;
@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {
    List<Food> findByCategoryId(Integer id);
}
