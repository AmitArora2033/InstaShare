package com.example.amit.instashare.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import butterknife.ButterKnife;
import com.example.amit.instashare.HomeActivity;
import com.example.amit.instashare.R;

public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getIntent().getExtras() != null) {
      initIntentExtras(getIntent().getExtras());
    }
  }

  @Override public void setContentView(int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(this);
    initViews();
    onReady();
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {

    if (item.getItemId() == android.R.id.home) {

      finish();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  public abstract void setUpToolbar();

  @Override public boolean onCreateOptionsMenu(Menu menu) {

    return super.onCreateOptionsMenu(menu);
  }

  @Override protected void onStart() {
    super.onStart();
  }

  @Override protected void onStop() {
    super.onStop();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  public abstract void initViews();

  public abstract void onReady();

  public abstract void initIntentExtras(Bundle bundle);
}
