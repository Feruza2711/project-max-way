package uz.pdp.projectmaxway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.projectmaxway.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
