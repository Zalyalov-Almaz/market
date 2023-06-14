package com.almazeisky.market.service.implementors;

import com.almazeisky.market.repository.BucketRepository;
import com.almazeisky.market.service.interfaces.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BucketServiceImpl implements BucketService {

    private final BucketRepository repository;
}
