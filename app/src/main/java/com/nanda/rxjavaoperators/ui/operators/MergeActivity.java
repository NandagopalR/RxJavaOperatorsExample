package com.nanda.rxjavaoperators.ui.operators;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.nanda.rxjavaoperators.R;
import com.nanda.rxjavaoperators.base.BaseActivity;
import com.nanda.rxjavaoperators.model.Person;
import com.nanda.rxjavaoperators.utils.CommonUtils;
import com.nanda.rxjavaoperators.utils.UiUtils;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by nandagopal on 3/1/17.
 */
public class MergeActivity extends BaseActivity {

  @BindView(R.id.tv_result) TextView tvResult;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_merge);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btn_do_merge) public void onMergeClick() {

    Observable.merge(Observable.just(CommonUtils.getMaximoDevList()),
        Observable.just(CommonUtils.getBusinessPersonsList()))
        .flatMap(new Func1<List<Person>, Observable<List<Person>>>() {
          @Override public Observable<List<Person>> call(List<Person> persons) {
            return Observable.fromCallable(() -> persons);
          }
        })
        .map(persons -> persons)
        .subscribe(persons -> {
          UiUtils.showToast(getApplicationContext(), "" + persons.size());
        }, throwable -> Log.e("Exception", "onClick: " + throwable.getMessage()));
  }

  private Observable<List<Person>> getObservableData() {

    return Observable.concat(Observable.just(CommonUtils.getAndroidDevList()),
        Observable.just(CommonUtils.getMaximoDevList()));
  }
}
