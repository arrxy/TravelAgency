package org.travelAgency.Destination;

import org.travelAgency.Activity.Activity;
import org.travelAgency.Activity.ActivityManager;

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
            this.activityList.add(ActivityManager.spinUpActivityOrReturnExisting(activity));
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

    public void print() {
        System.out.println("Destination Name : " + this.getName());
        for (Activity activity: this.getActivityList()) {
            activity.print();
        }
    }
}
