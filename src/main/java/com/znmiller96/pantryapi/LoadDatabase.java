package com.znmiller96.pantryapi;

import com.znmiller96.pantryapi.model.Category;
import com.znmiller96.pantryapi.model.ExpirationDate;
import com.znmiller96.pantryapi.model.Location;
import com.znmiller96.pantryapi.model.Pantry;
import com.znmiller96.pantryapi.repository.CategoryRepository;
import com.znmiller96.pantryapi.repository.LocationRepository;
import com.znmiller96.pantryapi.repository.PantryRepository;
import com.znmiller96.pantryapi.util.QuantityLevel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(LocationRepository locationRepository,
                                   CategoryRepository categoryRepository,
                                   PantryRepository pantryRepository) {
        return args -> {
            //TODO Add builders to models
            locationRepository.save(new Location(1001, "Fridge"));
            locationRepository.save(new Location(1001, "Freezer"));
            locationRepository.save(new Location(1001, "Corner Cabinet"));
            locationRepository.save(new Location(1001, "Cabinet Left of Microwave"));

            categoryRepository.save(new Category(1001, "Dairy"));
            categoryRepository.save(new Category(1001, "Baking"));

            Location location = new Location(1001, "Fridge");
            location.setId(1000);
            Category category = new Category(1001, "Dairy");
            category.setId(1000);
            Pantry pantry = new Pantry(1001, "Pantry Item", QuantityLevel.HIGH.name(), false, false, new Date(), category, location);
            ExpirationDate expirationDate = new ExpirationDate();
            pantry.setExpirationDate(expirationDate);
            expirationDate.setPantry(pantry);
            expirationDate.setExpirationDate(new Date());
            pantryRepository.save(pantry);

            Pantry pantryNoExpirationDate = new Pantry(1001, "Pantry Item No Expiration Date", QuantityLevel.HIGH.name(), false, false, new Date(), category, location);
            pantryRepository.save(pantryNoExpirationDate);
        };
    }
}
