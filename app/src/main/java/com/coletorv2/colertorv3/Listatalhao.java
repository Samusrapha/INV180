package com.coletorv2.colertorv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;

public class Listatalhao extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{


    private ImageButton btnAdicionar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listatalhao);

        btnAdicionar=(ImageButton)findViewById(R.id.imageButton);
        btnAdicionar.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, Principal.class);
        startActivityForResult(it, 0);
}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
