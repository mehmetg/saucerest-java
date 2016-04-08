package com.saucelabs.saucerest.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.saucelabs.saucerest.deserializers.UnixtimeDeserializer;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Concurrency implements Serializable {

    public static class SubAccountConcurrencyValues implements Serializable {
        @JsonProperty("current")
        private ConcurrencyValues current;

        @JsonProperty("remaining")
        private ConcurrencyValues remaining;

        public ConcurrencyValues getCurrent() {
            return current;
        }

        public void setCurrent(ConcurrencyValues current) {
            this.current = current;
        }

        public ConcurrencyValues getRemaining() {
            return remaining;
        }

        public void setRemaining(ConcurrencyValues remaining) {
            this.remaining = remaining;
        }
    }

    public static class ConcurrencyValues implements Serializable {
        @JsonProperty("overall")
        private int overall;

        @JsonProperty("mac")
        private int mac;

        @JsonProperty("manual")
        private int manual;

        public int getOverall() {—
            return overall;
        }

        public void setOverall(int overall) {
            this.overall = overall;
        }

        public int getMac() {
            return mac;
        }

        public void setMac(int mac) {
            this.mac = mac;
        }

        public int getManual() {
            return manual;
        }

        public void setManual(int manual) {
            this.manual = manual;
        }
    }

    @JsonProperty("timestamp")
    @JsonDeserialize(using = UnixtimeDeserializer.class)
    private Date timeStamp;

    @JsonProperty("concurrency")
    private HashMap<String, SubAccountConcurrencyValues> subAccounts;

    public Date getTimestamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timestamp) {
        this.timeStamp = timestamp;
    }

    public HashMap<String, SubAccountConcurrencyValues> getSubAccounts() {
        return subAccounts;
    }

    public void setSubaccounts(HashMap<String, SubAccountConcurrencyValues> subAccounts) {
        this.subAccounts = subAccounts;
    }
}
