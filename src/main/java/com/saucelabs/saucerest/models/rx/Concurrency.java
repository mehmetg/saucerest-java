
package com.saucelabs.saucerest.models.rx;

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
    "timestamp",
    "concurrency"
})
public class Concurrency {

    @JsonProperty("timestamp")
    private Double timestamp;
    @JsonProperty("concurrency")
    private Concurrency_ concurrency;

    /**
     * 
     * @return
     *     The timestamp
     */
    @JsonProperty("timestamp")
    public Double getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * @param timestamp
     *     The timestamp
     */
    @JsonProperty("timestamp")
    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public Concurrency withTimestamp(Double timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * 
     * @return
     *     The concurrency
     */
    @JsonProperty("concurrency")
    public Concurrency_ getConcurrency() {
        return concurrency;
    }

    /**
     * 
     * @param concurrency
     *     The concurrency
     */
    @JsonProperty("concurrency")
    public void setConcurrency(Concurrency_ concurrency) {
        this.concurrency = concurrency;
    }

    public Concurrency withConcurrency(Concurrency_ concurrency) {
        this.concurrency = concurrency;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(timestamp).append(concurrency).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Concurrency) == false) {
            return false;
        }
        Concurrency rhs = ((Concurrency) other);
        return new EqualsBuilder().append(timestamp, rhs.timestamp).append(concurrency, rhs.concurrency).isEquals();
    }

}
