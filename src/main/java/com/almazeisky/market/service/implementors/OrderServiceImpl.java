package com.almazeisky.market.service.implementors;

import com.almazeisky.market.repository.OrderRepository;
import com.almazeisky.market.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
}
