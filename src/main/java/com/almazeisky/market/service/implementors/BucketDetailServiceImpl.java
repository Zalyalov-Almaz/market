package com.almazeisky.market.service.implementors;

import com.almazeisky.market.repository.BucketRepository;
import com.almazeisky.market.service.interfaces.BucketDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BucketDetailServiceImpl implements BucketDetailService {

    private final BucketRepository repository;
}
