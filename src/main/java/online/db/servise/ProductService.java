package online.db.servise;

import lombok.AllArgsConstructor;
import online.db.model.Products;
import online.db.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository repository;

    public Products saveProduct(Products products) {
        return repository.save(products);
    }

    public List<Products> getAllFourCategory(String fourCategory) {
            return null;
    }

    public Products getAllNextCategory(String nextCategory) {

        return repository.getAllByNextCategory(nextCategory);
    }

    public Products getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException(
                            String.format("Product with id %s doesn't exist!", id)
                    );
                });
    }

    public Products updateProduct(Products products, Long id) {
        return null;
    }
}
