
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
    "wait_time",
    "service_operational",
    "status_message"
})
public class Status {

    @JsonProperty("wait_time")
    private Double waitTime;
    @JsonProperty("service_operational")
    private Boolean serviceOperational;
    @JsonProperty("status_message")
    private String statusMessage;

    /**
     * 
     * @return
     *     The waitTime
     */
    @JsonProperty("wait_time")
    public Double getWaitTime() {
        return waitTime;
    }

    /**
     * 
     * @param waitTime
     *     The wait_time
     */
    @JsonProperty("wait_time")
    public void setWaitTime(Double waitTime) {
        this.waitTime = waitTime;
    }

    public Status withWaitTime(Double waitTime) {
        this.waitTime = waitTime;
        return this;
    }

    /**
     * 
     * @return
     *     The serviceOperational
     */
    @JsonProperty("service_operational")
    public Boolean getServiceOperational() {
        return serviceOperational;
    }

    /**
     * 
     * @param serviceOperational
     *     The service_operational
     */
    @JsonProperty("service_operational")
    public void setServiceOperational(Boolean serviceOperational) {
        this.serviceOperational = serviceOperational;
    }

    public Status withServiceOperational(Boolean serviceOperational) {
        this.serviceOperational = serviceOperational;
        return this;
    }

    /**
     * 
     * @return
     *     The statusMessage
     */
    @JsonProperty("status_message")
    public String getStatusMessage() {
        return statusMessage;
    }

    /**
     * 
     * @param statusMessage
     *     The status_message
     */
    @JsonProperty("status_message")
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Status withStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(waitTime).append(serviceOperational).append(statusMessage).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Status) == false) {
            return false;
        }
        Status rhs = ((Status) other);
        return new EqualsBuilder().append(waitTime, rhs.waitTime).append(serviceOperational, rhs.serviceOperational).append(statusMessage, rhs.statusMessage).isEquals();
    }

}
