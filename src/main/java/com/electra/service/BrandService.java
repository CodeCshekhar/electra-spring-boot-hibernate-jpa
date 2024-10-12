package com.electra.service;


import com.electra.model.BrandModel;

import java.util.List;

public interface BrandService {
    BrandModel saveBrand(BrandModel brand);
    boolean deleteBrand(final Long brandId);
    List<BrandModel> getAllBrands();
    BrandModel getBrandById(final Long brandId);
}
