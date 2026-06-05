package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.constant.Zone;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Station {
    private String name;
    private Set<Zone> zones;
}
=======
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
>>>>>>> sprint-1
