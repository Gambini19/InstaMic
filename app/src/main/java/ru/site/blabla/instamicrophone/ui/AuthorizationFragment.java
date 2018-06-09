package ru.site.blabla.instamicrophone.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;
import ru.site.blabla.instamicrophone.R;
import ru.site.blabla.instamicrophone.ui.base.BaseFragment;

public class AuthorizationFragment extends BaseFragment {

    @BindView(R.id.auth_web_view)
    WebView authMebView;

    @Override
    protected int getLayoutResId() {
        return R.layout.auth_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setupWebView();
        //nextFragment();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void setupWebView() {
        WebSettings webSettings = authMebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        authMebView.setHorizontalScrollBarEnabled(false);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        //wvAuth.setWebViewClient(new VkWebViewClient());
        authMebView.loadUrl("https://oauth.vk.com/authorize?client_id=6287930&scope=friends,notify,photos,photos,audio,video,docs,notes,pages,groups,offline&redirect_uri=https://oauth.vk.com/blank.html&display=mobile&v=5.5&response_type=token&revoke=1");
    }
}
