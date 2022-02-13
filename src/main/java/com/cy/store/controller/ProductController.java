package com.cy.store.controller;

import com.cy.store.entity.Product;
import com.cy.store.service.IProductService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PackgeName: com.cy.store.controller
 * @ClassName: ProductController
 * @Author: zyp
 * Date: 2022/2/13 14:16
 * project name: store
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "hot_list", method = RequestMethod.GET)
    public JsonResult<List<Product>> getHotList(){
        List<Product> hotList = productService.findHotList();
        return new JsonResult<>(OK, hotList);
    }

    @RequestMapping(value = "{id}/details", method = RequestMethod.GET)
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        Product product = productService.findById(id);
        return new JsonResult<>(OK,  product);
    }
}
