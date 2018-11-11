package com.example.amit.instashare;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.example.amit.instashare.di.component.ApplicationComponent;
import com.example.amit.instashare.di.component.DaggerApplicationComponent;
import com.example.amit.instashare.di.module.ApplicationModule;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

public class App extends Application implements HasActivityInjector {

  ApplicationComponent applicationComponent;

  @Inject DispatchingAndroidInjector<Activity> activityAndroidInjector;

  public App() {
  }

  public static App get(Context context) {
    Context cont = context.getApplicationContext();
    return (App) cont.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();

    applicationComponent =
        DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();

    applicationComponent.inject(this);
  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }

  @Override public DispatchingAndroidInjector<Activity> activityInjector() {
    return activityAndroidInjector;
  }
}
