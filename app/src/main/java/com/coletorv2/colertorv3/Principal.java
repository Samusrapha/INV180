package com.coletorv2.colertorv3;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.database.sqlite.*;
import android.database.*;
import com.coletorv2.colertorv3.Database.Database;

import com.coletorv2.colertorv3.App.MessageBox;
import com.coletorv2.colertorv3.Database.Parse;
import com.coletorv2.colertorv3.Dominio.Entidades.Contato;
import com.coletorv2.colertorv3.Dominio.Repositorioformulario;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, AdapterView.OnItemClickListener {
    /*LIST VIEW DOS TALHOES*/
    private ImageButton btnAdicionar;
    private EditText edtPesquisa;
    private ListView lsttalhoes;
    private ArrayAdapter<Contato> adptalhoes;
    private com.coletorv2.colertorv3.Database.Database Database;
    private SQLiteDatabase Conn;
    private Repositorioformulario repositorioContato;

    /*Nome da tabela, a função 'final' significa que essa String vai ser usada como constante*/
    public static final String PAR_TALHOES = "TALHOES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        lsttalhoes= (ListView) findViewById(R.id.lsttalhoes);
       // btnAdicionar.setOnClickListener(this);


        lsttalhoes.setOnItemClickListener(this);

        try {
            Database = new Database(this);
            Conn = Database.getWritableDatabase();
            repositorioContato = new Repositorioformulario(Conn);



            adptalhoes= repositorioContato.buscacontatos(this);

            lsttalhoes.setAdapter(adptalhoes);


           //FiltraDados filtraDados = new FiltraDados(adptalhoes);
           //edtPesquisa.addTextChangedListener(filtraDados);

        }catch (SQLException ex)
        {
            MessageBox.show(this, "Erro", "Erro ao criar o banco " + ex.getMessage());


        }



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Formulario.class);
                startActivityForResult(intent, 0);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            Intent it = new Intent(this, Parse.class);
            startActivityForResult(it, 0);

        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    @Override
    public void onClick(View view) {

        Intent it = new Intent(this, Formulario.class);
        startActivityForResult(it, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adptalhoes= repositorioContato.buscacontatos(this);

        lsttalhoes.setAdapter(adptalhoes);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contato contato = adptalhoes.getItem(position);

        Intent it = new Intent(this, Formulario.class);
        it.putExtra(PAR_TALHOES, contato);

        startActivityForResult(it, 0);
    }





    private class FiltraDados implements TextWatcher
    {
        private ArrayAdapter<Contato> arrayAdapter;

        private FiltraDados(ArrayAdapter<Contato> arrayAdapter)
        {
            this.arrayAdapter = arrayAdapter;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            arrayAdapter.getFilter().filter(s);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
