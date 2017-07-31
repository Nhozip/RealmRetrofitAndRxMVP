package com.kiss.realmretrofitandrxmvp.main;

import com.kiss.realmretrofitandrxmvp.model.GitHubUser;
import com.kiss.realmretrofitandrxmvp.utils.Constans;
import com.kiss.realmretrofitandrxmvp.utils.RetrofitUtils;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Admins on 7/30/2017.
 */

public class MainInteractorImpl implements MainInteractor {


    @Override
    public Observable<Response<List<GitHubUser>>> getListUserInteractor() {
        return RetrofitUtils.create(Constans.URL, UserRetrofitService.class).getListUser();
    }
}
