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

public class Web2 extends Fragment {

    String pagina2 = "";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagina_web2, container, false);


        WebView webView = view.findViewById(R.id.web2);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://" + pagina2);

        return view;
    }

    /*Metodo cuya función es la de recibir la direccion de la pagina web introducida por el cliente */

    public void cambiarweb(String pagina2) {

        this.pagina2 = pagina2;

    }


}

