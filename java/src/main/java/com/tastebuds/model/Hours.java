package com.tastebuds.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hours {

    @JsonIgnoreProperties(ignoreUnknown = true)

    private List<Open> open;
    @JsonProperty("hours_type")
    private String hoursType;
    @JsonProperty("is_open_now")
    private boolean isOpenNow;

    public List<Open> getOpen() {
        return open;
    }

    public void setOpen(List<Open> open) {
        this.open = open;
    }

    public String getHoursType() {
        return hoursType;
    }

    public void setHoursType(String hoursType) {
        this.hoursType = hoursType;
    }

    public boolean isOpenNow() {
        return isOpenNow;
    }

    public void setOpenNow(boolean openNow) {
        isOpenNow = openNow;
    }
}
