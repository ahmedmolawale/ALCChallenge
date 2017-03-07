package com.alc.alcchallenge.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ahmed on 05/03/2017.
 */

public class User {

    //This helps to serialised the JSON item received into a java object

    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private int id;

    @SerializedName("avatar_url")
    private String avatar_url;

    @SerializedName("gravatar_id")
    private String gravatar_id;

    @SerializedName("url")
    private String url;

    @SerializedName("html_url")
    private String html_url;

    @SerializedName("followers_url")
    private String followers_url;

    @SerializedName("following_url")
    private String following_url;

    @SerializedName("gists_url")
    private String gists_url;

    @SerializedName("starred_url")
    private String starred_url;

    @SerializedName("subscriptions_url")
    private String subscriptions_url;

    @SerializedName("organizations_url")
    private String organizations_url;

    @SerializedName("repos_url")
    private String repos_url;

    @SerializedName("events_url")
    private String events_url;

    @SerializedName("received_events_url")
    private String received_events_url;

    @SerializedName("type")
    private String type;

    @SerializedName("site_admin")
    private boolean site_admin;

    @SerializedName("score")
    private double score;

    public User(String login, int id, String avatar_url, String gravatar_id, String url,
                String html_url, String followers_url, String following_url, String gists_url, String starred_url,
                String subscriptions_url, String organizations_url, String repos_url, String events_url,
                String received_events_url, String type, boolean site_admin, double score) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.html_url = html_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.starred_url = starred_url;
        this.subscriptions_url = subscriptions_url;
        this.organizations_url = organizations_url;
        this.repos_url = repos_url;
        this.events_url = events_url;
        this.received_events_url = received_events_url;
        this.type = type;
        this.site_admin = site_admin;
        this.score = score;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
