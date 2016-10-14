package turntotech.org.navigationcontroller.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewFragment;

import turntotech.org.navigationcontroller.R;

/**
 * Created by elijah on 10/12/2016.
 */
public class WebFragment extends WebViewFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //TODO: Receive bundle and create logic for deciding on-screen data

        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        WebView myWebView = (WebView) rootView.findViewById(R.id.webView);
        myWebView.loadUrl("http://www.google.com");
        return rootView;
    }

}
