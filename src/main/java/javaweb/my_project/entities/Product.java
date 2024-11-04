package javaweb.my_project.entities;

import jakarta.persistence.*;
import javaweb.my_project.enums.ProductStatus;
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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;

    String description;

    Integer price;

    Integer inventory;

    Integer sold;

    Double rating;

    String thumbnail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    ProductStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "market_price_id")
    MarketPrice marketPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    Set<Image> images = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    Set<Review> reviews = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    Set<CartItem> cartItems = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    Farmer farmer;

    @PrePersist
    void onCreate(){
        this.status = ProductStatus.PENDING;
        this.rating = 0.0;
        this.sold = 0;
    }
}
