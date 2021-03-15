package net.christophschubert.ccloud.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {
    @JsonProperty("created_at")
    public final String createdAt;
    @JsonProperty("resource_name")
    public final String resourceName;
    @JsonProperty("self")
    public final String self;
    @JsonProperty("updated_at")
    public final String updatedAt;

    @JsonProperty("deleted_at")
    public final String deletedAt;

    @JsonCreator
    public Metadata(
            @JsonProperty("created_at")String createdAt,
            @JsonProperty("resource_name") String resourceName,
            @JsonProperty("self") String self,
            @JsonProperty("updated_at") String updatedAt,
            @JsonProperty("deleted_at") String deletedAt
    ) {
        this.createdAt = createdAt;
        this.resourceName = resourceName;
        this.self = self;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "createdAt='" + createdAt + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", self='" + self + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", deletedAt='" + deletedAt + '\'' +
                '}';
    }
}
