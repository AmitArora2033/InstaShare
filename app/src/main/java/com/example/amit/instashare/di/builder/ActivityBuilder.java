package com.example.amit.instashare.di.builder;

import com.example.amit.instashare.module.home.HomeActivity;
import com.example.amit.instashare.module.home.HomeModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module public abstract class ActivityBuilder {

  @ContributesAndroidInjector(modules = HomeModule.class)
  public abstract HomeActivity bindHomeActivity();
}

