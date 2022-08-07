package online.db.repository;

import online.db.model.Products;
import online.db.model.enums.FourCategory;
import online.db.model.enums.NextCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {

    @Query("select b from Products b where b.fourCategory = ?1")
    Products getAllByFourCategory(String fourCategory);

    @Query("select b from Products b where b.nextCategory = ?1")
    Products getAllByNextCategory(String nextCategory);

}
