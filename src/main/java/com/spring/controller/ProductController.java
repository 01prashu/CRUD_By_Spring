package com.spring.controller;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.dao.ImplementInterfaceDao;
import com.spring.dao.JavaConfig;
import com.spring.model.Product;

@Controller
public class ProductController {
	
	@RequestMapping(value="/home" , method=RequestMethod.GET)
	public String Home(@ModelAttribute Product product , Model model)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		ImplementInterfaceDao implDao = context.getBean("dao", ImplementInterfaceDao.class);
		List<Product>list = implDao.GetAllProduct();
		model.addAttribute("ProductList", list);
		
		return "home";
	}
	@RequestMapping("/addProduct")
	public String AddProduct()
	{
		return "AddProductForm";
	}
	@RequestMapping(value="/handleform" , method=RequestMethod.POST)
	public String Handle(@ModelAttribute Product product , Model model)
	{
		model.addAttribute("product", product);
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		ImplementInterfaceDao implDao = context.getBean("dao", ImplementInterfaceDao.class);
		int r = implDao.Add(product);
		System.out.println("Rows added into database"+r);
		
		List<Product>list = implDao.GetAllProduct();
		model.addAttribute("ProductList", list);
		System.out.println(list);
		
		return "home";
	}
	
	@RequestMapping(value ="/home/delete/{id}" , method=RequestMethod.GET)
	public String DeleteHandle(@PathVariable("id")int productId , Model model)
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		ImplementInterfaceDao implDao = context.getBean("dao", ImplementInterfaceDao.class);
		int r = implDao.Remove(productId);
		List<Product> list = implDao.GetAllProduct();
		model.addAttribute("ProductList", list);
		return "redirect:/home";
	}
	
	
	@RequestMapping(value="/home/update/{id}" , method = RequestMethod.GET)
	public String Update( @PathVariable("id")int id,Model model )
	{
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		ImplementInterfaceDao implDao = context.getBean("dao", ImplementInterfaceDao.class);
		List<Product>list = implDao.GetAllProduct();
		
		System.out.println(list);
		for(Product product : list)
		{
			if(product.getId()==id)
			{
				model.addAttribute("product" , product);
				
			}
		}
		
		return "update-form";
	}
	@RequestMapping(value="/home/update/handleUpdate/{id}" , method=RequestMethod.POST)
	public String UpdateHandle(@PathVariable("id") int id, @ModelAttribute Product updatedProduct, Model model) {
	    ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
	    ImplementInterfaceDao implDao = context.getBean("dao", ImplementInterfaceDao.class);
	    
	    updatedProduct.setId(id); // Ensure the updated product has the correct ID
	    int r = implDao.Update(updatedProduct); // Update the product
	    System.out.println("Updated product: " + updatedProduct);
	    
	    List<Product> list = implDao.GetAllProduct(); // Get all products after update
	    model.addAttribute("ProductList", list);
	    
	    return "redirect:/home";
	
////public String UpdateHandle(@PathVariable("id") int id, @ModelAttribute Product updatedProduct, Model model) {
//    updatedProduct.setId(id);
//    implDao.Update(updatedProduct);
//    return "redirect:/ProductApp/home";
}
}
