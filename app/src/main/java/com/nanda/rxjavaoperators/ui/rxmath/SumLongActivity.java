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
public class SumLongActivity extends BaseActivity {

  @BindView(R.id.tv_result) TextView tvResult;

  private List<Long> longList = new ArrayList<>();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_math_sum_long);
    ButterKnife.bind(this);

    setToolBarTitle("RxJavaMath SumLong");

    longList.clear();
    for (int i = 0; i < 20; i++) {
      longList.add(System.currentTimeMillis() * i);
    }
  }

  /**
   * toBlocking() is used to a synchronous call and it seperates data from stream.
   */

  @OnClick(R.id.btn_sum_long_from_diff) public void onSumFromNos() {

    long value = MathObservable.sumLong(
        Observable.just(System.currentTimeMillis() * 1, System.currentTimeMillis() * 2,
            System.currentTimeMillis() * 4, System.currentTimeMillis() * 6)).toBlocking().single();
    tvResult.setText(String.valueOf(value));
  }

  @OnClick(R.id.btn_sum_long_from_list) public void onSumFromPrimitiveTypeList() {

    long valueFromList = MathObservable.sumLong(
        Observable.just(longList).flatMapIterable(new Func1<List<Long>, Iterable<Long>>() {
          @Override public Iterable<Long> call(List<Long> longs) {
            return longs;
          }
        })).toBlocking().single();

    tvResult.setText(String.valueOf(valueFromList));
  }
}
