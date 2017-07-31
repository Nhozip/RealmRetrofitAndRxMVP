package com.kiss.realmretrofitandrxmvp.model;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Admins on 7/30/2017.
 */

public class GitHubUser extends RealmObject {

    private String login;
    @PrimaryKey
    private int id;
    private String avatar_url;

    public GitHubUser() {
    }
    public GitHubUser getGitHubUser() {
        return gitHubUser;
    }

    public void setGitHubUser(GitHubUser gitHubUser) {
        this.gitHubUser = gitHubUser;
    }

    GitHubUser gitHubUser;

    public GitHubUser(int id, String login, String avatar_url) {
        this.id = id;
        this.login = login;
        this.avatar_url = avatar_url;
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

    @Override
    public String toString() {
        return "GitHubUser{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}