package net.christophschubert.ccloud.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Environment {
    public static final String API_VERSION_KEY = "api_version";
    public static final String DATA_KEY = "data";
    public static final String DISPLAY_NAME_KEY = "display_name";
    public static final String ID_KEY = "id";
    public static final String KIND_KEY = "kind";
    public static final String METADATA_KEY = "metadata";

    @JsonProperty(API_VERSION_KEY)
    public final String apiVersion;

    @JsonProperty(DISPLAY_NAME_KEY)
    public final String displayName;

    @JsonProperty(ID_KEY)
    public final String id;

    @JsonProperty(KIND_KEY)
    public final String kind;

    @JsonProperty(METADATA_KEY)
    public final Metadata metadata;

    @JsonCreator
    public Environment(
            @JsonProperty(API_VERSION_KEY) String apiVersion,
            @JsonProperty(DISPLAY_NAME_KEY) String displayName,
            @JsonProperty(ID_KEY) String id,
            @JsonProperty(KIND_KEY) String kind,
            @JsonProperty(METADATA_KEY) Metadata metadata
    ) {
        this.apiVersion = apiVersion;
        this.displayName = displayName;
        this.id = id;
        this.kind = kind;
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "apiVersion='" + apiVersion + '\'' +
                ", displayName='" + displayName + '\'' +
                ", id='" + id + '\'' +
                ", kind='" + kind + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}
