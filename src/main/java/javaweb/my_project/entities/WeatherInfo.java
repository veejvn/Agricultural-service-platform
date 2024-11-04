package javaweb.my_project.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class WeatherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String region;
    String rain;
    String temperature;
    String humidity;
    String windSpeed;
    String forecast;
    LocalDateTime recordedAt;

    @OneToOne(mappedBy = "weatherInfo")
    Farmer farmer;
}
