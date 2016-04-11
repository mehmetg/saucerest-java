
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
    "mac",
    "scout",
    "overall",
    "real_device"
})
public class AncestorConcurrencyLimit {

    @JsonProperty("mac")
    private Integer mac;
    @JsonProperty("scout")
    private Integer scout;
    @JsonProperty("overall")
    private Integer overall;
    @JsonProperty("real_device")
    private Integer realDevice;

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

    public AncestorConcurrencyLimit withMac(Integer mac) {
        this.mac = mac;
        return this;
    }

    /**
     * 
     * @return
     *     The scout
     */
    @JsonProperty("scout")
    public Integer getScout() {
        return scout;
    }

    /**
     * 
     * @param scout
     *     The scout
     */
    @JsonProperty("scout")
    public void setScout(Integer scout) {
        this.scout = scout;
    }

    public AncestorConcurrencyLimit withScout(Integer scout) {
        this.scout = scout;
        return this;
    }

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

    public AncestorConcurrencyLimit withOverall(Integer overall) {
        this.overall = overall;
        return this;
    }

    /**
     * 
     * @return
     *     The realDevice
     */
    @JsonProperty("real_device")
    public Integer getRealDevice() {
        return realDevice;
    }

    /**
     * 
     * @param realDevice
     *     The real_device
     */
    @JsonProperty("real_device")
    public void setRealDevice(Integer realDevice) {
        this.realDevice = realDevice;
    }

    public AncestorConcurrencyLimit withRealDevice(Integer realDevice) {
        this.realDevice = realDevice;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mac).append(scout).append(overall).append(realDevice).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AncestorConcurrencyLimit) == false) {
            return false;
        }
        AncestorConcurrencyLimit rhs = ((AncestorConcurrencyLimit) other);
        return new EqualsBuilder().append(mac, rhs.mac).append(scout, rhs.scout).append(overall, rhs.overall).append(realDevice, rhs.realDevice).isEquals();
    }

}
