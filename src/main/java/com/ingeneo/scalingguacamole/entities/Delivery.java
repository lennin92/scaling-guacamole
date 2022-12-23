package com.ingeneo.scalingguacamole.entities;

import com.github.f4b6a3.ulid.UlidCreator;

import javax.persistence.*;

import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "delivery")
public class Delivery {
    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="product_type_id")
    private ProductType productType;

    @Column(name="registered_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @Column(name="estimated_delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estimatedDeliveryDate;

    @Column(name = "delivery_price")
    private BigDecimal deliveryPrice;

    @Column(name = "price_with_discount")
    private BigDecimal priceWithDiscount;

    @Column(name = "product_quantity")
    private BigDecimal productQuantity;

    @PrePersist
    private void prePersist(){
        this.id = UlidCreator.getMonotonicUlid().toString();
    }
}
