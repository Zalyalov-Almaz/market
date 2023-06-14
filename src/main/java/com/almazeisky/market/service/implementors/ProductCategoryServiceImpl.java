package com.almazeisky.market.service.implementors;

import com.almazeisky.market.repository.ProductCategoryRepository;
import com.almazeisky.market.service.interfaces.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository repository;

}
