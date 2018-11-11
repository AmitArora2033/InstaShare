package com.example.amit.instashare.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class AppPermissions {

  private final Activity context;

  public AppPermissions(FragmentActivity context) {
    this.context = context;
  }

  public boolean checkExternalStoragePermissions() {
    if (ContextCompat.checkSelfPermission(context, Manifest.permission_group.STORAGE)
        == PackageManager.PERMISSION_GRANTED) {
      return true;
    }
    return false;
  }

  public void getExternalStoragePermission(int requestCode) {
    ActivityCompat.requestPermissions(context, new String[] { Manifest.permission_group.STORAGE },
        requestCode);
  }

  public boolean hasCameraPermission() {
    if (context == null) ;

    if (hasCamera()) {
      if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
          == PackageManager.PERMISSION_GRANTED) {
        return true;
      } else {
        Toast.makeText(context, "Phone Does not Support Camera!", Toast.LENGTH_LONG);
      }
    }
    return false;
  }

  private boolean hasCamera() {
    return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
  }

  public void getCameraPermission(AppCompatActivity context, int requestCode) {
    ActivityCompat.requestPermissions(context, new String[] { Manifest.permission.CAMERA },
        requestCode);
  }

}
