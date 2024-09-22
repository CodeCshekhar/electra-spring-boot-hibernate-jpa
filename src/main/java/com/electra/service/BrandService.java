package com.electra.service;

import com.electra.domain.Brand;
import com.electra.repository.BrandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BrandService {
    private static final Logger logger = LoggerFactory.getLogger(BrandService.class);

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        logger.info("Brands Retrieved in Services");
        return brandRepository.findAll();
    }

    public Brand getBrandById(Long id) {
        logger.info("Brand detected by ID in Services");
        return brandRepository.findById(id).orElse(null);
    }

    public Brand createBrand(Brand brand) {
        logger.info("Brand Created in Services");
        return brandRepository.save(brand);
    }

    public Brand updateBrand(Long id, Brand updatedBrand) {
        Brand brand = brandRepository.findById(id).orElse(null);
        if (brand != null) {
            brand.setName(updatedBrand.getName());
            brand.setDescription(updatedBrand.getDescription());
            logger.info("Brand Updated in Services");
            return brandRepository.save(brand);
        }
        return null;
    }

    public void deleteBrand(Long id) {
        logger.info("User deleted");
        brandRepository.deleteById(id);
    }
}
