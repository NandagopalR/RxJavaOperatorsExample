package com.nanda.rxjavaoperators.ui.operators;

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

/**
 * Created by nandagopal on 3/1/17.
 */
public class FlatMapIterableActivity extends BaseActivity {

  @BindView(R.id.tv_result) TextView tvResult;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_flatmap);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_do_flatmap) public void onFlatmapClick() {

    Observable.zip(Observable.just(CommonUtils.getMaximoDevList()),
        Observable.just(CommonUtils.getIPhoneDevList()), (persons, persons2) -> {
          List<Person> personList = new ArrayList<>(persons.size() + persons2.size());
          personList.addAll(persons);
          personList.addAll(persons2);
          return personList;
        }).flatMapIterable(new Func1<List<Person>, Iterable<Person>>() {
      @Override public Iterable<Person> call(List<Person> list) {
        return list;
      }
    }).map(person -> person).subscribe(persons -> {
      tvResult.append(" " + persons.getPersonName() + " - " + persons.getMobileNumber() + "\n");
    });
  }
}
