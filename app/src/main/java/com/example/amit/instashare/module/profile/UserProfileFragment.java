package com.example.amit.instashare.module.profile;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.amit.instashare.R;
import com.example.amit.instashare.base.BaseFragment;
import com.example.amit.instashare.base.ViewModelProviderFactory;
import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;

public class UserProfileFragment extends BaseFragment {

  @BindView(R.id.user_profile_image) ImageView userImage;
  @BindView(R.id.tl_user_profile) TabLayout tableLayout;

  @Inject ViewModelProvider.Factory viewModelProviderFactory;
  @Inject UserProfileViewModel userProfileViewModel;


  public static UserProfileFragment newInstance() {
    UserProfileFragment fragment = new UserProfileFragment();
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected void supportAndroidInjecton() {
    AndroidSupportInjection.inject(this);
  }

  @Override protected void detachView() {

  }

  @Override public int getLayout() {
    return R.layout.activity_user_profile;
  }

  @Override protected void initExtras() {

  }

  @Override protected void initDependencies() {
    userProfileViewModel =
        ViewModelProviders.of(this, viewModelProviderFactory).get(UserProfileViewModel.class);
  }

  @Override public void initViews() {
    Glide.with(this)
        .load(R.drawable.anaonymus)
        .apply(RequestOptions.circleCropTransform())
        .into(userImage);
  }

  @Override protected void onReady() {

  }
}
