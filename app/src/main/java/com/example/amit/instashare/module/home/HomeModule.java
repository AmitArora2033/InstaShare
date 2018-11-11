package com.example.amit.instashare.module.home;

import com.example.amit.instashare.module.feeds.FeedModule;
import com.example.amit.instashare.module.feeds.MyFeedFragment;
import com.example.amit.instashare.module.profile.UserProfileFragment;
import com.example.amit.instashare.module.profile.UserProfileModule;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module public abstract class HomeModule {

  @ContributesAndroidInjector(modules = FeedModule.class)
  abstract MyFeedFragment provideMyFeedFragment();

  @ContributesAndroidInjector(modules = UserProfileModule.class)
  abstract UserProfileFragment provideUserProfilFragment();
}
