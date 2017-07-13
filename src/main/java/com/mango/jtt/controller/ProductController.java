/**
 *
 */
package com.mango.jtt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mango.jtt.po.Product;
import com.mango.jtt.service.IProductService;

/**
 * @author HHL
 *
 * @date 2016年11月30日
 */
@Controller
public class ProductController {
	@Autowired
	private IProductService productService;

	@RequestMapping("/product/{productId}")
	public String getProductById(Model model, @PathVariable Long productId) {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);
		return "product_detail";
	}

}
