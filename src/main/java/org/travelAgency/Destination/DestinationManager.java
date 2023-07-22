package org.travelAgency.Destination;

import java.util.HashMap;
import java.util.Map;

public class DestinationManager {
    private static Map<String, Destination> destinationMonitor = new HashMap<>();
    public static Destination spinUpActivityOrReturnExisting(Destination destination) {
        if (destinationMonitor.containsKey(destination.getName())) {
            return destinationMonitor.get(destination.getName());
        }
        destinationMonitor.put(destination.getName(), new Destination(destination));
        return destinationMonitor.get(destination.getName());
    }
    /**TODO
     * REMOVE DESTINATION
     * STEP 1) From Destination remove Travel Package
     * STEP 2) Iterate through list of activities and call remove Activity function
     * STEP 3) Remove Destination key from destinationMonitor
     * */
}
