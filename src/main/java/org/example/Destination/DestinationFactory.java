package org.example.Destination;

import org.example.Activity.Activity;

import java.util.HashMap;
import java.util.Map;

public class DestinationFactory {
    private static Map<String, Destination> destinationMonitor = new HashMap<>();
    public static Destination spinUpActivityOrReturnExisting(Destination destination) {
        if (destinationMonitor.containsKey(destination.getName())) {
            return destinationMonitor.get(destination.getName());
        }
        destinationMonitor.put(destination.getName(), new Destination(destination));
        return destinationMonitor.get(destination.getName());
    }
}
