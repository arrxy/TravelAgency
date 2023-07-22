package org.travelAgency.Activity;

import org.travelAgency.Destination.Destination;
import org.travelAgency.Destination.DestinationManager;

import java.util.HashMap;
import java.util.Map;

public class ActivityManager {
    private static Map<String, Activity> activityMonitor = new HashMap<>();
    public static Activity spinUpActivityOrReturnExisting(Activity activity) {
        if (activityMonitor.containsKey(activity.getName())) {
            return activityMonitor.get(activity.getName());
        }
        activityMonitor.put(activity.getName(), new Activity(activity));
        return activityMonitor.get(activity.getName());
    }

    /**TODO
     * REMOVE ACTIVITY
     * STEP 1) From Destination remove Activity
     * STEP 2) From activityMonitor remove Activity Key
     * */
}
