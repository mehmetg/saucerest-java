package com.saucelabs.saucerest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;

public class Activity implements Serializable {
    public static class ActivityStats implements Serializable {

        @JsonProperty("in progress")
        private int in_progress;

        @JsonProperty("all")
        private int all;

        @JsonProperty("queued")
        private int queued;

        public int getIn_progress() {
            return in_progress;
        }

        public void setIn_progress(int in_progress) {
            this.in_progress = in_progress;
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
    private HashMap<String, ActivityStats> subaccounts;

    @JsonProperty("totals")
    private ActivityStats totals;

    public HashMap<String, ActivityStats> getSubaccounts() {
        return subaccounts;
    }

    public void setSubaccounts(HashMap<String, ActivityStats> subaccounts) {
        this.subaccounts = subaccounts;
    }

    public ActivityStats getTotals() {
        return totals;
    }

    public void setTotals(ActivityStats totals) {
        this.totals = totals;
    }
}
