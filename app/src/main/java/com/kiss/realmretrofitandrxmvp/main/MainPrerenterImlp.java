package com.kiss.realmretrofitandrxmvp.main;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Admins on 7/30/2017.
 */

public class MainPrerenterImlp implements MainPresenter {
    private MainView mainView;
    private MainInteractor mainInteractor;
    private RealmUserUtils realmUserUtils;

    public MainPrerenterImlp(MainView mainView, RealmUserUtils realmUserUtils) {
        this.mainView = mainView;
        this.realmUserUtils = realmUserUtils;
        mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void displayData() {
        mainView.showProscee();
        mainInteractor.getListUserInteractor()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gitHubUserResponse -> {
                    mainView.displayData(gitHubUserResponse.body());
                    realmUserUtils.udapteOrInsertListUser(gitHubUserResponse.body());
                    mainView.hideProcess();
                }, throwable -> {
                    mainView.displayData(realmUserUtils.getListUser());
                    mainView.hideProcess();
                });

    }


    @Override
    public void closeReamlUser() {
        realmUserUtils.closeReaalm();
    }
}
