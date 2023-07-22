package org.example.Destination;

import org.example.Activity.Activity;
import org.example.Activity.ActivityFactory;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;

    private List<Activity> activityList;

    public Destination(String name, List<Activity> activityList) {
        this.name = name;
        this.activityList = activityList;
    }
    public Destination (Destination d) {
        this.name = d.getName();
        this.activityList = new ArrayList<>();
        for (Activity activity: d.getActivityList()) {
            this.activityList.add(ActivityFactory.spinUpActivityOrReturnExisting(activity));
        }
    }
    public String getName() {
        return name;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

}
