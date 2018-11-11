package com.example.amit.instashare.data;

import android.content.SharedPreferences;

public class AppPreferenceManager {

  private static final String USER_NAME = "user_name";
  private final SharedPreferences sharedPreferences;

  public AppPreferenceManager(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  private void putString(String key, String value) {
    sharedPreferences.edit().putString(key, value).apply();
  }

  public void setUserName(String userName) {
    putString(USER_NAME, userName);
  }

  public String getUserName() {
    return sharedPreferences.getString(USER_NAME, "");
  }
}
