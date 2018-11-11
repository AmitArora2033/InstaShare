package com.example.amit.instashare.module.feeds;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.example.amit.instashare.base.ViewModelProviderFactory;
import com.example.amit.instashare.datamanger.DataManager;
import dagger.Module;
import dagger.Provides;

@Module public class FeedModule {

  @Provides MyFeedViewModel provideMyFeedViewModel(DataManager dataManager) {
    return new MyFeedViewModel(dataManager);
  }

  @Provides ViewModelProvider.Factory provideViewModelFactory(MyFeedViewModel viewModel) {
    return new ViewModelProviderFactory<ViewModel>(viewModel);
  }
}