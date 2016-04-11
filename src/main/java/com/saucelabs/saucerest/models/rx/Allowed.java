
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
    "manual",
    "mac",
    "overall",
    "real_device"
})
public class Allowed {

    @JsonProperty("manual")
    private Integer manual;
    @JsonProperty("mac")
    private Integer mac;
    @JsonProperty("overall")
    private Integer overall;
    @JsonProperty("real_device")
    private Integer realDevice;

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

    public Allowed withManual(Integer manual) {
        this.manual = manual;
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

    public Allowed withMac(Integer mac) {
        this.mac = mac;
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

    public Allowed withOverall(Integer overall) {
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

    public Allowed withRealDevice(Integer realDevice) {
        this.realDevice = realDevice;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(manual).append(mac).append(overall).append(realDevice).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Allowed) == false) {
            return false;
        }
        Allowed rhs = ((Allowed) other);
        return new EqualsBuilder().append(manual, rhs.manual).append(mac, rhs.mac).append(overall, rhs.overall).append(realDevice, rhs.realDevice).isEquals();
    }

}
