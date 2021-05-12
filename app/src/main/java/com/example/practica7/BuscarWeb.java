package com.example.practica7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class BuscarWeb extends Fragment implements View.OnClickListener {
    EditText dirPag1;
    Button cambioPag;
    EditText dirPag2;
    ProgressBar barra;
    int progreso;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pagina_cambio, container, false);

        dirPag1 = view.findViewById(R.id.dirPag1);
        cambioPag = view.findViewById(R.id.cambioPag);
        cambioPag.setOnClickListener(this);
        dirPag2 = view.findViewById(R.id.dirPag2);
        barra = view.findViewById(R.id.barra2);
        progreso = 0;
        return view;


    }

/*Funcion del boton de la página de inicio que recoge los datos proporcionados por el cliente y los envia al Main */

    @Override
    public void onClick(View view) {


        String pagina1 = dirPag1.getText().toString();
        String pagina2 = dirPag2.getText().toString();

        FragmentActivity activity = getActivity();
        MainActivity mainActivity = (MainActivity) activity;

        if (mainActivity != null) {
            mainActivity.cambiarweb(pagina1, pagina2);

/*Si los edit text no están vacios se mostrara la barra de carga*/

        }
        if (!pagina1.isEmpty() && !pagina2.isEmpty()) {
            barra.setVisibility(View.VISIBLE);
            progreso += 100;
            barra.setProgress(progreso);

        }
    }
}






