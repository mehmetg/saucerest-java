package com.saucelabs.saucerest.models.tx;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "js tests"
})
public class JsUnitTestResultRequest {

    @JsonProperty("js tests")
    private List<String> jsTests = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     */
    public JsUnitTestResultRequest() {
    }

    /**
     * @param jsTests
     */
    public JsUnitTestResultRequest(List<String> jsTests) {
        this.jsTests = jsTests;
    }

    /**
     * @return The jsTests
     */
    @JsonProperty("js tests")
    public List<String> getJsTests() {
        return jsTests;
    }

    /**
     * @param jsTests The js tests
     */
    @JsonProperty("js tests")
    public void setJsTests(List<String> jsTests) {
        this.jsTests = jsTests;
    }

    public JsUnitTestResultRequest withJsTests(List<String> jsTests) {
        this.jsTests = jsTests;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(jsTests).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JsUnitTestResultRequest) == false) {
            return false;
        }
        JsUnitTestResultRequest rhs = ((JsUnitTestResultRequest) other);
        return new EqualsBuilder().append(jsTests, rhs.jsTests).isEquals();
    }

}
