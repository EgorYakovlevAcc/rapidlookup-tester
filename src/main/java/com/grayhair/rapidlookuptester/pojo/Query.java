package com.grayhair.rapidlookuptester.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Query {
    private String name;
    private String city;
    @JsonProperty("first_mail_date")
    private String firstMailDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstMailDate() {
        return firstMailDate;
    }

    public void setFirstMailDate(String firstMailDate) {
        this.firstMailDate = firstMailDate;
    }
}
