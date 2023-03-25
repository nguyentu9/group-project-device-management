package com.amigoscode.devicemanagement.external.storage.rule;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amigoscode.devicemanagement.external.storage.utils.ZonedDateTimeConverter;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.Set;

@DynamoDBTable(tableName = "RulesEngine")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RuleEntity {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private Boolean isActive;
    @DynamoDBAttribute
    private String topicPattern;
    @DynamoDBAttribute
    private String payloadPattern;
    @DynamoDBAttribute
    private Set<String> method;
    @DynamoDBAttribute
    private String webhookUrl;

    @DynamoDBTypeConverted(converter = ZonedDateTimeConverter.class)
    @DynamoDBAttribute
    private ZonedDateTime createdAt;
    @DynamoDBTypeConverted(converter = ZonedDateTimeConverter.class)
    @DynamoDBAttribute
    private ZonedDateTime updatedAt;
    @DynamoDBTypeConverted(converter = ZonedDateTimeConverter.class)
    @DynamoDBAttribute
    private ZonedDateTime deletedAt;
    @DynamoDBAttribute
    private String updatedBy;


    public RuleEntity(String name, Boolean isActive, String topicPattern, String payloadPattern, Set<String> method, String webhookUrl) {
        this.name = name;
        this.isActive = isActive;
        this.topicPattern = topicPattern;
        this.payloadPattern = payloadPattern;
        this.method = method;
        this.webhookUrl = webhookUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RuleEntity that = (RuleEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}