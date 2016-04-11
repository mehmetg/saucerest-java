package com.saucelabs.saucerest.models.tx;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "tags",
    "name",
    "custom-data"
})
public class JobDetails {

    @JsonProperty("tags")
    private List<String> tags = new ArrayList<String>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("custom-data")
    private CustomJobData customJobData;

    /**
     * No args constructor for use in serialization
     */
    public JobDetails() {
    }

    /**
     * @param tags
     * @param name
     * @param customData
     */
    public JobDetails(List<String> tags, String name, CustomJobData customData) {
        this.tags = tags;
        this.name = name;
        this.customJobData = customData;
    }

    /**
     * @return The tags
     */
    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    /**
     * @param tags The tags
     */
    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public JobDetails withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public JobDetails withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return The customData
     */
    @JsonProperty("custom-data")
    public CustomJobData getCustomData() {
        return customJobData;
    }

    /**
     * @param customData The custom-data
     */
    @JsonProperty("custom-data")
    public void setCustomData(CustomJobData customData) {
        this.customJobData = customData;
    }

    public JobDetails withCustomData(CustomJobData customData) {
        this.customJobData = customData;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tags).append(name).append(customJobData).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JobDetails) == false) {
            return false;
        }
        JobDetails rhs = ((JobDetails) other);
        return new EqualsBuilder().append(tags, rhs.tags).append(name, rhs.name).append(customJobData, rhs.customJobData).isEquals();
    }
}