
package com.saucelabs.saucerest.models.rx;

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
    "short_version",
    "long_name",
    "api_name",
    "long_version",
    "device",
    "latest_stable_version",
    "automation_backend",
    "os",
    "deprecated_backend_versions",
    "recommended_backend_version",
    "supported_backend_versions"
})
public class SupportedPlatform {

    @JsonProperty("short_version")
    private String shortVersion;
    @JsonProperty("long_name")
    private String longName;
    @JsonProperty("api_name")
    private String apiName;
    @JsonProperty("long_version")
    private String longVersion;
    @JsonProperty("device")
    private String device;
    @JsonProperty("latest_stable_version")
    private String latestStableVersion;
    @JsonProperty("automation_backend")
    private String automationBackend;
    @JsonProperty("os")
    private String os;
    @JsonProperty("deprecated_backend_versions")
    private List<String> deprecatedBackendVersions = new ArrayList<String>();
    @JsonProperty("recommended_backend_version")
    private String recommendedBackendVersion;
    @JsonProperty("supported_backend_versions")
    private List<String> supportedBackendVersions = new ArrayList<String>();

    /**
     * 
     * @return
     *     The shortVersion
     */
    @JsonProperty("short_version")
    public String getShortVersion() {
        return shortVersion;
    }

    /**
     * 
     * @param shortVersion
     *     The short_version
     */
    @JsonProperty("short_version")
    public void setShortVersion(String shortVersion) {
        this.shortVersion = shortVersion;
    }

    public SupportedPlatform withShortVersion(String shortVersion) {
        this.shortVersion = shortVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The longName
     */
    @JsonProperty("long_name")
    public String getLongName() {
        return longName;
    }

    /**
     * 
     * @param longName
     *     The long_name
     */
    @JsonProperty("long_name")
    public void setLongName(String longName) {
        this.longName = longName;
    }

    public SupportedPlatform withLongName(String longName) {
        this.longName = longName;
        return this;
    }

    /**
     * 
     * @return
     *     The apiName
     */
    @JsonProperty("api_name")
    public String getApiName() {
        return apiName;
    }

    /**
     * 
     * @param apiName
     *     The api_name
     */
    @JsonProperty("api_name")
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public SupportedPlatform withApiName(String apiName) {
        this.apiName = apiName;
        return this;
    }

    /**
     * 
     * @return
     *     The longVersion
     */
    @JsonProperty("long_version")
    public String getLongVersion() {
        return longVersion;
    }

    /**
     * 
     * @param longVersion
     *     The long_version
     */
    @JsonProperty("long_version")
    public void setLongVersion(String longVersion) {
        this.longVersion = longVersion;
    }

    public SupportedPlatform withLongVersion(String longVersion) {
        this.longVersion = longVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The device
     */
    @JsonProperty("device")
    public String getDevice() {
        return device;
    }

    /**
     * 
     * @param device
     *     The device
     */
    @JsonProperty("device")
    public void setDevice(String device) {
        this.device = device;
    }

    public SupportedPlatform withDevice(String device) {
        this.device = device;
        return this;
    }

    /**
     * 
     * @return
     *     The latestStableVersion
     */
    @JsonProperty("latest_stable_version")
    public String getLatestStableVersion() {
        return latestStableVersion;
    }

    /**
     * 
     * @param latestStableVersion
     *     The latest_stable_version
     */
    @JsonProperty("latest_stable_version")
    public void setLatestStableVersion(String latestStableVersion) {
        this.latestStableVersion = latestStableVersion;
    }

    public SupportedPlatform withLatestStableVersion(String latestStableVersion) {
        this.latestStableVersion = latestStableVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The automationBackend
     */
    @JsonProperty("automation_backend")
    public String getAutomationBackend() {
        return automationBackend;
    }

    /**
     * 
     * @param automationBackend
     *     The automation_backend
     */
    @JsonProperty("automation_backend")
    public void setAutomationBackend(String automationBackend) {
        this.automationBackend = automationBackend;
    }

    public SupportedPlatform withAutomationBackend(String automationBackend) {
        this.automationBackend = automationBackend;
        return this;
    }

    /**
     * 
     * @return
     *     The os
     */
    @JsonProperty("os")
    public String getOs() {
        return os;
    }

    /**
     * 
     * @param os
     *     The os
     */
    @JsonProperty("os")
    public void setOs(String os) {
        this.os = os;
    }

    public SupportedPlatform withOs(String os) {
        this.os = os;
        return this;
    }

    /**
     * 
     * @return
     *     The deprecatedBackendVersions
     */
    @JsonProperty("deprecated_backend_versions")
    public List<String> getDeprecatedBackendVersions() {
        return deprecatedBackendVersions;
    }

    /**
     * 
     * @param deprecatedBackendVersions
     *     The deprecated_backend_versions
     */
    @JsonProperty("deprecated_backend_versions")
    public void setDeprecatedBackendVersions(List<String> deprecatedBackendVersions) {
        this.deprecatedBackendVersions = deprecatedBackendVersions;
    }

    public SupportedPlatform withDeprecatedBackendVersions(List<String> deprecatedBackendVersions) {
        this.deprecatedBackendVersions = deprecatedBackendVersions;
        return this;
    }

    /**
     * 
     * @return
     *     The recommendedBackendVersion
     */
    @JsonProperty("recommended_backend_version")
    public String getRecommendedBackendVersion() {
        return recommendedBackendVersion;
    }

    /**
     * 
     * @param recommendedBackendVersion
     *     The recommended_backend_version
     */
    @JsonProperty("recommended_backend_version")
    public void setRecommendedBackendVersion(String recommendedBackendVersion) {
        this.recommendedBackendVersion = recommendedBackendVersion;
    }

    public SupportedPlatform withRecommendedBackendVersion(String recommendedBackendVersion) {
        this.recommendedBackendVersion = recommendedBackendVersion;
        return this;
    }

    /**
     * 
     * @return
     *     The supportedBackendVersions
     */
    @JsonProperty("supported_backend_versions")
    public List<String> getSupportedBackendVersions() {
        return supportedBackendVersions;
    }

    /**
     * 
     * @param supportedBackendVersions
     *     The supported_backend_versions
     */
    @JsonProperty("supported_backend_versions")
    public void setSupportedBackendVersions(List<String> supportedBackendVersions) {
        this.supportedBackendVersions = supportedBackendVersions;
    }

    public SupportedPlatform withSupportedBackendVersions(List<String> supportedBackendVersions) {
        this.supportedBackendVersions = supportedBackendVersions;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(shortVersion).append(longName).append(apiName).append(longVersion).append(device).append(latestStableVersion).append(automationBackend).append(os).append(deprecatedBackendVersions).append(recommendedBackendVersion).append(supportedBackendVersions).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SupportedPlatform) == false) {
            return false;
        }
        SupportedPlatform rhs = ((SupportedPlatform) other);
        return new EqualsBuilder().append(shortVersion, rhs.shortVersion).append(longName, rhs.longName).append(apiName, rhs.apiName).append(longVersion, rhs.longVersion).append(device, rhs.device).append(latestStableVersion, rhs.latestStableVersion).append(automationBackend, rhs.automationBackend).append(os, rhs.os).append(deprecatedBackendVersions, rhs.deprecatedBackendVersions).append(recommendedBackendVersion, rhs.recommendedBackendVersion).append(supportedBackendVersions, rhs.supportedBackendVersions).isEquals();
    }

}
