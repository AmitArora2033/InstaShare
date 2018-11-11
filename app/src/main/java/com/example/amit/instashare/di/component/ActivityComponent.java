package com.example.amit.instashare.di.component;

import android.app.Activity;
import com.example.amit.instashare.di.builder.ActivityBuilder;
import com.example.amit.instashare.di.module.ActivityModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;

@Singleton
@Component(modules = { AndroidInjectionModule.class, ActivityModule.class, ActivityBuilder.class })

public interface ActivityComponent {

  void inject(Activity activity);
}
