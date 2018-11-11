package com.example.amit.instashare.di.component;

import com.example.amit.instashare.App;
import com.example.amit.instashare.di.builder.ActivityBuilder;
import com.example.amit.instashare.di.module.ApplicationModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton @Component(modules = {
    AndroidSupportInjectionModule.class, AndroidInjectionModule.class, ApplicationModule.class,
    ActivityBuilder.class
}) public interface ApplicationComponent {

  void inject(App app);
}
