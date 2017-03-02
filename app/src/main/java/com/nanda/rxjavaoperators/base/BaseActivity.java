package com.nanda.rxjavaoperators.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nandagopal on 2/28/17.
 */
public class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  protected void setToolBarTitle(String title) {
    if (getSupportActionBar() != null) getSupportActionBar().setTitle(title);
  }
}
