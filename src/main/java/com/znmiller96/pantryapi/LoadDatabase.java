package com.znmiller96.pantryapi;

import com.znmiller96.pantryapi.model.Catrgory;
import com.znmiller96.pantryapi.model.Location;
import com.znmiller96.pantryapi.repository.CategoryRepository;
import com.znmiller96.pantryapi.repository.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(LocationRepository locationRepository,
                                   CategoryRepository categoryRepository) {
        return args -> {
            locationRepository.save(new Location(1001, "Fridge"));
            locationRepository.save(new Location(1001, "Freezer"));
            locationRepository.save(new Location(1001, "Corner Cabinet"));
            locationRepository.save(new Location(1001, "Cabinet Left of Microwave"));

            categoryRepository.save(new Catrgory(1001, "Dairy"));
            categoryRepository.save(new Catrgory(1001, "Baking"));
        };
    }
}
