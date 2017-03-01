package com.nanda.rxjavaoperators.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.nanda.rxjavaoperators.R;
import com.nanda.rxjavaoperators.ui.operators.ConcatExampleActivity;
import com.nanda.rxjavaoperators.ui.operators.ZipExampleActivity;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_operator_concat) public void onConcatClick() {
    startActivity(new Intent(MainActivity.this, ConcatExampleActivity.class));
  }

  @OnClick(R.id.btn_operator_zip) public void onZipClick() {
    startActivity(new Intent(MainActivity.this, ZipExampleActivity.class));
  }
}
