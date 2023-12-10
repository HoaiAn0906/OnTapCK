package org.example.ontapck.resource;

import lombok.AllArgsConstructor;
import org.example.ontapck.models.Product;
import org.example.ontapck.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/products")
    public String product(
            @RequestParam(name = "q", defaultValue = "") String q,
            @RequestParam(name = "page", defaultValue = "1") int pageNo,
            @RequestParam(name = "limit", defaultValue = "1") int limit,
            @RequestParam(name = "sort", defaultValue = "name") String sort,
            @RequestParam(value = "sortDirection", defaultValue = "asc") String sortDirection,
            Model model
    ) {
        Page<Product> page = productService.index(q, pageNo, limit, sort, sortDirection);
        List<Product> products = page.getContent();
        for (Product product : products) {
            System.out.println(product);
        }

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("products", products);

        int[] limits = {1, 5, 10, 20, 50, 100};
        model.addAttribute("limits", limits);
        model.addAttribute("limit", limit);

        return "product/index";
    }
}
