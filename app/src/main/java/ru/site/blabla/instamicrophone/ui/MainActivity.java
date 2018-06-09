package ru.site.blabla.instamicrophone.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.site.blabla.instamicrophone.R;
import ru.site.blabla.instamicrophone.ui.base.BaseActivity;
import ru.site.blabla.instamicrophone.ui.base.BaseFragment;

public class MainActivity extends BaseActivity implements BaseFragment.FragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BaseFragment fragment = new AuthorizationFragment();
        onNextFragment(fragment);

    }

    @Override
    public void onNextFragment(BaseFragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentFrame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackFragment() {
        getSupportFragmentManager()
                .popBackStack();
    }
}
