package ru.site.blabla.instamicrophone.ui.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.site.blabla.instamicrophone.R;

public abstract class BaseFragment extends Fragment {

    public interface FragmentListener {

        void onNextFragment(BaseFragment fragment);

        void onBackFragment();

        void setTitle(CharSequence title);
    }

    private @Nullable
    FragmentListener listener;

    private boolean hasToolbar = true;

    private ProgressDialog progressDialog;
    private Unbinder unbinder;

    private Toolbar toolbar;

    protected abstract int getLayoutResId();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (FragmentListener) getActivity();
        } catch (ClassCastException e) {

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       /* toolbar = ButterKnife.findById(getActivity(), R.id.toolbar);
        if (toolbar != null) {
            toolbar.setVisibility(hasToolbar ? View.VISIBLE : View.GONE);
        }*/

        View root = inflater.inflate(getLayoutResId(), container, false);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    protected void showProgressDialog(boolean show) {
        if (show) {
            if (progressDialog == null) {
                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setCancelable(false);
                progressDialog.setMessage(getString(R.string.label_wait));
            }
            progressDialog.show();
        } else {
            if (progressDialog != null) {
                progressDialog.dismiss();
                progressDialog = null;
            }
        }
    }

    public void nextFragment(BaseFragment fragment){
        if (listener != null){
            listener.onNextFragment(fragment);
        }
    }

    public void backFragment(){
        if (listener != null){
            listener.onBackFragment();
        }
    }

    public void setTitle(CharSequence title){
        if (listener != null){
            listener.setTitle(title);
        }
    }
}

