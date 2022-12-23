package com.ingeneo.scalingguacamole.entities;

import com.github.f4b6a3.ulid.UlidCreator;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;


@Getter
@Setter()
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "user")
public class User {
    @Id
    private String id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password", unique = true)
    private String password;

    @PrePersist
    private void prePersist(){
        this.id = UlidCreator.getMonotonicUlid().toString();
    }
}
