package com.example.dmdevcourse.service;


import com.example.dmdevcourse.database.entity.Company;
import com.example.dmdevcourse.database.repository.CompanyRepository;

import com.example.dmdevcourse.dto.CompanyReadDto;
import com.example.dmdevcourse.listener.entity.AccessType;
import com.example.dmdevcourse.listener.entity.EntityEvent;
import com.example.dmdevcourse.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CompanyService {
    private final CompanyRepository companyRepositotry;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;
    private final CompanyReadMapper companyReadMapper;


    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepositotry.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return companyReadMapper.map(entity);
                });
    }

    public List<CompanyReadDto> findAll() {
        return companyRepositotry.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }


}
