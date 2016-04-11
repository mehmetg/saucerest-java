
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
    "users_total",
    "users"
})
public class SauceSubUsers {

    @JsonProperty("users_total")
    private Integer usersTotal;
    @JsonProperty("users")
    private List<User> users = new ArrayList<User>();

    /**
     * 
     * @return
     *     The usersTotal
     */
    @JsonProperty("users_total")
    public Integer getUsersTotal() {
        return usersTotal;
    }

    /**
     * 
     * @param usersTotal
     *     The users_total
     */
    @JsonProperty("users_total")
    public void setUsersTotal(Integer usersTotal) {
        this.usersTotal = usersTotal;
    }

    public SauceSubUsers withUsersTotal(Integer usersTotal) {
        this.usersTotal = usersTotal;
        return this;
    }

    /**
     * 
     * @return
     *     The users
     */
    @JsonProperty("users")
    public List<User> getUsers() {
        return users;
    }

    /**
     * 
     * @param users
     *     The users
     */
    @JsonProperty("users")
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public SauceSubUsers withUsers(List<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(usersTotal).append(users).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SauceSubUsers) == false) {
            return false;
        }
        SauceSubUsers rhs = ((SauceSubUsers) other);
        return new EqualsBuilder().append(usersTotal, rhs.usersTotal).append(users, rhs.users).isEquals();
    }

}
