package com.saucelabs.saucerest.models.tx;

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
    "source"
})
public class CustomJobData {

    @JsonProperty("source")
    private String source;

    /**
     * No args constructor for use in serialization
     *
     */
    public CustomJobData() {
    }

    /**
     *
     * @param source
     */
    public CustomJobData(String source) {
        this.source = source;
    }

    /**
     *
     * @return
     * The source
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     * The source
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public CustomJobData withSource(String source) {
        this.source = source;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(source).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomJobData) == false) {
            return false;
        }
        CustomJobData rhs = ((CustomJobData) other);
        return new EqualsBuilder().append(source, rhs.source).isEquals();
    }

}