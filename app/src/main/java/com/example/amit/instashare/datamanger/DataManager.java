package com.example.amit.instashare.datamanger;

public class DataManager {

  private final DaoManager daoManager;
  private final ApiManager apiManger;

  public DataManager(DaoManager daoManager, ApiManager apiManager) {
    this.daoManager = daoManager;
    this.apiManger = apiManager;
  }

  private  Obser getLocalDeviceFeeds() {

  }
}
