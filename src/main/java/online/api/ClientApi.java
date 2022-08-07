package online.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import online.db.model.Products;
import online.db.model.enums.FourCategory;
import online.db.model.enums.NextCategory;
import online.db.servise.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
@Tag(name = "Client", description = "Client accessible apis")
public class ClientApi {

    private ProductService productService;

    @Operation(summary = "get all four category")
    @GetMapping("/four-category/{fourCategory}")
    public Products getAllFourCategory(@PathVariable String fourCategory) {
        return productService.getAllFourCategory(fourCategory);
    }

    @Operation(summary = "get all next category")
    @GetMapping("/next-category/{nextCategory}")
    public Products getAllNextCategory(@PathVariable String nextCategory) {
        return productService.getAllNextCategory(nextCategory);
    }

    @Operation(summary = "get product by id")
    @GetMapping("/product/{id}")
    public Products getAllNextCategory(@PathVariable Long id) {
        return productService.getById(id);
    }

}
