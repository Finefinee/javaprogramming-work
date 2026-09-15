package hello.ex04.controller;

import hello.ex04.entity.Product;
import hello.ex04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

        /*
    ProductController - ProductService - ProductRepository - Product(Entity)

    GetMapping(products) - Product 테이블 전체
    GetMapping({id}) - Product id로 조회
     */


    private final ProductService productService;

    @GetMapping
    public List<Product> allProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return product;
    }


}
