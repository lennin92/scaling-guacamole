package com.ingeneo.scalingguacamole.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.*;

@Getter
@Setter()
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "client")
public class Client {
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
    @Column(name = "clients_idnumber", unique = true)
    private String clientsIdentification;
    @Column(name = "clients_name")
    private String clientsName;

    @PrePersist
    private void prePersist(){
        this.id = UlidCreator.getMonotonicUlid().toString();
    }

}
