package com.example.amit.instashare.datamanger;

import com.example.amit.instashare.remote.ApiService;

public class ApiManager {
  ApiService apiService;

  public ApiManager(ApiService apiService) {
    this.apiService = apiService;
  }
}
