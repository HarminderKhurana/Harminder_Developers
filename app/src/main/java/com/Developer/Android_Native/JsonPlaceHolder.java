package com.Developer.Android_Native;

import com.Developer.Android_Native.model.Comments;
import com.Developer.Android_Native.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolder {

    @GET("posts")
    Call<List<DataModel>>  getData();

    @GET("posts/{id}/comments")
    Call<List<Comments>>  getCommentsData(@Path("id")int postId);
}
