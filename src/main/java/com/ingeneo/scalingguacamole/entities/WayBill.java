package com.ingeneo.scalingguacamole.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "way_bill")
public class WayBill {
    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private Delivery delivery;
    @Column(name="warehouse")
    private String warehouse;

    @Column(name="trucks_plate")
    private String trucksPlate;

    @Column(name="waybill_number")
    private String waybillNumber;

    @PrePersist
    private void prePersist(){
        this.id = UlidCreator.getMonotonicUlid().toString();
    }
}
