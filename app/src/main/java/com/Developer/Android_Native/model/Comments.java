package com.Developer.Android_Native.model;

import com.google.gson.annotations.SerializedName;

public class Comments {

    private int postId;
    private  String name;
    private String email;
    private int id;
    @SerializedName("body")
    private String text;

    public int getPostId() {
        return postId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
