package online.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import online.db.model.FourCategory;
import online.db.model.NextCategory;
import online.db.model.Products;
import online.db.servise.FourCategoryService;
import online.db.servise.NextCategoryService;
import online.db.servise.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
@AllArgsConstructor
@Tag(name = "Admin", description = "Admin accessible apis")
public class AdminApi {

    private ProductService productService;
    private FourCategoryService fourCategoryService;
    private NextCategoryService nextCategoryService;

    @Operation(summary = "Save Category")
    @PostMapping("/first-category")
    public FourCategory saveCategory(@RequestBody FourCategory category) {
        return fourCategoryService.save(category);
    }

    @Operation(summary = "Save Next Category")
    @PostMapping("/second-category/{firstCategoryId}")
    public NextCategory saveNextCategory(@RequestBody NextCategory category,@PathVariable Long firstCategoryId) {
        return nextCategoryService.save(category,firstCategoryId);
    }

    @Operation(summary = "Save product")
    @PostMapping("/product}")
    public Products saveProduct(@RequestBody Products products) {
        return productService.saveProduct(products);
    }

    @Operation(summary = "Update product")
    @PatchMapping("/product/{id}")
    public Products updateProduct(@RequestBody Products products,@PathVariable Long id) {
        return productService.updateProduct(products,id);
    }

}
