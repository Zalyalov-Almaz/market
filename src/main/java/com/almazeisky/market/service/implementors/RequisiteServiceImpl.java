package com.almazeisky.market.service.implementors;

import com.almazeisky.market.repository.RequisiteRepository;
import com.almazeisky.market.service.interfaces.RequisiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequisiteServiceImpl implements RequisiteService {

    private final RequisiteRepository repository;

}
