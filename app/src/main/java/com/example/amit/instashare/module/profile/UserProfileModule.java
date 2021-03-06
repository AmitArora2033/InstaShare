package com.example.amit.instashare.module.profile;

import android.arch.lifecycle.ViewModelProvider;
import com.example.amit.instashare.base.ViewModelProviderFactory;
import com.example.amit.instashare.datamanger.DataManager;
import dagger.Module;
import dagger.Provides;

@Module public  class UserProfileModule {

  @Provides UserProfileViewModel provideUserProfileViewModel(DataManager dataManager) {
    return new UserProfileViewModel(dataManager);
  }

  @Provides ViewModelProvider.Factory provideUserProfileViewModelFactory(
      UserProfileViewModel userProfileViewModel) {
    return new ViewModelProviderFactory<>(userProfileViewModel);
  }
}
