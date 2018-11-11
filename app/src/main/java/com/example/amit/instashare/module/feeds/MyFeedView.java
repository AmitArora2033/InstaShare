package com.example.amit.instashare.module.feeds;

import com.example.amit.instashare.base.BaseView;
import com.example.amit.instashare.model.Feed;
import java.util.List;

public interface MyFeedView extends BaseView {

  void showFeedList(List<Feed> feedList);
}
