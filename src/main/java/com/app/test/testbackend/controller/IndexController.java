package com.app.test.testbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.app.test.testbackend.dto.CategoryDTO;
import com.app.test.testbackend.dto.ProductDTO;
import com.app.test.testbackend.persistence.entity.Product;
import com.app.test.testbackend.persistence.entity.Category;
import com.app.test.testbackend.service.ICategoryService;
import com.app.test.testbackend.service.IProductService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class IndexController {
    
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public String index(Model model) {
       List<Product> products = productService.findAll();

       //pasar los productos a un DTO
       List<ProductDTO> dto = products.stream().map(product -> ProductDTO.builder()
       .id(product.getId())
       .name(product.getName())
       .description(product.getDescription())
       .price(product.getPrice())
       .category(product.getCategory())
       .build()).toList(); 
       //Mandar el objeto a la vista
       model.addAttribute("productsDTO", dto);
        return "index";
    }

    //dirigir a la vista de agregar producto
    @GetMapping("/index/agregar-producto")
    public String addProduct(Model model){

        //obtener todas las categorias y guardarlas en el DTO
        List<CategoryDTO> categories = categoryService.findAll().stream().map(category -> CategoryDTO.builder()
        .id(category.getId())
        .name(category.getName())
        .build()).toList();
        
        model.addAttribute("categories", categories);

        return "createproduct";
    }
    //Guardar el producto en la base de datos
    @PostMapping("/index/saveproduct")
    public String saveProduct(@RequestParam(name = "name", required = true) String name, @RequestParam(name = "description",  required = true) String description, @RequestParam(name = "price",  required = true) Double price, @RequestParam(name = "category",  required = true) Long category, Model model){
        //obtener todas las categorias y guardarlas en el DTO
        Product product = Product.builder()
        .name(name)
        .description(description)
        .price(price)
        .category(categoryService.findById(category).get())
        .build();

        productService.save(product);

        
        return "redirect:/";
    }

    //enviar a la vista para modificar el producto
    @GetMapping("/index/modificar-producto")
    public String updateProduct(@RequestParam(name = "id", required = true) Long id, Model model){

        //obtener el producto
        Product product = productService.findById(id).get();

        ProductDTO dto = ProductDTO.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .category(product.getCategory())
        .build();
        //mandar el producto a la vista
        model.addAttribute("product", dto);

        //Enviar la lista de categorias
        List<CategoryDTO> categories = categoryService.findAll().stream().map(category -> CategoryDTO.builder()
        .id(category.getId())
        .name(category.getName())
        .build()).toList();
        
        model.addAttribute("categories", categories);


        return "modifyproduct";
    }
    //actualizar el producto en la base de datos
    @PostMapping("/index/updateproduct")
    public String update(@RequestParam(name = "id", required = true) Long id, @RequestParam(name = "name", required = true) String name, @RequestParam(name = "description",  required = true) String description, @RequestParam(name = "price",  required = true) Double price, @RequestParam(name = "category",  required = true) Long category, Model model){

        //obtener el producto
        Product product = productService.findById(id).get();
        Category category2 = categoryService.findById(category).get();
        //Asignar los nuevos campos al producto
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setCategory(category2);  

        //Actualizar el producto
        productService.save(product);
        return "redirect:/";
    }

     //eliminar el producto en la base de datos
    @GetMapping("/index/eliminar-producto")
    public String deleteProduct(@RequestParam(name = "id", required = true) Long id, Model model){

        productService.deleteById(id);

        return "redirect:/";
    }
}