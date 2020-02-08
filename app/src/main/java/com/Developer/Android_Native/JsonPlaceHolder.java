package com.Developer.Android_Native;

import com.Developer.Android_Native.model.Comments;
import com.Developer.Android_Native.model.DataModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<DataModel>> getData();

    @GET("posts/{id}/comments")
    Call<List<Comments>> getCommentsData(@Path("id") int postId);

    @GET("posts")
    Call<List<DataModel>> getQueryData(
            @Query("_sort") String sort,
            @Query("_order") String order,
            @Query("userId") Integer... userId// USing java VArargs method of Java..
    );

    @GET("posts")
    Call<List<DataModel>> getQueryMapData(
            @QueryMap Map<String,String>  parameters);
}
