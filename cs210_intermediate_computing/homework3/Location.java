package edu.umb.cs210.p3;

import stdlib.StdOut;

import java.util.Arrays;

// An immutable type representing a location on Earth.
public class Location implements Comparable<Location> {
    private final String loc; // location name
    private final double lat; // latitude
    private final double lon; // longitude

    // Construct a new location given its name, latitude, and
    // longitude.
    public Location(String loc, double lat, double lon) {
        this.loc = loc;
        this.lat = lat;
        this.lon = lon;
    }

    // The great-circle distance between this location and that.
    public double distanceTo(Location that) {
        double distance = (Math.toDegrees(111)) *
                (Math.acos(Math.sin(Math.toRadians(this.lat))
                * Math.sin(Math.toRadians(that.lat)) +
                Math.cos(Math.toRadians(this.lat)) *
                        Math.cos(Math.toRadians(that.lat)) *
                        Math.cos(Math.toRadians(this.lon) -
                                Math.toRadians(that.lon))));
        return  distance;
    }

    // Is this location the same as that?
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null) return false;
        if (this.getClass() != that.getClass()) return false;
        Location thatLocation = (Location) that;

        if (this.lat == thatLocation.lat && this.lon == thatLocation.lon)
        {
            return true;
        }
        return false;
    }

    // -1, 0, or 1 depending on whether the distance of this 
    // location to the origin (Parthenon, Athens, Greece @
    // 37.971525, 23.726726) is less than, equal to, or greater
    // than the distance of that location to the origin.
    public int compareTo(Location that) {
        Location origin = new Location("Parthenon, Athens, Greece",
                37.971525, 23.726726);
        double thisOrigin = this.distanceTo(origin);
        double thatOrigin = that.distanceTo(origin);

        if (Double.compare(thisOrigin, thatOrigin) == -1)
        {
            return -1;
        }
        else if (Double.compare(thisOrigin, thatOrigin) == 0)
        {
            return 0;
        }
        return 1;
    }

    // A string representation of the location, in
    // "loc (lat, lon)" format.
    public String toString() {
        String location = loc + " (" + lat + ", " + lon + ")";
        return location;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int rank = Integer.parseInt(args[0]);
        double lat = Double.parseDouble(args[1]);
        double lon = Double.parseDouble(args[2]);        
        Location[] wonders = new Location[7];
        wonders[0] = new Location("The Great Wall of China (China)", 
                                  40.6769, 117.2319);
        wonders[1] = new Location("Petra (Jordan)", 30.3286, 35.4419);
        wonders[2] = new Location("The Colosseum (Italy)", 41.8902, 12.4923);
        wonders[3] = new Location("Chichen Itza (Mexico)", 20.6829, -88.5686);
        wonders[4] = new Location("Machu Picchu (Peru)", -13.1633, -72.5456);
        wonders[5] = new Location("Taj Mahal (India)", 27.1750, 78.0419);
        wonders[6] = new Location("Christ the Redeemer (Brazil)",
                                  22.9519, -43.2106);
        Arrays.sort(wonders);
        for (Location wonder : wonders) {
            StdOut.println(wonder);
        }
        Location loc = new Location("", lat, lon);
        StdOut.println(wonders[rank].equals(loc));
    }
}
