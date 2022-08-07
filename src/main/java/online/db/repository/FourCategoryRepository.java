package online.db.repository;

import online.db.model.FourCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FourCategoryRepository extends JpaRepository<FourCategory,Long> {
}
