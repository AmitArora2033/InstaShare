package com.example.amit.instashare.datamanger;

import android.net.Uri;
import com.example.amit.instashare.R;
import com.example.amit.instashare.model.Feed;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

  private final DaoManager daoManager;
  private final ApiManager apiManger;

  public DataManager(DaoManager daoManager, ApiManager apiManager) {
    this.daoManager = daoManager;
    this.apiManger = apiManager;
  }

  public List<Feed> getLocalDeviceFeeds() {

    List<Feed> feeds = new ArrayList<>();

    feeds.add(Feed.create("Amit Arora", 23, "Caption goes like this",
        Uri.parse("android.resource://com.example.amit.instashare/drawable/" + R.drawable.batman)));
    feeds.add(Feed.create("Narender Modi", 1, "Sabka Sath Sabka Vikas", Uri.parse(
        "android.resource://com.example.amit.instashare/drawable/" + R.drawable.batman2)));

    return feeds;
  }

  public List<Feed> addNewFeed(Uri uri) {
    return null;
  }
}
