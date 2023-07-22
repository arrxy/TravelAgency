package org.travelAgency.Activity;

import java.util.HashMap;
import java.util.Map;

public class ActivityFactory {
    private static Map<String, Activity> activityMonitor = new HashMap<>();
    public static Activity spinUpActivityOrReturnExisting(Activity activity) {
        if (activityMonitor.containsKey(activity.getName())) {
            return activityMonitor.get(activity.getName());
        }
        activityMonitor.put(activity.getName(), new Activity(activity));
        return activityMonitor.get(activity.getName());
    }
}
