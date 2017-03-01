package com.nanda.rxjavaoperators.ui.operators;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.nanda.rxjavaoperators.R;
import com.nanda.rxjavaoperators.base.BaseActivity;
import com.nanda.rxjavaoperators.model.Person;
import com.nanda.rxjavaoperators.utils.CommonUtils;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nandagopal on 2/28/17.
 */
public class ConcatExampleActivity extends BaseActivity {

  @BindView(R.id.btn_do_simple_concat) Button btnDoSimpleConcat;
  @BindView(R.id.btn_do_concat) Button btnDoConcat;
  @BindView(R.id.tvResult) TextView tvResult;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_concat);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_do_simple_concat) public void doSimpleConcat() {
    getConcatOperator().subscribe(persons -> {
      Toast.makeText(ConcatExampleActivity.this, "" + persons.size(), Toast.LENGTH_SHORT).show();
    });
  }

  @OnClick(R.id.btn_do_concat) public void doConcat() {
    getConcatOperator().flatMapIterable(new Func1<List<Person>, Iterable<Person>>() {
      @Override public Iterable<Person> call(List<Person> persons) {
        return persons;
      }
    }).map(person -> person).subscribe(person -> {
      tvResult.append(person.getPersonName() + "\n");
    }, throwable -> {
      Log.e("Exception", "doConcat: " + throwable.getMessage());
    });
  }

  /**
   * Concat operator concat the given items and emit the same
   *
   * @return Observable of Android Dev List,Iphone Dev List and Ui Dev List
   */
  private Observable<List<Person>> getConcatOperator() {
    return Observable.concat(getAndroidDevList(), getIPhoneDevList(), getUiDevList());
  }

  private Observable<List<Person>> getAndroidDevList() {
    return Observable.fromCallable(() -> CommonUtils.getAndroidDevList());
  }

  private Observable<List<Person>> getIPhoneDevList() {
    return Observable.fromCallable(() -> CommonUtils.getIPhoneDevList());
  }

  private Observable<List<Person>> getUiDevList() {
    return Observable.fromCallable(() -> CommonUtils.getUiUxDevList());
  }
}
