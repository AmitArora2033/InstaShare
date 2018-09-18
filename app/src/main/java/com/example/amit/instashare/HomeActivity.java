package com.example.amit.instashare;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.BindView;
import com.example.amit.instashare.base.BaseActivity;
import com.example.amit.instashare.module.feeds.MyFeedFragment;
import com.example.amit.instashare.module.profile.ProfileActivity;

public class HomeActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @BindView(R.id.navigation_view) NavigationView navigationView;
  @BindView(R.id.toolbar) android.support.v7.widget.Toolbar toolbar;
  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
  }

  @Override public void setUpToolbar() {
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      ActionBarDrawerToggle toggle =
          new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open,
              R.string.navigation_drawer_close);
      drawerLayout.addDrawerListener(toggle);
      toggle.syncState();
    }
  }

  @Override public void initViews() {
    navigationView.setNavigationItemSelectedListener(this);
    setUpToolbar();

    if (getSupportActionBar() != null) {
      getSupportActionBar().setTitle("Insta Share");
      getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    View view = navigationView.getHeaderView(0);
    view.findViewById(R.id.ll_nav_header).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onHeaderClicked();
      }
    });
  }

  private void onHeaderClicked() {
    ProfileActivity.start(this);
    closeDrawer();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {

    return super.onCreateOptionsMenu(menu);
  }

  @Override public void onReady() {
    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
    android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
    ft.add(R.id.frame_layout, MyFeedFragment.getInstance(), "current_tag");
    ft.commit();
  }

  @Override public void initIntentExtras(Bundle bundle) {

  }

  @Override protected void onStart() {
    super.onStart();
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {

    return false;
  }

  @Override public void onBackPressed() {
    if (drawerLayout.isDrawerOpen(Gravity.START)) {
      drawerLayout.closeDrawer(Gravity.START);
    } else {
      super.onBackPressed();
    }
  }

  private void closeDrawer() {
    if (drawerLayout.isDrawerOpen(Gravity.START)) {
      drawerLayout.closeDrawer(Gravity.START);
    }
  }
}
