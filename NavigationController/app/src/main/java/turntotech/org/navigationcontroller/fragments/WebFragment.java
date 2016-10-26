package turntotech.org.navigationcontroller.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import turntotech.org.navigationcontroller.R;

/**
 * Created by elijah on 10/12/2016.
 */
public class WebFragment extends Fragment {

    String url = "http://www.gsmarena.com";
    WebView myWebView;
    TextView title;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mCustomView = inflater.inflate(R.layout.custom_actionbar, null);
        title = (TextView) mCustomView.findViewById(R.id.title_text);
        mCustomView.findViewById(R.id.back_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        mCustomView.findViewById(R.id.deleteButton).setVisibility(View.INVISIBLE);
        mCustomView.findViewById(R.id.addButton).setVisibility(View.INVISIBLE);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setCustomView(mCustomView);
        actionBar.setDisplayShowCustomEnabled(true);

        productSelection();

        View rootView = inflater.inflate(R.layout.fragment_web, container, false);
        myWebView = (WebView) rootView.findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        myWebView.loadUrl(url);
        myWebView.setWebViewClient(new browser());

        return rootView;
    }

    public void productSelection() {
        Bundle bundle = this.getArguments();
        title.setText(bundle.getString("ProductName"));
        int companyPosition = bundle.getInt("CompanyIndex");
        int productIndex = bundle.getInt("ProductIndex");
        title.setText(bundle.getString("ProductName"));
        Log.i("companyIndex", "" + companyPosition);
        Log.i("productIndex", "" + productIndex);
        Log.i("c * 10 + p", "" + (companyPosition * 10 + productIndex));

        switch ((companyPosition * 10) + productIndex) {
            //Apple
            case 0:
                url = "http://www.gsmarena.com/apple_iphone_7-8064.php";
                break;
            case 1:
                url = "http://www.gsmarena.com/apple_ipad_air_2-6742.php";
                break;
            case 2:
                url = "http://www.gsmarena.com/apple_watch_edition_series_2_42mm-8331.php";
                break;
            //Samsung
            case 10:
                url = "http://www.gsmarena.com/samsung_galaxy_note7-8082.php";
                break;
            case 11:
                url = "http://www.gsmarena.com/samsung_galaxy_s7-7821.php";
                break;
            case 12:
                url = "http://www.gsmarena.com/samsung_gear_s3_classic-8309.php";
                break;
            //LG
            case 20:
                url = "http://www.gsmarena.com/lg_g5-7815.php";
                break;
            case 21:
                url = "http://www.gsmarena.com/lg_g_pad_8_3-5673.php";
                break;
            case 22:
                url = "http://www.gsmarena.com/lg_watch_urbane_2nd_edition_lte-7607.php";
                break;
            //Huawei
            case 30:
                url = "http://www.gsmarena.com/huawei_honor_8-8195.php";
                break;
            case 31:
                url = "http://www.gsmarena.com/huawei_mate_9-8073.php";
                break;
            case 32:
                url = "http://www.gsmarena.com/huawei_watch-7687.php";
                break;
            default:
                url = "http://www.gsmarena.com";
                break;
        }
    }

    private class browser extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}
