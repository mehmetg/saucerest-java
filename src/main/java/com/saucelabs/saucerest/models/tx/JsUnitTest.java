package com.saucelabs.saucerest.models.tx;

import java.util.ArrayList;
import java.util.List;
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
        "platforms",
        "url",
        "framework",
        "tunnel",
        "parent_tunnel",
        "commandTimeout",
        "idleTimeout",
        "maxDuration",
        "prerun"
})
public class JsUnitTest {

    @JsonProperty("platforms")
    private List<List<String>> platforms = new ArrayList<List<String>>();
    @JsonProperty("url")
    private String url;
    @JsonProperty("framework")
    private String framework;
    @JsonProperty("tunnel")
    private String tunnel;
    @JsonProperty("parent_tunnel")
    private String parentTunnel;
    @JsonProperty("commandTimeout")
    private Integer commandTimeout;
    @JsonProperty("idleTimeout")
    private Integer idleTimeout;
    @JsonProperty("maxDuration")
    private Integer maxDuration;
    @JsonProperty("prerun")
    private String prerun;

    /**
     * No args constructor for use in serialization
     *
     */
    public JsUnitTest() {
    }

    /**
     * Generates the payload with the required info.
     * For optionals use the builder methods.
     * @param platforms
     * @param framework
     * @param url
     * @param tunnel
     */
    public JsUnitTest(List<List<String>> platforms, String url, String framework, String tunnel) {
        this.platforms = platforms;
        this.url = url;
        this.framework = framework;
        this.tunnel = tunnel;
    }

    /**
     *
     * @return
     * The platforms
     */
    @JsonProperty("platforms")
    public List<List<String>> getPlatforms() {
        return platforms;
    }

    /**
     *
     * @param platforms
     * The platforms
     */
    @JsonProperty("platforms")
    public void setPlatforms(List<List<String>> platforms) {
        this.platforms = platforms;
    }

    public JsUnitTest withPlatforms(List<List<String>> platforms) {
        this.platforms = platforms;
        return this;
    }

    /**
     *
     * @return
     * The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    public JsUnitTest withUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     *
     * @return
     * The framework
     */
    @JsonProperty("framework")
    public String getFramework() {
        return framework;
    }

    /**
     *
     * @param framework
     * The framework
     */
    @JsonProperty("framework")
    public void setFramework(String framework) {
        this.framework = framework;
    }

    public JsUnitTest withFramework(String framework) {
        this.framework = framework;
        return this;
    }

    /**
     *
     * @return
     * The tunnel
     */
    @JsonProperty("tunnel")
    public String getTunnel() {
        return tunnel;
    }

    /**
     *
     * @param tunnel
     * The tunnel
     */
    @JsonProperty("tunnel")
    public void setTunnel(String tunnel) {
        this.tunnel = tunnel;
    }

    public JsUnitTest withTunnel(String tunnel) {
        this.tunnel = tunnel;
        return this;
    }

    /**
     *
     * @return
     * The parentTunnel
     */
    @JsonProperty("parent_tunnel")
    public String getParentTunnel() {
        return parentTunnel;
    }

    /**
     *
     * @param parentTunnel
     * The parent_tunnel
     */
    @JsonProperty("parent_tunnel")
    public void setParentTunnel(String parentTunnel) {
        this.parentTunnel = parentTunnel;
    }

    public JsUnitTest withParentTunnel(String parentTunnel) {
        this.parentTunnel = parentTunnel;
        return this;
    }

    /**
     *
     * @return
     * The commandTimeout
     */
    @JsonProperty("commandTimeout")
    public Integer getCommandTimeout() {
        return commandTimeout;
    }

    /**
     *
     * @param commandTimeout
     * The commandTimeout
     */
    @JsonProperty("commandTimeout")
    public void setCommandTimeout(Integer commandTimeout) {
        this.commandTimeout = commandTimeout;
    }

    public JsUnitTest withCommandTimeout(Integer commandTimeout) {
        this.commandTimeout = commandTimeout;
        return this;
    }

    /**
     *
     * @return
     * The idleTimeout
     */
    @JsonProperty("idleTimeout")
    public Integer getIdleTimeout() {
        return idleTimeout;
    }

    /**
     *
     * @param idleTimeout
     * The idleTimeout
     */
    @JsonProperty("idleTimeout")
    public void setIdleTimeout(Integer idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public JsUnitTest withIdleTimeout(Integer idleTimeout) {
        this.idleTimeout = idleTimeout;
        return this;
    }

    /**
     *
     * @return
     * The maxDuration
     */
    @JsonProperty("maxDuration")
    public Integer getMaxDuration() {
        return maxDuration;
    }

    /**
     *
     * @param maxDuration
     * The maxDuration
     */
    @JsonProperty("maxDuration")
    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public JsUnitTest withMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
        return this;
    }

    /**
     *
     * @return
     * The prerun
     */
    @JsonProperty("prerun")
    public String getPrerun() {
        return prerun;
    }

    /**
     *
     * @param prerun
     * The prerun
     */
    @JsonProperty("prerun")
    public void setPrerun(String prerun) {
        this.prerun = prerun;
    }

    public JsUnitTest withPrerun(String prerun) {
        this.prerun = prerun;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(platforms).append(url).append(framework).append(tunnel).append(parentTunnel).append(commandTimeout).append(idleTimeout).append(maxDuration).append(prerun).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof JsUnitTest) == false) {
            return false;
        }
        JsUnitTest rhs = ((JsUnitTest) other);
        return new EqualsBuilder().append(platforms, rhs.platforms).append(url, rhs.url).append(framework, rhs.framework).append(tunnel, rhs.tunnel).append(parentTunnel, rhs.parentTunnel).append(commandTimeout, rhs.commandTimeout).append(idleTimeout, rhs.idleTimeout).append(maxDuration, rhs.maxDuration).append(prerun, rhs.prerun).isEquals();
    }

}