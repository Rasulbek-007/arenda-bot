package com.example.arenda.home;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final HomeRepository repository;

    @PostConstruct
    public void loadData() {

        if (repository.count() == 0) {

            repository.save(
                    HomeEntity.builder()
                            .name("Chilonzor")
                            .link("https://t.me/chilonzorijaraga")
                            .build()
            );

            repository.save(
                    HomeEntity.builder()
                            .name("Yunusobod")
                            .link("https://t.me/yunusobodijara")
                            .build()
            );
        }
    }
}
