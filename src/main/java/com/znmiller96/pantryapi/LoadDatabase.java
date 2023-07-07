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
            locationRepository.save(new Location.Builder()
                    .withUserid(1001)
                    .withLocation("Fridge")
                    .build());
            locationRepository.save(new Location.Builder()
                    .withUserid(1001)
                    .withLocation("Freezer")
                    .build());
            locationRepository.save(new Location.Builder()
                    .withUserid(1001)
                    .withLocation("Corner Cabinet")
                    .build());
            locationRepository.save(new Location.Builder()
                    .withUserid(1001)
                    .withLocation("Cabinet Left of Microwave")
                    .build());

            categoryRepository.save(new Category.Builder()
                    .withUserid(1001)
                    .withCategory("Dairy")
                    .build());
            categoryRepository.save(new Category.Builder()
                    .withUserid(1001)
                    .withCategory("Baking")
                    .build());

            //Pantry Item with everything
            Location location = new Location.Builder()
                    .withId(1000)
                    .build();
            Category category = new Category.Builder()
                    .withId(1000)
                    .build();

            Pantry pantry = new Pantry.Builder()
                    .withUserId(1001)
                    .withName("Pantry Item")
                    .withQuantityLevel(QuantityLevel.HIGH.name())
                    .withFavorite(false)
                    .withUsed(true)
                    .withDayAdded(new Date())
                    .withCategory(category)
                    .withLocation(location)
                    .build();

            ExpirationDate expirationDate = new ExpirationDate.Builder()
                    .withExpirationDate(new Date())
                    .build();

            pantry.setExpirationDate(expirationDate);
            expirationDate.setPantry(pantry);

            UsedDate usedDate = new UsedDate.Builder()
                    .withUsedDate(new Date())
                    .build();

            pantry.setUsedDate(usedDate);
            usedDate.setPantry(pantry);

            Measurement measurement = new Measurement.Builder()
                    .withValue(40)
                    .withUnit(MeasurementUnit.OZ.name())
                    .build();

            pantry.setMeasurement(measurement);
            measurement.setPantry(pantry);

            pantryRepository.save(pantry);

            //Pantry item with no expiration date, used date, or measurement
            Pantry pantryNoDates = new Pantry.Builder()
                    .withUserId(1001)
                    .withName("Pantry Item No Expiration Date")
                    .withQuantityLevel(QuantityLevel.HIGH.name())
                    .withFavorite(false)
                    .withUsed(false)
                    .withDayAdded(new Date())
                    .withCategory(category)
                    .withLocation(location)
                    .build();

            pantryRepository.save(pantryNoDates);
        };
    }
}
