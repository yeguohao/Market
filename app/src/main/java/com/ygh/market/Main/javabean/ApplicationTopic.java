package com.ygh.market.Main.javabean;

import java.util.List;

public class ApplicationTopic {

    private String topicTitle;
    private int topicID;
    private List<ApplicationSynopsis> applications;

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public int getTopicID() {
        return topicID;
    }

    public void setTopicID(int topicID) {
        this.topicID = topicID;
    }

    public List<ApplicationSynopsis> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationSynopsis> applications) {
        this.applications = applications;
    }
}
