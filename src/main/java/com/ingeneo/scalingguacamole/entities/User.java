package com.ingeneo.scalingguacamole.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter()
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "user")
public class User {
    @Id
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
}
