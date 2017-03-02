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
public class SumFloatActivity extends BaseActivity {

  @BindView(R.id.tv_result) TextView tvResult;

  private List<Float> doubleList = new ArrayList<>();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_math_sum_float);
    ButterKnife.bind(this);

    setToolBarTitle("RxJavaMath SumFloat");

    doubleList.clear();
    for (int i = 0; i < 20; i++) {
      doubleList.add(i * 3f);
    }
  }

  /**
   * toBlocking() is used to a synchronous call and it seperates data from stream.
   */

  @OnClick(R.id.btn_sum_float_from_diff) public void onSumFromNos() {

    float value = MathObservable.sumFloat(Observable.just(1 * 3f, 2 * 2f, 4 * 8f, 6 * 9f))
        .toBlocking()
        .single();
    tvResult.setText(String.valueOf(value));
  }

  @OnClick(R.id.btn_sum_float_from_list) public void onSumFromPrimitiveTypeList() {

    float valueFromList = MathObservable.sumFloat(
        Observable.just(doubleList).flatMapIterable(new Func1<List<Float>, Iterable<Float>>() {
          @Override public Iterable<Float> call(List<Float> floats) {
            return floats;
          }
        })).toBlocking().single();

    tvResult.setText(String.valueOf(valueFromList));
  }
}
