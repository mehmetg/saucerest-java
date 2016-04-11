
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
    "domain",
    "last_name",
    "children_count",
    "creation_time",
    "user_type",
    "concurrency_limit",
    "manual_minutes",
    "can_run_manual",
    "prevent_emails",
    "id",
    "first_name",
    "verified",
    "subscribed",
    "title",
    "ancestor_allows_subaccounts",
    "ancestor",
    "email",
    "username",
    "vm_lockdown",
    "parent",
    "is_admin",
    "is_public",
    "access_key",
    "name",
    "is_sso",
    "entity_type",
    "ancestor_concurrency_limit",
    "minutes"
})
public class User {

    @JsonProperty("domain")
    private Object domain;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("children_count")
    private Integer childrenCount;
    @JsonProperty("creation_time")
    private Integer creationTime;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("concurrency_limit")
    private ConcurrencyLimit concurrencyLimit;
    @JsonProperty("manual_minutes")
    private String manualMinutes;
    @JsonProperty("can_run_manual")
    private Boolean canRunManual;
    @JsonProperty("prevent_emails")
    private List<Object> preventEmails = new ArrayList<Object>();
    @JsonProperty("id")
    private String id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("verified")
    private Boolean verified;
    @JsonProperty("subscribed")
    private Boolean subscribed;
    @JsonProperty("title")
    private Object title;
    @JsonProperty("ancestor_allows_subaccounts")
    private Boolean ancestorAllowsSubaccounts;
    @JsonProperty("ancestor")
    private String ancestor;
    @JsonProperty("email")
    private String email;
    @JsonProperty("username")
    private String username;
    @JsonProperty("vm_lockdown")
    private Boolean vmLockdown;
    @JsonProperty("parent")
    private String parent;
    @JsonProperty("is_admin")
    private Object isAdmin;
    @JsonProperty("is_public")
    private Boolean isPublic;
    @JsonProperty("access_key")
    private String accessKey;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_sso")
    private Boolean isSso;
    @JsonProperty("entity_type")
    private String entityType;
    @JsonProperty("ancestor_concurrency_limit")
    private AncestorConcurrencyLimit ancestorConcurrencyLimit;
    @JsonProperty("minutes")
    private String minutes;

    /**
     * 
     * @return
     *     The domain
     */
    @JsonProperty("domain")
    public Object getDomain() {
        return domain;
    }

    /**
     * 
     * @param domain
     *     The domain
     */
    @JsonProperty("domain")
    public void setDomain(Object domain) {
        this.domain = domain;
    }

    public User withDomain(Object domain) {
        this.domain = domain;
        return this;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * 
     * @return
     *     The childrenCount
     */
    @JsonProperty("children_count")
    public Integer getChildrenCount() {
        return childrenCount;
    }

    /**
     * 
     * @param childrenCount
     *     The children_count
     */
    @JsonProperty("children_count")
    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public User withChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
        return this;
    }

    /**
     * 
     * @return
     *     The creationTime
     */
    @JsonProperty("creation_time")
    public Integer getCreationTime() {
        return creationTime;
    }

    /**
     * 
     * @param creationTime
     *     The creation_time
     */
    @JsonProperty("creation_time")
    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    public User withCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    /**
     * 
     * @return
     *     The userType
     */
    @JsonProperty("user_type")
    public String getUserType() {
        return userType;
    }

    /**
     * 
     * @param userType
     *     The user_type
     */
    @JsonProperty("user_type")
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public User withUserType(String userType) {
        this.userType = userType;
        return this;
    }

    /**
     * 
     * @return
     *     The concurrencyLimit
     */
    @JsonProperty("concurrency_limit")
    public ConcurrencyLimit getConcurrencyLimit() {
        return concurrencyLimit;
    }

    /**
     * 
     * @param concurrencyLimit
     *     The concurrency_limit
     */
    @JsonProperty("concurrency_limit")
    public void setConcurrencyLimit(ConcurrencyLimit concurrencyLimit) {
        this.concurrencyLimit = concurrencyLimit;
    }

    public User withConcurrencyLimit(ConcurrencyLimit concurrencyLimit) {
        this.concurrencyLimit = concurrencyLimit;
        return this;
    }

    /**
     * 
     * @return
     *     The manualMinutes
     */
    @JsonProperty("manual_minutes")
    public String getManualMinutes() {
        return manualMinutes;
    }

    /**
     * 
     * @param manualMinutes
     *     The manual_minutes
     */
    @JsonProperty("manual_minutes")
    public void setManualMinutes(String manualMinutes) {
        this.manualMinutes = manualMinutes;
    }

    public User withManualMinutes(String manualMinutes) {
        this.manualMinutes = manualMinutes;
        return this;
    }

    /**
     * 
     * @return
     *     The canRunManual
     */
    @JsonProperty("can_run_manual")
    public Boolean getCanRunManual() {
        return canRunManual;
    }

    /**
     * 
     * @param canRunManual
     *     The can_run_manual
     */
    @JsonProperty("can_run_manual")
    public void setCanRunManual(Boolean canRunManual) {
        this.canRunManual = canRunManual;
    }

    public User withCanRunManual(Boolean canRunManual) {
        this.canRunManual = canRunManual;
        return this;
    }

    /**
     * 
     * @return
     *     The preventEmails
     */
    @JsonProperty("prevent_emails")
    public List<Object> getPreventEmails() {
        return preventEmails;
    }

    /**
     * 
     * @param preventEmails
     *     The prevent_emails
     */
    @JsonProperty("prevent_emails")
    public void setPreventEmails(List<Object> preventEmails) {
        this.preventEmails = preventEmails;
    }

    public User withPreventEmails(List<Object> preventEmails) {
        this.preventEmails = preventEmails;
        return this;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public User withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * 
     * @return
     *     The verified
     */
    @JsonProperty("verified")
    public Boolean getVerified() {
        return verified;
    }

    /**
     * 
     * @param verified
     *     The verified
     */
    @JsonProperty("verified")
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public User withVerified(Boolean verified) {
        this.verified = verified;
        return this;
    }

    /**
     * 
     * @return
     *     The subscribed
     */
    @JsonProperty("subscribed")
    public Boolean getSubscribed() {
        return subscribed;
    }

    /**
     * 
     * @param subscribed
     *     The subscribed
     */
    @JsonProperty("subscribed")
    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public User withSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
        return this;
    }

    /**
     * 
     * @return
     *     The title
     */
    @JsonProperty("title")
    public Object getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(Object title) {
        this.title = title;
    }

    public User withTitle(Object title) {
        this.title = title;
        return this;
    }

    /**
     * 
     * @return
     *     The ancestorAllowsSubaccounts
     */
    @JsonProperty("ancestor_allows_subaccounts")
    public Boolean getAncestorAllowsSubaccounts() {
        return ancestorAllowsSubaccounts;
    }

    /**
     * 
     * @param ancestorAllowsSubaccounts
     *     The ancestor_allows_subaccounts
     */
    @JsonProperty("ancestor_allows_subaccounts")
    public void setAncestorAllowsSubaccounts(Boolean ancestorAllowsSubaccounts) {
        this.ancestorAllowsSubaccounts = ancestorAllowsSubaccounts;
    }

    public User withAncestorAllowsSubaccounts(Boolean ancestorAllowsSubaccounts) {
        this.ancestorAllowsSubaccounts = ancestorAllowsSubaccounts;
        return this;
    }

    /**
     * 
     * @return
     *     The ancestor
     */
    @JsonProperty("ancestor")
    public String getAncestor() {
        return ancestor;
    }

    /**
     * 
     * @param ancestor
     *     The ancestor
     */
    @JsonProperty("ancestor")
    public void setAncestor(String ancestor) {
        this.ancestor = ancestor;
    }

    public User withAncestor(String ancestor) {
        this.ancestor = ancestor;
        return this;
    }

    /**
     * 
     * @return
     *     The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

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

    public User withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * 
     * @return
     *     The vmLockdown
     */
    @JsonProperty("vm_lockdown")
    public Boolean getVmLockdown() {
        return vmLockdown;
    }

    /**
     * 
     * @param vmLockdown
     *     The vm_lockdown
     */
    @JsonProperty("vm_lockdown")
    public void setVmLockdown(Boolean vmLockdown) {
        this.vmLockdown = vmLockdown;
    }

    public User withVmLockdown(Boolean vmLockdown) {
        this.vmLockdown = vmLockdown;
        return this;
    }

    /**
     * 
     * @return
     *     The parent
     */
    @JsonProperty("parent")
    public String getParent() {
        return parent;
    }

    /**
     * 
     * @param parent
     *     The parent
     */
    @JsonProperty("parent")
    public void setParent(String parent) {
        this.parent = parent;
    }

    public User withParent(String parent) {
        this.parent = parent;
        return this;
    }

    /**
     * 
     * @return
     *     The isAdmin
     */
    @JsonProperty("is_admin")
    public Object getIsAdmin() {
        return isAdmin;
    }

    /**
     * 
     * @param isAdmin
     *     The is_admin
     */
    @JsonProperty("is_admin")
    public void setIsAdmin(Object isAdmin) {
        this.isAdmin = isAdmin;
    }

    public User withIsAdmin(Object isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    /**
     * 
     * @return
     *     The isPublic
     */
    @JsonProperty("is_public")
    public Boolean getIsPublic() {
        return isPublic;
    }

    /**
     * 
     * @param isPublic
     *     The is_public
     */
    @JsonProperty("is_public")
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public User withIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
        return this;
    }

    /**
     * 
     * @return
     *     The accessKey
     */
    @JsonProperty("access_key")
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * 
     * @param accessKey
     *     The access_key
     */
    @JsonProperty("access_key")
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public User withAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public User withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The isSso
     */
    @JsonProperty("is_sso")
    public Boolean getIsSso() {
        return isSso;
    }

    /**
     * 
     * @param isSso
     *     The is_sso
     */
    @JsonProperty("is_sso")
    public void setIsSso(Boolean isSso) {
        this.isSso = isSso;
    }

    public User withIsSso(Boolean isSso) {
        this.isSso = isSso;
        return this;
    }

    /**
     * 
     * @return
     *     The entityType
     */
    @JsonProperty("entity_type")
    public String getEntityType() {
        return entityType;
    }

    /**
     * 
     * @param entityType
     *     The entity_type
     */
    @JsonProperty("entity_type")
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public User withEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    /**
     * 
     * @return
     *     The ancestorConcurrencyLimit
     */
    @JsonProperty("ancestor_concurrency_limit")
    public AncestorConcurrencyLimit getAncestorConcurrencyLimit() {
        return ancestorConcurrencyLimit;
    }

    /**
     * 
     * @param ancestorConcurrencyLimit
     *     The ancestor_concurrency_limit
     */
    @JsonProperty("ancestor_concurrency_limit")
    public void setAncestorConcurrencyLimit(AncestorConcurrencyLimit ancestorConcurrencyLimit) {
        this.ancestorConcurrencyLimit = ancestorConcurrencyLimit;
    }

    public User withAncestorConcurrencyLimit(AncestorConcurrencyLimit ancestorConcurrencyLimit) {
        this.ancestorConcurrencyLimit = ancestorConcurrencyLimit;
        return this;
    }

    /**
     * 
     * @return
     *     The minutes
     */
    @JsonProperty("minutes")
    public String getMinutes() {
        return minutes;
    }

    /**
     * 
     * @param minutes
     *     The minutes
     */
    @JsonProperty("minutes")
    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public User withMinutes(String minutes) {
        this.minutes = minutes;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(domain).append(lastName).append(childrenCount).append(creationTime).append(userType).append(concurrencyLimit).append(manualMinutes).append(canRunManual).append(preventEmails).append(id).append(firstName).append(verified).append(subscribed).append(title).append(ancestorAllowsSubaccounts).append(ancestor).append(email).append(username).append(vmLockdown).append(parent).append(isAdmin).append(isPublic).append(accessKey).append(name).append(isSso).append(entityType).append(ancestorConcurrencyLimit).append(minutes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(domain, rhs.domain).append(lastName, rhs.lastName).append(childrenCount, rhs.childrenCount).append(creationTime, rhs.creationTime).append(userType, rhs.userType).append(concurrencyLimit, rhs.concurrencyLimit).append(manualMinutes, rhs.manualMinutes).append(canRunManual, rhs.canRunManual).append(preventEmails, rhs.preventEmails).append(id, rhs.id).append(firstName, rhs.firstName).append(verified, rhs.verified).append(subscribed, rhs.subscribed).append(title, rhs.title).append(ancestorAllowsSubaccounts, rhs.ancestorAllowsSubaccounts).append(ancestor, rhs.ancestor).append(email, rhs.email).append(username, rhs.username).append(vmLockdown, rhs.vmLockdown).append(parent, rhs.parent).append(isAdmin, rhs.isAdmin).append(isPublic, rhs.isPublic).append(accessKey, rhs.accessKey).append(name, rhs.name).append(isSso, rhs.isSso).append(entityType, rhs.entityType).append(ancestorConcurrencyLimit, rhs.ancestorConcurrencyLimit).append(minutes, rhs.minutes).isEquals();
    }

}
