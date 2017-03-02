package com.nanda.rxjavaoperators.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.nanda.rxjavaoperators.R;
import com.nanda.rxjavaoperators.ui.operators.ConcatExampleActivity;
import com.nanda.rxjavaoperators.ui.operators.FlatMapIterableActivity;
import com.nanda.rxjavaoperators.ui.operators.MergeActivity;
import com.nanda.rxjavaoperators.ui.operators.RxJavaMathActivity;
import com.nanda.rxjavaoperators.ui.operators.ZipExampleActivity;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_rxjava_math) public void onRxJavaMathClick() {
    startActivity(new Intent(MainActivity.this, RxJavaMathActivity.class));
  }

  @OnClick(R.id.btn_operator_concat) public void onConcatClick() {
    startActivity(new Intent(MainActivity.this, ConcatExampleActivity.class));
  }

  @OnClick(R.id.btn_operator_zip) public void onZipClick() {
    startActivity(new Intent(MainActivity.this, ZipExampleActivity.class));
  }

  @OnClick(R.id.btn_operator_merge) public void onMergeClick() {
    startActivity(new Intent(MainActivity.this, MergeActivity.class));
  }

  @OnClick(R.id.btn_operator_flatmap) public void onFlatMapClick() {
    startActivity(new Intent(MainActivity.this, FlatMapIterableActivity.class));
  }
}
