package com.ingeneo.scalingguacamole.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "delivery")
public class Delivery {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="product_type_id")
    private ProductType productType;

    @Column(name="registered_at")
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime registeredAt;

    @Column(name="estimated_delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime estimatedDeliveryDate;

    @Column(name = "delivery_price")
    private BigDecimal deliveryPrice;

    @PrePersist
    private void prePersist(){
        this.id = UlidCreator.getMonotonicUlid().toString();
    }
}
