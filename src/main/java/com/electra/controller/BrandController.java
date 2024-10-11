package com.electra.controller;

import com.electra.model.BrandModel;
import com.electra.service.BrandService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/electra")
public class BrandController {

    @Resource(name = "brandService")
    private BrandService brandService;

    @GetMapping("/brands")
    public List<BrandModel> getBrands(){
        return brandService.getAllBrands();
    }

    @GetMapping("/brand/{id}")
    public BrandModel getBrand(@PathVariable Long id){
        return brandService.getBrandById(id);
    }

    @PostMapping("/brand")
    public BrandModel saveBrand(final @RequestBody BrandModel brandModel){
        return brandService.saveBrand(brandModel);
    }

    @DeleteMapping("/brand/{id}")
    public Boolean deleteBrand(@PathVariable Long id){
        return brandService.deleteBrand(id);
    }
}