package com.example.arenda.home;

import java.util.Optional;

public interface HomeService {

    Optional<HomeEntity> getByName(String name);
}
