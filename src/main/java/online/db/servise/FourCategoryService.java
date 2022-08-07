package online.db.servise;

import lombok.AllArgsConstructor;
import online.db.model.FourCategory;
import online.db.model.Products;
import online.db.repository.FourCategoryRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FourCategoryService {
    private FourCategoryRepository repository;
    public FourCategory save(FourCategory category) {
        return repository.save(category);
    }
}
