
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
    "self",
    "ancestor"
})
public class Concurrency_ {

    @JsonProperty("self")
    private Self self;
    @JsonProperty("ancestor")
    private Ancestor ancestor;

    /**
     * 
     * @return
     *     The self
     */
    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    @JsonProperty("self")
    public void setSelf(Self self) {
        this.self = self;
    }

    public Concurrency_ withSelf(Self self) {
        this.self = self;
        return this;
    }

    /**
     * 
     * @return
     *     The ancestor
     */
    @JsonProperty("ancestor")
    public Ancestor getAncestor() {
        return ancestor;
    }

    /**
     * 
     * @param ancestor
     *     The ancestor
     */
    @JsonProperty("ancestor")
    public void setAncestor(Ancestor ancestor) {
        this.ancestor = ancestor;
    }

    public Concurrency_ withAncestor(Ancestor ancestor) {
        this.ancestor = ancestor;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(ancestor).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Concurrency_) == false) {
            return false;
        }
        Concurrency_ rhs = ((Concurrency_) other);
        return new EqualsBuilder().append(self, rhs.self).append(ancestor, rhs.ancestor).isEquals();
    }

}
