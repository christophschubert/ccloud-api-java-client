package net.christophschubert.ccloud.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {
    @JsonProperty(Keys.API_VERSION_KEY)
    public final String apiVersion;

    @JsonProperty(Keys.DATA_KEY)
    public final List<Environment> data;

    @JsonProperty(Keys.KIND_KEY)
    public final String kind;

    @JsonProperty(Keys.METADATA_KEY)
    public final CollectionMetadata metadata;

    public Response(
            @JsonProperty(Keys.API_VERSION_KEY) String apiVersion,
            @JsonProperty(Keys.DATA_KEY) List<Environment> data,
            @JsonProperty(Keys.KIND_KEY) String kind,
            @JsonProperty(Keys.METADATA_KEY) CollectionMetadata metadata
    ) {
        this.apiVersion = apiVersion;
        this.data = data;
        this.kind = kind;
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "CollectionMetadata{" +
                "apiVersion='" + apiVersion + '\'' +
                ", data=" + data +
                ", kind='" + kind + '\'' +
                ", metadata='" + metadata + '\'' +
                '}';
    }
}
