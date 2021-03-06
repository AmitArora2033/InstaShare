package com.example.amit.instashare.di.module;

import android.app.Activity;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module public class ActivityModule {

  private final Activity activity;

  public ActivityModule(Activity activity) {
    this.activity = activity;
  }

  @Provides Activity provideActivity() {
    return activity;
  }

  @Provides Context provideContext(Activity activity) {
    return activity;
  }
}
