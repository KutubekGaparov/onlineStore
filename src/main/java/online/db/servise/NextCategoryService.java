package online.db.servise;

import lombok.AllArgsConstructor;
import online.db.model.FourCategory;
import online.db.model.NextCategory;
import online.db.repository.FourCategoryRepository;
import online.db.repository.NextCategoryRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@AllArgsConstructor
public class NextCategoryService {

    private final NextCategoryRepository nextCategoryRepository;
    private final FourCategoryRepository fourCategoryRepository;

    public NextCategory save(NextCategory category,Long id) {
        FourCategory fourCategory = fourCategoryRepository.findById(id).get();

        category.setFourCategory(fourCategory);

        return nextCategoryRepository.save(category);
    }
}
