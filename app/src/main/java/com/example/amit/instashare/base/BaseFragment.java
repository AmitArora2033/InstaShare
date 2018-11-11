package com.example.amit.instashare.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

  @Override public void onAttach(Context context) {
    supportAndroidInjecton();
    super.onAttach(context);
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  protected abstract void supportAndroidInjecton();

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    if (savedInstanceState != null) {
      initExtras();
    }
    return inflater.inflate(getLayout(), container, false);
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initDependencies();
    initViews();
  }

  @Override public void onStart() {
    super.onStart();
    onReady();
  }

  @Override public void onDestroy() {
    super.onDestroy();
    detachView();
  }

  protected abstract void detachView();

  public abstract int getLayout();

  protected abstract void initExtras();

  protected abstract void initDependencies();

  protected abstract void initViews();

  protected abstract void onReady();
}
