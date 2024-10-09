package com.electra.service;

import com.electra.domain.Brand;
import com.electra.repository.BrandRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private static final Logger logger = LoggerFactory.getLogger(BrandService.class);

    @Autowired
    private BrandRepository repo;

    public List<Brand> retrieveBrands() {
        logger.info("Inside BrandService.retrieveBrands()");
        return repo.findAll();
    }

    public Brand storeBrand(Brand brand) {
        logger.info("Inside BrandService.storeBrand()");
        return repo.save(brand);
    }

    public String deleteBrand(long id) {
        logger.info("Inside BrandService.deleteBrand()");
        repo.deleteById(id);
        return "Brand Deleted";
    }

    public Optional<Brand> search(long id) {
        logger.info("Inside BrandService.search()");
        return repo.findById(id);
    }

    public Brand updateBrand(Brand brand) {
        logger.info("Inside BrandService.updateBrand()");
        return repo.save(brand);
    }
}
