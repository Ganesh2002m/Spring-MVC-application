package org.example.springmvc.controller;

import org.example.springmvc.model.Product;
import org.example.springmvc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class ProductController{
    private ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(path = "/")
    public String index(){
        return "index";
    }
    @RequestMapping(path ="/products/add",method = RequestMethod.GET)
    public String createproduct(Model model){
        model.addAttribute("product",new Product());
        return "editor";
    }
    @RequestMapping(path = "products",method = RequestMethod.POST)
    public String saveproduct(Product product){
        productRepository.save(product);
        return "redirect:/";

    }
    @RequestMapping(path="/products",method=RequestMethod.GET)
    public String getAllproducts(Model model){
        model.addAttribute("products",productRepository.findAll());
        return "products";
    }
    @RequestMapping(path = "/products/edit/{id}",method = RequestMethod.GET)
    public String updatingProducts(Model model,@PathVariable (value="id")String id){
        model.addAttribute("product",productRepository.findById(id));
        return "editor";
    }
    @RequestMapping(path = "/products/delete/{id}",method = RequestMethod.GET)
    public String updatingProducts(@PathVariable (value="id")String id){
        productRepository.deleteById(id);
        return "redirect:/products";

    }
}
