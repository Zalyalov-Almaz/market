package com.almazeisky.market.service.implementors;

import com.almazeisky.market.repository.OrderDetailRepository;
import com.almazeisky.market.service.interfaces.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository repository;
}
