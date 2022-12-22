package com.ingeneo.scalingguacamole.entities;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity(name = "client")
public class Client {
    private String id;
    private String clientIdentification;
    private String clientsName;

}
