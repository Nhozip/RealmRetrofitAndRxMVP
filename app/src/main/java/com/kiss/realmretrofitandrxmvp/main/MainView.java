package com.kiss.realmretrofitandrxmvp.main;

import com.kiss.realmretrofitandrxmvp.model.GitHubUser;

import java.util.List;

/**
 * Created by Admins on 7/30/2017.
 */

public interface MainView {
    void displayData(List<GitHubUser> gitHubUserList);

    void showMes(String s);

    void showProscee();

    void hideProcess();
}
