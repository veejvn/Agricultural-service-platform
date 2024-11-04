package javaweb.my_project.entities;

import jakarta.persistence.*;
import javaweb.my_project.enums.FarmerStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(nullable = false)
    String name;

    String avatar;

    String coverImage;

    String rating;

    String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    FarmerStatus status;

    @OneToOne
    @JoinColumn(name = "account_id")
    Account account;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_info_id")
    WeatherInfo weatherInfo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmer", orphanRemoval = true)
    Set<Product> products =  new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "farmer", orphanRemoval = true)
    Set<Order> orders = new HashSet<>();

    @PrePersist
    void onCreate(){
        this.status = FarmerStatus.ACTIVE;
    }
}
