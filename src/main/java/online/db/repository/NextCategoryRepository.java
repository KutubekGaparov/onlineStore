package online.db.repository;

import online.db.model.NextCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NextCategoryRepository extends JpaRepository<NextCategory,Long> {
}
