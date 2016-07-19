package com.coletorv2.colertorv3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.coletorv2.colertorv3.App.MessageBox;
import com.coletorv2.colertorv3.App.ViewHelper;
import com.coletorv2.colertorv3.Database.Database;
import com.coletorv2.colertorv3.Dominio.Entidades.Contato;
import com.coletorv2.colertorv3.Dominio.Repositorioformulario;
import com.coletorv2.colertorv3.Util.DateUtil;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Formulario extends AppCompatActivity {


    private EditText edttalhao;
    private EditText edtmaterial;
    private EditText edtarea;
    private EditText edtdata;

    private Spinner spnsobrevivencia;
    private Spinner spndensidade;
    private Spinner spnhomogeneidade;
    private Spinner spnaspectos;
    private Spinner spnmato;
    private Spinner spnformiga;
    private Spinner spnpragas;
    private Spinner spnconservacao;


    private ArrayAdapter<String> adpsobrevivencia;
    private ArrayAdapter<String> adpdensidade;
    private ArrayAdapter<String> adphomogeneidade;
    private ArrayAdapter<String> adpaspectos;
    private ArrayAdapter<String> adpmato;
    private ArrayAdapter<String> adpformiga;
    private ArrayAdapter<String> adppragas;
    private ArrayAdapter<String> adpconservacao;


    private com.coletorv2.colertorv3.Database.Database Database;
    private SQLiteDatabase Conn;
    private Repositorioformulario repositorioformulario;
    private Contato contato;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/



                edttalhao = (EditText) findViewById(R.id.edttalhao);
                edtmaterial = (EditText) findViewById(R.id.edtmaterial);
                edtarea = (EditText) findViewById(R.id.edtarea);
                edtdata = (EditText) findViewById(R.id.edtdata);


                spnsobrevivencia = (Spinner) findViewById(R.id.spnsobrevivencia);
                spndensidade = (Spinner) findViewById(R.id.spndensidade);
                spnhomogeneidade = (Spinner) findViewById(R.id.spnhomogeneidade);
                spnaspectos = (Spinner) findViewById(R.id.spnaspectos);
                spnmato = (Spinner) findViewById(R.id.spnmato);
                spnformiga = (Spinner) findViewById(R.id.spnformiga);
                spnpragas = (Spinner) findViewById(R.id.spnpragas);
                spnconservacao = (Spinner) findViewById(R.id.spnconservacao);

                adpsobrevivencia = ViewHelper.createArrayAdapter(this, spnsobrevivencia);
                adpdensidade = ViewHelper.createArrayAdapter(this, spndensidade);
                adphomogeneidade = ViewHelper.createArrayAdapter(this, spnhomogeneidade);
                adpaspectos = ViewHelper.createArrayAdapter(this, spnaspectos);
                adpmato = ViewHelper.createArrayAdapter(this, spnmato);
                adpformiga = ViewHelper.createArrayAdapter(this, spnformiga);
                adppragas = ViewHelper.createArrayAdapter(this, spnpragas);
                adpconservacao = ViewHelper.createArrayAdapter(this, spnconservacao);


                adpsobrevivencia.add("3- de 97 a 100%");
                adpsobrevivencia.add("2- de 94 a 96,99%");
                adpsobrevivencia.add("1- de 91 a 93,99%");
                adpsobrevivencia.add("0- menor que 90,99");

                adpdensidade.add("3-Maior que 1110");
                adpdensidade.add("2-de 1067 a 1110");
                adpdensidade.add("1-de 1022 a 1066");
                adpdensidade.add("0-maior que 1022");

                adphomogeneidade.add("3-Homogênea");
                adphomogeneidade.add("2-Homogênea+replanta atrasada");
                adphomogeneidade.add("1-Heterogênea");
                adphomogeneidade.add("0-Heterogênea+Falhas (necessita reforma)");

                adpaspectos.add("0-Sintomas de deficiencia generalizada");
                adpaspectos.add("1-Estacionada");
                adpaspectos.add("2-Sintomas de deficiência em algumas plantas (adubação seletiva)");
                adpaspectos.add("3-Sem sintomas de deficiência");

                adpmato.add("3-Limpo");
                adpmato.add("2-Sujo momento de intervenção (limite)");
                adpmato.add("1-Sujo competindo");
                adpmato.add("0-Sujo competindo com danos econômicos");

                adpformiga.add("3-Limpo");
                adpformiga.add("2-Ataque local");
                adpformiga.add("1-Ataque Geral (Sem danos)");
                adpformiga.add("0-Ataque com danos econômicos");

                adppragas.add("3-Limpo");
                adppragas.add("2-Ataque local");
                adppragas.add("1-Ataque Geral (Sem danos)");
                adppragas.add("0-Ataque com danos econômicos");

                adpconservacao.add("3-Sem perda significativa da camada superficial do solo");
                adpconservacao.add("2-Escorrimentos na estrada e terra solta");
                adpconservacao.add("1-Início de formação de sulcos e erosão");
                adpconservacao.add("0-Erosão, voçoroca, estouro de caixa e curva de nível e perda de àrvores");

                edtdata.setOnClickListener(new Exibedatalistener());
                edtdata.setOnFocusChangeListener(new Exibedatalistener());


                Bundle bundle= getIntent().getExtras();

        if ((bundle != null) && (bundle.containsKey(Principal.PAR_TALHOES)))
        {
            contato = (Contato) bundle.getSerializable(Principal.PAR_TALHOES);
            preencheDados();

        }else
            contato = new Contato();


        try {







            Database = new Database(this);
            Conn = Database.getWritableDatabase();
            repositorioformulario = new Repositorioformulario(Conn);




        }catch (SQLException ex)
        {

            MessageBox.show(this, "Erro", "Erro ao criar o banco " + ex.getMessage());


        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);



        if(contato.getId()!=0)
            menu.getItem(1).setVisible(true);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.mni_acao1:

                salvar();

                finish();


                break;
            case R.id.mni_acao2:
                excluir ();
                finish();


                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void preencheDados()
    {

        edttalhao.setText(contato.getTALHAO());
        edtmaterial.setText(contato.getMATERIAL());
        edtarea.setText(contato.getAREA());
        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
        String dt = format.format(contato.getDATA());
        edtdata.setText(dt);
        spnsobrevivencia.setSelection(Integer.parseInt(contato.getSOBREVIVENCIA()));
        spndensidade.setSelection(Integer.parseInt(contato.getDENSIDADE()));
        spnhomogeneidade.setSelection(Integer.parseInt(contato.getHOMOGENEIDADE()));
        spnaspectos.setSelection(Integer.parseInt(contato.getASPECTO()));
        spnmato.setSelection(Integer.parseInt(contato.getMATO()));
        spnformiga.setSelection(Integer.parseInt(contato.getFORMIGA()));
        spnpragas.setSelection(Integer.parseInt(contato.getPRAGAS()));
        spnconservacao.setSelection(Integer.parseInt(contato.getCONSERVACAO()));
    }

    private void excluir ()
    {
        try{
            repositorioformulario.excluir(contato.getId());

        }catch (Exception ex)
        {
            MessageBox.show(this,"Erro","Erro ao excluir  os dados "+ ex.getMessage());


        }
    }

    private void salvar()
    {

        try{

            contato.setTALHAO(edttalhao.getText().toString());
            contato.setMATERIAL(edtmaterial.getText().toString());
            contato.setAREA(edtarea.getText().toString());
            contato.setSOBREVIVENCIA(String.valueOf(spnsobrevivencia.getSelectedItemPosition()));
            contato.setDENSIDADE(String.valueOf(spndensidade.getSelectedItemPosition()));
            contato.setHOMOGENEIDADE(String.valueOf(spnhomogeneidade.getSelectedItemPosition()));
            contato.setASPECTO(String.valueOf(spnaspectos.getSelectedItemPosition()));
            contato.setMATO(String.valueOf(spnmato.getSelectedItemPosition()));
            contato.setFORMIGA(String.valueOf(spnformiga.getSelectedItemPosition()));
            contato.setPRAGAS(String.valueOf(spnpragas.getSelectedItemPosition()));
            contato.setCONSERVACAO(String.valueOf(spnconservacao.getSelectedItemPosition()));



            if  (contato.getId()==0)
            {
                repositorioformulario.inserir(contato);
            }else
                repositorioformulario.alterar(contato);


        }catch (Exception ex)
        {

            MessageBox.show(this,"Erro","Erro ao salvar  os dados "+ ex.getMessage());

        }
    }


    private void exibedata()
    {
        Calendar calendar = Calendar.getInstance();


        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dlg = new DatePickerDialog(this,new SelecionaDataListener(),2015,04,04);
        dlg.show();
    }
    private class Exibedatalistener implements View.OnClickListener, View.OnFocusChangeListener
    {

        @Override
        public void onClick(View v) {

            exibedata();

        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if(hasFocus)
                exibedata();

        }
    }
    private class SelecionaDataListener implements DatePickerDialog.OnDateSetListener
    {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            String dt = DateUtil.dateToString(year, monthOfYear, dayOfMonth);
            Date data= DateUtil.getDate(year,monthOfYear,dayOfMonth);

            edtdata.setText(dt);

            contato.setDATA(data);

        }
        }













    }




