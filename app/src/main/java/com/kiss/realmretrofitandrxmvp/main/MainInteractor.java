package com.kiss.realmretrofitandrxmvp.main;

import com.kiss.realmretrofitandrxmvp.model.GitHubUser;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by Admins on 7/30/2017.
 */

public interface MainInteractor {
    Observable<Response<List<GitHubUser>>> getListUserInteractor();
}
