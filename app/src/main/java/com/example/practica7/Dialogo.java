package com.example.practica7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {


    public static Dialogo newInstance() {
        return new Dialogo();
    }

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("¿Desea continuar?");
        builder.setMessage("Pulsa aceptar para continuar o cancelar para volver atrás");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

            /*si el usuario pulsa el boton aceptar el Dialog se cerrará dejando ver la pagina web introducida*/

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        });

        /*si el usuario pulsa el boton cancelar del Dialog, se abrirá de nuevo la página de inicio */

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return builder.create();
    }
}

