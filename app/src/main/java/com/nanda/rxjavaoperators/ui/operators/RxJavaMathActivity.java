package com.nanda.rxjavaoperators.ui.operators;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.nanda.rxjavaoperators.R;
import com.nanda.rxjavaoperators.base.BaseActivity;
import com.nanda.rxjavaoperators.ui.rxmath.SumDoubleActivity;
import com.nanda.rxjavaoperators.ui.rxmath.SumFloatActivity;
import com.nanda.rxjavaoperators.ui.rxmath.SumIntegerActivity;
import com.nanda.rxjavaoperators.ui.rxmath.SumLongActivity;

/**
 * Created by nandagopal on 3/2/17.
 */
public class RxJavaMathActivity extends BaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rx_math);
    ButterKnife.bind(this);

    setToolBarTitle("RxJava Math");
  }

  @OnClick(R.id.btn_math_sum_int) public void onSumIntClick() {
    startActivity(new Intent(getApplicationContext(), SumIntegerActivity.class));
  }

  @OnClick(R.id.btn_math_sum_long) public void onSumLongClick() {
    startActivity(new Intent(getApplicationContext(), SumLongActivity.class));
  }

  @OnClick(R.id.btn_math_sum_double) public void onSumDoubleClick() {
    startActivity(new Intent(getApplicationContext(), SumDoubleActivity.class));
  }

  @OnClick(R.id.btn_math_sum_float) public void onSumFloatClick() {
    startActivity(new Intent(getApplicationContext(), SumFloatActivity.class));
  }

  //@OnClick(R.id.btn_math_sum_int) public void onSumIntClick() {
  //  startActivity(new Intent(getApplicationContext(), ZipExampleActivity.class));
  //}
}
