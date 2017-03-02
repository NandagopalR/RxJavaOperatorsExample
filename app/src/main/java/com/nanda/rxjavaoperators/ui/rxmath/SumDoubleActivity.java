package com.nanda.rxjavaoperators.ui.rxmath;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.nanda.rxjavaoperators.R;
import com.nanda.rxjavaoperators.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.observables.MathObservable;

/**
 * Created by nandagopal on 3/2/17.
 */
public class SumDoubleActivity extends BaseActivity {

  @BindView(R.id.tv_result) TextView tvResult;

  private List<Double> doubleList = new ArrayList<>();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_math_sum_double);
    ButterKnife.bind(this);

    setToolBarTitle("RxJavaMath SumDouble");

    doubleList.clear();
    for (int i = 0; i < 20; i++) {
      doubleList.add(System.currentTimeMillis() * i * 1.0);
    }
  }

  /**
   * toBlocking() is used to a synchronous call and it seperates data from stream.
   */

  @OnClick(R.id.btn_sum_double_from_diff) public void onSumFromNos() {

    double value = MathObservable.sumDouble(
        Observable.just(System.currentTimeMillis() * 1 * 1.0, System.currentTimeMillis() * 2 * 1.0,
            System.currentTimeMillis() * 4 * 1.0, System.currentTimeMillis() * 6 * 1.0))
        .toBlocking()
        .single();
    tvResult.setText(String.valueOf(value));
  }

  @OnClick(R.id.btn_sum_double_from_list) public void onSumFromPrimitiveTypeList() {

    double valueFromList = MathObservable.sumDouble(
        Observable.just(doubleList).flatMapIterable(new Func1<List<Double>, Iterable<Double>>() {
          @Override public Iterable<Double> call(List<Double> doubles) {
            return doubles;
          }
        })).toBlocking().single();

    tvResult.setText(String.valueOf(valueFromList));
  }
}
