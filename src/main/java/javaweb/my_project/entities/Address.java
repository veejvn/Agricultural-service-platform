package javaweb.my_project.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @Column(nullable = false)
    String province;
    @Column(nullable = false)
    String district;
    @Column(nullable = false)
    String ward;
    @Column(nullable = false)
    String detail;

    @OneToOne(mappedBy = "address")
    Farmer farmer;

    @OneToOne(mappedBy = "address")
    Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    Account account;

}
