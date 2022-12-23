package com.ingeneo.scalingguacamole.entities;

import com.github.f4b6a3.ulid.UlidCreator;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "bill_of_landing")
public class BillOfLanding {
    @Id
    private String id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private Delivery delivery;

    @Column(name="shipment_port")
    private String shipmentPort;

    @Column(name="fleet_number")
    private String fleetNumber;

    @Column(name="bill_of_landing_number")
    private String billOfLandingNumber;

    @PrePersist
    private void prePersist(){
        this.id = UlidCreator.getMonotonicUlid().toString();
    }
}
