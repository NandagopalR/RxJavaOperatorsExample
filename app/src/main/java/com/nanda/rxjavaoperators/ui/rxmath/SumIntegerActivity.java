package com.nanda.rxjavaoperators.ui.rxmath;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.nanda.rxjavaoperators.R;
import com.nanda.rxjavaoperators.base.BaseActivity;
import com.nanda.rxjavaoperators.model.Person;
import com.nanda.rxjavaoperators.utils.CommonUtils;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import rx.observables.MathObservable;

/**
 * Created by nandagopal on 3/2/17.
 */
public class SumIntegerActivity extends BaseActivity {

  @BindView(R.id.tv_result) TextView tvResult;

  private List<Integer> integerList = new ArrayList<>();

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_math_sum_integer);
    ButterKnife.bind(this);

    setToolBarTitle("RxJavaMath SumInteger");

    integerList.clear();
    for (int i = 0; i < 20; i++) {
      integerList.add(i);
    }
  }

  /**
   * toBlocking() is used to a synchronous call and it seperates data from stream.
   */

  @OnClick(R.id.btn_sum_int_from_diff) public void onSumFromNos() {

    int value = MathObservable.sumInteger(Observable.just(1, 2, 3, 3)).toBlocking().single();
    tvResult.setText(String.valueOf(value));
  }

  @OnClick(R.id.btn_sum_int_from_list) public void onSumFromPrimitiveTypeList() {

    int valueFromList = MathObservable.sumInteger(
        Observable.just(integerList).flatMapIterable(new Func1<List<Integer>, Iterable<Integer>>() {
          @Override public Iterable<Integer> call(List<Integer> integers) {
            return integers;
          }
        })).toBlocking().single();

    tvResult.setText(String.valueOf(valueFromList));
  }

  @OnClick(R.id.btn_sum_int_from_person_list) public void onSumFromPersonList() {
    int valueFromPeron = MathObservable.sumInteger(Observable.just(CommonUtils.getAndroidDevList())
        .flatMapIterable(new Func1<List<Person>, Iterable<Person>>() {
          @Override public Iterable<Person> call(List<Person> list) {
            return list;
          }
        })
        .map(new Func1<Person, Integer>() {
          @Override public Integer call(Person person) {
            return person.getPersonId();
          }
        })).toBlocking().single();

    tvResult.setText(String.valueOf(valueFromPeron));
  }
}
