package com.example.practica7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Facebook extends Fragment {




        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.facebook, container, false);


            WebView webView = view.findViewById(R.id.facebook);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://facebook.com");


            return view;

        }


}
