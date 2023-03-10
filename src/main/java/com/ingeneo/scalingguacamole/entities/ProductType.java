package com.ingeneo.scalingguacamole.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "product_type")
public class ProductType {
    @Id
    @Setter(AccessLevel.NONE)
    private String id;

    @Column(name = "product_type_name")
    private String productTypeName;

    @PrePersist
    private void prePersist(){
        this.id = UlidCreator.getMonotonicUlid().toString();
    }
}
