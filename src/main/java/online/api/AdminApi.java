package online.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import online.db.model.Products;
import online.db.model.dto.ProductsRequest;
import online.db.model.dto.ProductsRespons;
import online.db.model.enums.FourCategory;
import online.db.model.enums.NextCategory;
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

    @Operation(summary = "Save product")
    @PostMapping("/product")
    public Products saveProduct(@RequestBody Products products) {
        return productService.saveProduct(products);
    }

    @Operation(summary = "Update product")
    @PatchMapping("/product/{id}")
    public Products updateProduct(@RequestBody Products products,@PathVariable Long id) {
        return productService.updateProduct(products,id);
    }

}
