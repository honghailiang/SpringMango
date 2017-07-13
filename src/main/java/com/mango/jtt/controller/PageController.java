/**
 *
 */
package com.mango.jtt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mango.jtt.po.Product;
import com.mango.jtt.service.IProductService;

/**
 * 页面处理器
 *
 * @author HHL
 *
 * @date 2016年11月22日
 */
@Controller
public class PageController {
	@Autowired
	private IProductService productService;
	/**
	 * 首页 映射/和/index路径
	 *
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/", "/index" })
	public String index(Model model) throws Exception {
		List<Product> productList = productService.getProductList();
		model.addAttribute("productList", productList);
		return "index";
	}

}
