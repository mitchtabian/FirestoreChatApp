package com.codingwithmitch.firestorechatapp;

import android.app.Application;

import com.codingwithmitch.firestorechatapp.models.User;
import com.google.firebase.firestore.FirebaseFirestore;

public class UserClient extends Application {

    private User user = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
