package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.constant.Zone;
import java.util.Set;

public class Station {
    private String name;
    private Set<Zone> zones;


    public Station(String name, Set<Zone> zones) {
        this.name = name;
        this.zones = zones;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Zone> getZones() { return zones; }
    public void setZones(Set<Zone> zones) { this.zones = zones; }
}