
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
    "Hello"
})
public class Hello {

    @JsonProperty("Hello")
    private String Hello;

    /**
     * 
     * @return
     *     The Hello
     */
    @JsonProperty("Hello")
    public String getHello() {
        return Hello;
    }

    /**
     * 
     * @param Hello
     *     The Hello
     */
    @JsonProperty("Hello")
    public void setHello(String Hello) {
        this.Hello = Hello;
    }

    public Hello withHello(String Hello) {
        this.Hello = Hello;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Hello).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Hello) == false) {
            return false;
        }
        Hello rhs = ((Hello) other);
        return new EqualsBuilder().append(Hello, rhs.Hello).isEquals();
    }

}
