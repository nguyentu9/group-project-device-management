package com.amigoscode.devicemanagement.domain.device.model;

import lombok.Value;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Value
public class Device implements Serializable {

    String id;
    String name;
    String ownerId;
    ZonedDateTime createdAt;
    ZonedDateTime deletedAt;
    ZonedDateTime updatedAt;
    String updatedBy;
}
