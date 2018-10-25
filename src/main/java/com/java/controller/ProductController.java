package com.java.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import com.java.dao.ProductRep;
import com.java.dto.Product;

@SessionScope
/*@Scope("session")*/
@Controller
public class ProductController {

	@Autowired
	ProductRep rep;
	
	private Page<Product> page ;

	@GetMapping(path = "/products")
	public String getProducts(Model model) {
		model.addAttribute("products", rep.findAll(Sort.by("id")));
		return "product";
	}

	@GetMapping(path = "/products", params = { "index", "limit" })
	public String getProducts(Model model, @RequestParam int index, @RequestParam int limit,
			/* @SortDefault("id") */@RequestParam(defaultValue = "id") String fieldname) {
		 page = rep.findAll(PageRequest.of(index, limit, Sort.by(fieldname)));
		List<Product> list = page.getContent();
		/* rep.findAll(page.nextPageable()); */
		model.addAttribute("products", list);
		return "product";
	}

	@GetMapping("/next")
	public String nextPage(Model model) {
		page=rep.findAll(page.nextPageable()); 
		model.addAttribute("products", page.getContent());
		return "product";
	}
	
	@GetMapping("/previous")
	public String previousPage(Model model) {
		if(page.hasPrevious()) {
		page=rep.findAll(page.previousPageable()); 
		model.addAttribute("products", page.getContent());
		}
		return "product";
	}
	@GetMapping("/addproduct")
	public String getProductAddPage() {
		return "addProduct";
	}

	@PostMapping("/addproduct")
	public String saveProduct(@ModelAttribute Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct";
		}
		product.setCreationdate(LocalDateTime.now());
		rep.save(product);
		return "redirect:products";
	}

	@GetMapping("/deleteproduct")
	public String deleteProduct(int id) {
		rep.deleteById(id);
		return "redirect:products";
	}

	@GetMapping("/updateproduct")
	public String updateProduct(@ModelAttribute Product product, BindingResult result) {
		rep.save(product);
		return "addProduct";
	}
	/*
	 * @InitBinder public void init(WebDataBinder binder) { binder.s }
	 */
}
