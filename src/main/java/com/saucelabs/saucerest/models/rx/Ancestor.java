
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
    "username",
    "current",
    "allowed"
})
public class Ancestor {

    @JsonProperty("username")
    private String username;
    @JsonProperty("current")
    private Current_ current;
    @JsonProperty("allowed")
    private Allowed_ allowed;

    /**
     * 
     * @return
     *     The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public Ancestor withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * 
     * @return
     *     The current
     */
    @JsonProperty("current")
    public Current_ getCurrent() {
        return current;
    }

    /**
     * 
     * @param current
     *     The current
     */
    @JsonProperty("current")
    public void setCurrent(Current_ current) {
        this.current = current;
    }

    public Ancestor withCurrent(Current_ current) {
        this.current = current;
        return this;
    }

    /**
     * 
     * @return
     *     The allowed
     */
    @JsonProperty("allowed")
    public Allowed_ getAllowed() {
        return allowed;
    }

    /**
     * 
     * @param allowed
     *     The allowed
     */
    @JsonProperty("allowed")
    public void setAllowed(Allowed_ allowed) {
        this.allowed = allowed;
    }

    public Ancestor withAllowed(Allowed_ allowed) {
        this.allowed = allowed;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(username).append(current).append(allowed).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Ancestor) == false) {
            return false;
        }
        Ancestor rhs = ((Ancestor) other);
        return new EqualsBuilder().append(username, rhs.username).append(current, rhs.current).append(allowed, rhs.allowed).isEquals();
    }

}
