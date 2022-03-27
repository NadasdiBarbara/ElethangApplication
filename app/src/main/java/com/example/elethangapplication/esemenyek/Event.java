package com.example.elethangapplication.esemenyek;

import com.google.gson.annotations.SerializedName;



public class Event {

    @SerializedName("event_name")
    public String eventName;
    @SerializedName("description")
    public String eventDescription;
    @SerializedName("date")
    public String eventDate;


    public Event(String event_name, String eventDate, String eventDescription) {
        this.eventName = event_name;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
    }
    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }
    public String getEvent_name() {
        return eventName;
    }

    public void setEvent_name(String event_name) {
        this.eventName = event_name;
    }


    public String getDescription() {
        return eventDescription;
    }

    public void setDescription(String description) {
        this.eventDescription = description;
    }
}
