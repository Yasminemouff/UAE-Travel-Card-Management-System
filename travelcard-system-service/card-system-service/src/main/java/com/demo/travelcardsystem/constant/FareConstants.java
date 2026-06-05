package com.demo.travelcardsystem.constant;

public final class FareConstants {

    // Maximum fare charged as initial hold on tap-in (AED)
    public static final double MAX_FARE = 7.00;

    // Individual zone fare amounts (AED)
    public static final double FARE_ANY_WHERE_IN_ZONE_ONE = 2.50;
    public static final double FARE_ANY_ONE_ZONE_OUTSIDE_ZONE_ONE = 2.00;
    public static final double FARE_ANY_TWO_ZONE_INCLUDING_ZONE_ONE = 3.00;
    public static final double FARE_ANY_TWO_ZONE_EXCLUDING_ZONE_ONE = 2.25;
    public static final double FARE_ANY_THREE_ZONE = MAX_FARE;
    public static final double FARE_ANY_JOURNEY_BY_BUS = 1.80;

    // Prevent instantiation
    private FareConstants() {}
}