
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
    "overall",
    "mac",
    "manual"
})
public class Current_ {

    @JsonProperty("overall")
    private Integer overall;
    @JsonProperty("mac")
    private Integer mac;
    @JsonProperty("manual")
    private Integer manual;

    /**
     * 
     * @return
     *     The overall
     */
    @JsonProperty("overall")
    public Integer getOverall() {
        return overall;
    }

    /**
     * 
     * @param overall
     *     The overall
     */
    @JsonProperty("overall")
    public void setOverall(Integer overall) {
        this.overall = overall;
    }

    public Current_ withOverall(Integer overall) {
        this.overall = overall;
        return this;
    }

    /**
     * 
     * @return
     *     The mac
     */
    @JsonProperty("mac")
    public Integer getMac() {
        return mac;
    }

    /**
     * 
     * @param mac
     *     The mac
     */
    @JsonProperty("mac")
    public void setMac(Integer mac) {
        this.mac = mac;
    }

    public Current_ withMac(Integer mac) {
        this.mac = mac;
        return this;
    }

    /**
     * 
     * @return
     *     The manual
     */
    @JsonProperty("manual")
    public Integer getManual() {
        return manual;
    }

    /**
     * 
     * @param manual
     *     The manual
     */
    @JsonProperty("manual")
    public void setManual(Integer manual) {
        this.manual = manual;
    }

    public Current_ withManual(Integer manual) {
        this.manual = manual;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(overall).append(mac).append(manual).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Current_) == false) {
            return false;
        }
        Current_ rhs = ((Current_) other);
        return new EqualsBuilder().append(overall, rhs.overall).append(mac, rhs.mac).append(manual, rhs.manual).isEquals();
    }

}
