package com.nanda.rxjavaoperators.ui.operators;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
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
import rx.functions.Func2;

/**
 * Created by nandagopal on 2/28/17.
 */
public class ZipExampleActivity extends BaseActivity {

  @BindView(R.id.btn_do_zip) Button btnDoZip;
  @BindView(R.id.tv_result) TextView tvResult;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_zip);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_do_zip) public void onClick() {
    Observable.zip(Observable.just(CommonUtils.getAndroidDevList()),
        Observable.just(CommonUtils.getIPhoneDevList()),
        new Func2<List<Person>, List<Person>, List<Person>>() {
          @Override public List<Person> call(List<Person> persons, List<Person> persons2) {
            List<Person> personList = new ArrayList<>(persons.size() + persons2.size());
            personList.addAll(persons);
            personList.addAll(persons2);
            return personList;
          }
        }).flatMapIterable(new Func1<List<Person>, Iterable<Person>>() {
      @Override public Iterable<Person> call(List<Person> persons) {
        return persons;
      }
    }).map(person -> person).subscribe(person -> {
      tvResult.append(person.getPersonName() + "\n");
    });
  }
}
