package com.example.amit.instashare.base;

import android.arch.lifecycle.ViewModel;

public class BaseViewModel<V extends BaseView> extends ViewModel {

  protected V view;

  public BaseViewModel() {
  }

  public void attachView(V view) {
    this.view = view;
  }

  protected boolean isViewAttached() {
    return view != null;
  }

  public void detachView() {
    if (view != null) this.view = null;
  }
}
