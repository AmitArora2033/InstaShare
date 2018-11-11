package com.example.amit.instashare.module.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.amit.instashare.R;
import com.example.amit.instashare.base.BaseActivity;

public class ProfileActivity extends BaseActivity {

  @BindView(R.id.user_profile_image) ImageView userImage;
  @BindView(R.id.toolbar) Toolbar toolbar;
  @BindView(R.id.tl_user_profile) TabLayout tableLayout;

  public static void start(Activity context) {
    Intent intent = new Intent(context, ProfileActivity.class);
    context.startActivity(intent);
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_profile);
  }

  @Override public void setUpToolbar() {
    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }
    //toolbar.setNavigationOnClickListener(new View.OnClickListener() {
    //  @Override public void onClick(View v) {
    //    NavUtils.navigateUpFromSameTask(ProfileActivity.this);
    //    onBackPressed();
    //  }
    //});
  }

  @Override public void initViews() {
    setUpToolbar();
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    Glide.with(this)
        .load(R.drawable.anaonymus)
        .apply(RequestOptions.circleCropTransform())
        .into(userImage);
  }

  @Override public void onReady() {

  }

  @Override public void initIntentExtras(Bundle bundle) {

  }

  @Override public void onBackPressed() {
    super.onBackPressed();
  }
}
