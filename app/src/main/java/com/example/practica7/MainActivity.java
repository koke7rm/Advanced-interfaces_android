package com.example.practica7;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    ListView menuLateral;
    String pagina1 = "";
    String pagina2 = "";
    ImageView sonic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.main_layout);
        sonic = findViewById(R.id.sonic);


        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        menuLateral = findViewById(R.id.menu_lateral);
        menuLateral.setOnItemClickListener(this);


        cambiarPantalla(0);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {

            /*El botón de facebook abre un toast que indica donde se tiene que dirigir el usuario para iniciar sesion*/

            case R.id.botonFacebook:

                Toast.makeText(this, "Abre la pestaña Facebook para iniciar sesión", Toast.LENGTH_SHORT).show();
                break;

            /*al pinchar en esta opcion nos llevara directamente desde cualquier fragment a la pagina de inicio*/

            case R.id.Inicio:
                recreate();

                break;

        }
        drawerToggle.onOptionsItemSelected(item);
        return true;
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        cambiarPantalla(i);
    }

    private void cambiarPantalla(int i) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();

        switch (i) {

            /*el caso 0 es la página de inicion, por la que el programa se abrirá*/

            case 0:
                setTitle("Inicio");
                BuscarWeb inicioFragment = new BuscarWeb();
                transaction.replace(R.id.contenido, inicioFragment);

                /* el caso 1 abrira la página web 1, si el usuario previamente ha introducido una pagina web, esta se abrirá, sino se abrirá una pantalla en blanco*/

                break;
            case 1:
                setTitle("web1");
                Web1 web1 = new Web1();
                transaction.replace(R.id.contenido, web1);

                /*cuando el usuario pinche en el caso 1 primero aparecerá un Dialog previamente configurado*/

                Dialogo dialogo = Dialogo.newInstance();
                dialogo.show(getSupportFragmentManager(), "Dialogo");
                web1.cambiarweb(pagina1);

                break;
            case 2:
                /*el caso 2 pasa los datos que el cliente ha introducido en la página de inicio y los envía al fragment web1 para que puedan ser usados por el webView*/

                setTitle("web2");
                Web2 web2 = new Web2();
                transaction.replace(R.id.contenido, web2);

                Dialogo dialogo2 = Dialogo.newInstance();
                dialogo2.show(getSupportFragmentManager(), "Dialogo");
                web2.cambiarweb(pagina2);


                break;
             /*el caso 3 es un añadido y su unica funcion es abrir la página de inicio de facebook, un uso bastante común en las aplicaciones de hoy en dia y le da sentido
               al boton Facebook que se encuentra en la barra de opciones
              */
            case 3:
                setTitle("Facebook");

                Facebook facebook = new Facebook();
                transaction.replace(R.id.contenido, facebook);

                break;

            /*El caso 4 sirve para finalizar y salir de la app*/

            case 4:

                finish();

        }

        transaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }


    public void cambiarweb(String pagina1, String pagina2) {

        this.pagina1 = pagina1;
        this.pagina2 = pagina2;

        /*si el cliente no ha introducido ningun dato en los editText aparecerá por pantalla un Snackbar con el aviso pertinente
         */
        if (pagina1.isEmpty() && pagina2.isEmpty()) {
            View vista = findViewById(R.id.cambio);
            Snackbar.make(vista, "No has introducido dirección", Snackbar.LENGTH_INDEFINITE).setAction("Aceptar", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            }).show();

            /* sino, aparecera un animacion indicando que los datos han sido cargados en las páginas web1 y web2*/

        } else {


            Animation animation = AnimationUtils.loadAnimation(this, R.anim.cargando);
            View sonic = findViewById(R.id.sonic);
            sonic.setVisibility(View.VISIBLE);
            sonic.startAnimation(animation);
            sonic.setVisibility(View.GONE);


        }


    }


}





