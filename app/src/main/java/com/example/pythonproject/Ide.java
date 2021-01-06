package com.example.pythonproject;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Ide extends AppCompatActivity {
        WebView webView;
        ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ide);


        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        webView = (WebView) findViewById(R.id.webView2);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        webView.setWebViewClient(new WebViewClient());
        final WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webView.loadUrl(getString(R.string.pyt));


         webView.setWebViewClient(new WebViewClient(){
             @Override
             public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

             try{
                     webView.stopLoading();
                 }
                 catch (Exception e){
                 }
                 if (webView.canGoBack()){
                     webView.goBack();
                 }
                 webView.loadUrl("about:blank");
                 AlertDialog alertDialog = new AlertDialog.Builder(Ide.this).create();
                 alertDialog.setTitle("!!!Oops, Something Went Wrong");
                 alertDialog.setMessage("-No Internet Connection\n-Verify that Airplane Mode is turned Off\n-Make Sure Your wireless Switch Is turned on");
                 alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Try Again", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         finish();
                         startActivity(getIntent());
                     }

                 });

                 alertDialog.show();
                 super.onReceivedError(view, errorCode, description, failingUrl);

             }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                setTitle("Python IDE");

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                setTitle(view.getTitle());
            }


         });




    }


    }


