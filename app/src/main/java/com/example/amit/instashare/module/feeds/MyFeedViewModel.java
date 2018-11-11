package com.example.amit.instashare.module.feeds;

import com.example.amit.instashare.base.BaseViewModel;
import com.example.amit.instashare.datamanger.DataManager;

public class MyFeedViewModel extends BaseViewModel<MyFeedView> {

  private DataManager dataManger;



  public MyFeedViewModel(DataManager dataManager) {
    this.dataManger = dataManager;
  }

  void getLocalDeviceFeeds() {
    if (isViewAttached()) {
      view.showFeedList(dataManger.getLocalDeviceFeeds());
    }
  }
}
