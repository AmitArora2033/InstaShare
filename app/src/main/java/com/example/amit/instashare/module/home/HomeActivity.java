package com.example.amit.instashare.module.home;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.BindView;
import com.example.amit.instashare.R;
import com.example.amit.instashare.base.BaseActivity;
import com.example.amit.instashare.module.feeds.MyFeedFragment;
import com.example.amit.instashare.module.profile.UserProfileFragment;
import com.example.amit.instashare.utils.AppPermissions;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements HasSupportFragmentInjector {

  private static final int REQUEST_CAMERA_PERMISSION = 1000;
  private static final int REQUEST_CODE_EXTERNAL_STORAGE = 2000;

  @BindView(R.id.navigation_view) BottomNavigationView navigationView;
  @BindView(R.id.toolbar) android.support.v7.widget.Toolbar toolbar;
  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  private int currentSelectedItem = -1;

  public static final String CURRENT_FRAGMENT = "Current_selected_item";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
  }

  @Override protected void performDependencyInjection() {
    AndroidInjection.inject(this);
  }

  @Override public void setUpToolbar() {
    if (toolbar != null) {
      setSupportActionBar(toolbar);
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("Insta Share");
    }
  }

  @Override public void initViews() {
    setUpToolbar();
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.frame_layout, MyFeedFragment.getInstance(), "current_fragment");
    ft.commit();

    navigationView.setOnNavigationItemSelectedListener(
        new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (navigationView.getSelectedItemId() != item.getItemId()) {
              currentSelectedItem = item.getItemId();
              return handleNavigation(item);
            }
            return false;
          }
        });
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    currentSelectedItem = savedInstanceState.getInt(CURRENT_FRAGMENT);
    for (Fragment fragment : getSupportFragmentManager().getFragments()) {
      if (fragment.getId() == currentSelectedItem) {
        replaceFragment(getSupportFragmentManager().getPrimaryNavigationFragment());
      }
    }
  }

  @Override public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    currentSelectedItem = navigationView.getSelectedItemId();
    outState.putInt(CURRENT_FRAGMENT, currentSelectedItem);
    super.onSaveInstanceState(outState, outPersistentState);
  }

  private boolean handleNavigation(MenuItem item) {

    switch (item.getItemId()) {
      case R.id.nav_home:
        return replaceFragment(MyFeedFragment.getInstance());

      case R.id.nav_profile:
        return replaceFragment(UserProfileFragment.newInstance());

      case R.id.nav_camera:
        openCamera();
        return true;

      default:
        return false;
    }
  }

  private void openCamera() {
    AppPermissions permissions = new AppPermissions(this);

    if (permissions.hasCameraPermission()) {
      if (permissions.checkExternalStoragePermissions()) {

      } else {
        permissions.getExternalStoragePermission(REQUEST_CODE_EXTERNAL_STORAGE);
      }
      Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
      startActivityForResult(intent, REQUEST_CAMERA_PERMISSION);
    } else {
      permissions.getCameraPermission(this, REQUEST_CAMERA_PERMISSION);
    }
  }

  private boolean replaceFragment(Fragment instance) {
    if (getSupportFragmentManager().findFragmentByTag("current_fragment") != null) {
      FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
      ft.replace(R.id.frame_layout, instance, "current_fragment");
      ft.commit();
      return true;
    } else {
      return false;
    }
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
  }

  @Override public void onReady() {

  }

  @Override public void initIntentExtras(Bundle bundle) {

  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {

    if (requestCode == REQUEST_CAMERA_PERMISSION
        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      openCamera();
    }

    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == REQUEST_CAMERA_PERMISSION && resultCode == RESULT_OK) {

      if (data.getExtras() != null) {
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
      }
    }
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override protected void onStart() {
    super.onStart();
  }

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}
