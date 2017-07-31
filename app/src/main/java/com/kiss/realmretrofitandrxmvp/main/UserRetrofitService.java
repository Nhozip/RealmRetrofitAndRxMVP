package com.kiss.realmretrofitandrxmvp.main;

import com.kiss.realmretrofitandrxmvp.model.GitHubUser;
import com.kiss.realmretrofitandrxmvp.utils.Constans;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Admins on 7/30/2017.
 */

public interface UserRetrofitService {
    @GET(Constans.API_AUTH)
    Observable<Response<List<GitHubUser>>> getListUser();
}
