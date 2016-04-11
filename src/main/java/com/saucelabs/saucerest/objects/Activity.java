package com.saucelabs.saucerest.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;

public class Activity implements Serializable {
    public static class ActivityStats implements Serializable {

        @JsonProperty("in progress")
        private int inProgress;

        @JsonProperty("all")
        private int all;

        @JsonProperty("queued")
        private int queued;

        public int getInProgress() {
            return inProgress;
        }

        public void setInProgress(int inProgress) {
            this.inProgress = inProgress;
        }

        public int getAll() {
            return all;
        }

        public void setAll(int all) {
            this.all = all;
        }

        public int getQueued() {
            return queued;
        }

        public void setQueued(int queued) {
            this.queued = queued;
        }
    }

    @JsonProperty("subaccounts")
    private HashMap<String, ActivityStats> subAccounts;

    @JsonProperty("totals")
    private ActivityStats totals;

    public HashMap<String, ActivityStats> getSubAccounts() {
        return subAccounts;
    }

    public void setSubAccounts(HashMap<String, ActivityStats> subAccounts) {
        this.subAccounts = subAccounts;
    }

    public ActivityStats getTotals() {
        return totals;
    }

    public void setTotals(ActivityStats totals) {
        this.totals = totals;
    }
}
