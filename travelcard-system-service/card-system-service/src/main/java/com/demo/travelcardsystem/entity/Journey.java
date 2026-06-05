package com.demo.travelcardsystem.entity;

import com.demo.travelcardsystem.constant.TransportType;
<<<<<<< HEAD
import lombok.Builder;
import lombok.Data;

@Data
@Builder
=======

>>>>>>> sprint-1
public class Journey {
    private Station startStation;
    private Station endStation;
    private TransportType transportType;
    private boolean journeyCompleted;
<<<<<<< HEAD
}
=======

    // Manual builder
    public static JourneyBuilder builder() { return new JourneyBuilder(); }

    public static class JourneyBuilder {
        private Station startStation;
        private Station endStation;
        private TransportType transportType;
        private boolean journeyCompleted;

        public JourneyBuilder startStation(Station s) { this.startStation = s; return this; }
        public JourneyBuilder endStation(Station s) { this.endStation = s; return this; }
        public JourneyBuilder transportType(TransportType t) { this.transportType = t; return this; }
        public JourneyBuilder journeyCompleted(boolean b) { this.journeyCompleted = b; return this; }
        public Journey build() {
            Journey j = new Journey();
            j.startStation = this.startStation;
            j.endStation = this.endStation;
            j.transportType = this.transportType;
            j.journeyCompleted = this.journeyCompleted;
            return j;
        }
    }

    public Station getStartStation() { return startStation; }
    public void setStartStation(Station s) { this.startStation = s; }
    public Station getEndStation() { return endStation; }
    public void setEndStation(Station s) { this.endStation = s; }
    public TransportType getTransportType() { return transportType; }
    public void setTransportType(TransportType t) { this.transportType = t; }
    public boolean isJourneyCompleted() { return journeyCompleted; }
    public void setJourneyCompleted(boolean b) { this.journeyCompleted = b; }
}
>>>>>>> sprint-1
