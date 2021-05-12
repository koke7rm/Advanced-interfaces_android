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

public class Web1 extends Fragment {

    String pagina1 = "";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagina_web1, container, false);


        WebView webView = view.findViewById(R.id.web1);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://" + pagina1);


        return view;

    }

    /*Metodo cuya función es la de recibir la direccion de la pagina web introducida por el cliente */

    public void cambiarweb(String pagina1) {
        this.pagina1 = pagina1;

    }


}


