package com.example.amit.instashare.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.example.amit.instashare.data.AppPreferenceManager;
import com.example.amit.instashare.datamanger.ApiManager;
import com.example.amit.instashare.datamanger.DaoManager;
import com.example.amit.instashare.datamanger.DataManager;
import com.example.amit.instashare.di.ApplicationContext;
import com.example.amit.instashare.remote.ApiService;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module public class ApplicationModule {

  private final Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides Context provideApplicationContext(Application application) {
    return application;
  }

  @Provides SharedPreferences provideSharedPreferences(@ApplicationContext Context context) {
    return context.getSharedPreferences("insta_share", Context.MODE_PRIVATE);
  }

  @Singleton @Provides AppPreferenceManager provideAppPreferenceManger(
      SharedPreferences sharedPreferences) {
    return new AppPreferenceManager(sharedPreferences);
  }

  @Singleton @Provides Retrofit.Builder provideRetrofit() {

    return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .client(new OkHttpClient());
  }

  @Provides @Singleton ApiService provideApiService(Retrofit.Builder builder) {
    return builder.baseUrl("https://www.flickr.com").build().create(ApiService.class);
  }

  @Provides @Singleton ApiManager provideApiManager(ApiService apiService) {
    return new ApiManager(apiService);
  }

  @Provides @Singleton DaoManager provideDaoManager() {
    return new DaoManager();
  }

  @Provides @Singleton DataManager provideDataManager(ApiManager apiManager,
      DaoManager daoManager) {
    return new DataManager(daoManager, apiManager);
  }
}
