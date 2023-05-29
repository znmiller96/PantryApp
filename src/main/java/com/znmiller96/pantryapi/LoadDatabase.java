package com.znmiller96.pantryapi;

import com.znmiller96.pantryapi.model.dao.Category;
import com.znmiller96.pantryapi.model.dao.ExpirationDate;
import com.znmiller96.pantryapi.model.dao.Location;
import com.znmiller96.pantryapi.model.dao.Measurement;
import com.znmiller96.pantryapi.model.dao.Pantry;
import com.znmiller96.pantryapi.model.dao.UsedDate;
import com.znmiller96.pantryapi.repository.CategoryRepository;
import com.znmiller96.pantryapi.repository.LocationRepository;
import com.znmiller96.pantryapi.repository.PantryRepository;
import com.znmiller96.pantryapi.util.MeasurementUnit;
import com.znmiller96.pantryapi.util.QuantityLevel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(LocationRepository locationRepository,
                                   CategoryRepository categoryRepository,
                                   PantryRepository pantryRepository) {
        return args -> {
            locationRepository.save(new Location(1001, "Fridge"));
            locationRepository.save(new Location(1001, "Freezer"));
            locationRepository.save(new Location(1001, "Corner Cabinet"));
            locationRepository.save(new Location(1001, "Cabinet Left of Microwave"));

            categoryRepository.save(new Category(1001, "Dairy"));
            categoryRepository.save(new Category(1001, "Baking"));

            //Pantry Item with everything
            Location location = new Location(1001, "Fridge");
            location.setId(1000);
            Category category = new Category(1001, "Dairy");
            category.setId(1000);

            Pantry pantry = new Pantry(1001, "Pantry Item", QuantityLevel.HIGH.name(), false, true, new Date(), category, location);

            ExpirationDate expirationDate = new ExpirationDate();
            pantry.setExpirationDate(expirationDate);
            expirationDate.setPantry(pantry);
            expirationDate.setExpirationDate(new Date());

            UsedDate usedDate = new UsedDate();
            pantry.setUsedDate(usedDate);
            usedDate.setPantry(pantry);
            usedDate.setUsedDate(new Date());

            Measurement measurement = new Measurement();
            pantry.setMeasurement(measurement);
            measurement.setPantry(pantry);
            measurement.setValue(40);
            measurement.setUnit(MeasurementUnit.OZ.name());

            pantryRepository.save(pantry);

            //Pantry item with no expiration date, used date, or measurement
            Pantry pantryNoExpirationDate = new Pantry(1001, "Pantry Item No Expiration Date", QuantityLevel.HIGH.name(), false, false, new Date(), category, location);
            pantryRepository.save(pantryNoExpirationDate);
        };
    }
}
