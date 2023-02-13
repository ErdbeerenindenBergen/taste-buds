package com.tastebuds.model;

import java.util.Arrays;

public class BusinessLocation {

    private String[] display_address;

    public String[] getDisplay_address() {
        return display_address;
    }

    public void setDisplay_address(String[] display_address) {
        this.display_address = display_address;
    }

    @Override
    public String toString() {
        return Arrays.toString(display_address);
    }



}
