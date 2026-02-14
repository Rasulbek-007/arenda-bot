package com.example.arenda.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final HomeRepository repository;

    @Override
    public Optional<HomeEntity> getByName(String name) {
        return repository.findByName(name);
    }
}
