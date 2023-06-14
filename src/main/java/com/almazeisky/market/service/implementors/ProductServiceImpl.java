package com.almazeisky.market.service.implementors;

import com.almazeisky.market.repository.ProductRepository;
import com.almazeisky.market.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

}
