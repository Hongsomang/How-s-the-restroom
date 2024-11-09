package com.restroom.restroom.controller;


import com.restroom.restroom.model.Category;
import com.restroom.restroom.model.Pager;
import com.restroom.restroom.model.Restroom;
import com.restroom.restroom.service.CategoryService;
import com.restroom.restroom.service.PublicDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
@RequestMapping("/public-data")
public class PublicDataController {
    final String path="public_data/";
    final PublicDataService publicDataService;
    final CategoryService categoryService;

    public PublicDataController(PublicDataService publicDataService,CategoryService categoryService) {
        this.publicDataService = publicDataService;
        this.categoryService=categoryService;
    }

    @ResponseBody
    @GetMapping("/reset")
    public ResponseEntity<List<Restroom>> reset(@RequestParam int categoryCode) throws IOException, NoSuchAlgorithmException, KeyManagementException {
       List<Restroom> list =publicDataService.reset(categoryCode);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/list")
    public String list(Pager pager, Model model){
        List<Restroom> list=publicDataService.list(pager);
        List<Category> categoryList=categoryService.findByMainCateCode(1);

        model.addAttribute("list",list);
        model.addAttribute("categoryList",categoryList);
        return path+"list";
    }
}
