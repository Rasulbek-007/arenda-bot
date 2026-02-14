package com.example.arenda.home;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HomeRepository extends JpaRepository<HomeEntity, Long> {

    Optional<HomeEntity> findByName(String name);
}
