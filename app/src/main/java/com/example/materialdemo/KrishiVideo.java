package com.example.materialdemo;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class KrishiVideo extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krishi_video);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://agrinetbd.com/%E0%A6%95%E0%A7%83%E0%A6%B7%E0%A6%BF-%E0%A6%B8%E0%A6%AE%E0%A6%B8%E0%A7%8D%E0%A6%AF%E0%A6%BE-%E0%A6%93-%E0%A6%B8%E0%A6%AE%E0%A6%BE%E0%A6%A7%E0%A6%BE%E0%A6%A8?fbclid=IwAR0u5QnF-hq83s0pghkfwFsvKCGAs7MZolfBsPBTPV9OrLO2p5ogkbvFgT4");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else
        {
            super.onBackPressed();

        }



    }
}
