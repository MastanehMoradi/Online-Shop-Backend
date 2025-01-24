package com.example.shop_store_back.api;

import com.example.shop_store_back.data.Product;
import com.example.shop_store_back.data.Screenshot;
import com.example.shop_store_back.data.Trailer;
import com.example.shop_store_back.dto.FilterDTO;
import com.example.shop_store_back.dto.ProductsResponseDto;
import com.example.shop_store_back.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


//    @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
    @GetMapping()
    public ResponseEntity<ProductsResponseDto> getProducts(@RequestParam Map<String, String> params) { //, Pageable pageable

        FilterDTO filterDTO = new FilterDTO();
        filterDTO.setName(params.get("search") != null ? params.get("search") : "");
        filterDTO.setCategory(params.get("category")!= null? params.get("category"): "");
        filterDTO.setPage(Integer.parseInt(params.get("page")));
        if (params.get("sort") != null)
            filterDTO.setSort(params.get("sort"));
        return ResponseEntity.ok().body(service.getProductsByFilter(filterDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProduct(@PathVariable Long id){
       return ResponseEntity.ok().body(service.getProduct(id));
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity<Trailer> getTrailer(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getTrailer(id));
    }

    @GetMapping("/{id}/screenshots")
    public ResponseEntity<List<Screenshot>> getScreenshots(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getScreenshot(id));
    }
}
