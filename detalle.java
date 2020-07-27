package com.e.contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class detalle extends AppCompatActivity {

    private TextView nomdet, fechadet, maildet, teldet, descdet;
    private Button editar;
    String nombre, fecha, mail, telefono, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        nomdet= findViewById(R.id.nomdetalle);
        fechadet=findViewById(R.id.fechadet);
        maildet=findViewById(R.id.maildet);
        teldet=findViewById(R.id.teldet);
        descdet=findViewById(R.id.descdet);



        Bundle datos = getIntent().getExtras();
        nombre =  datos.getString(getResources().getString(R.string.nomextra));
        fecha = datos.getString(getResources().getString(R.string.fechaextra));
        telefono = datos.getString(getResources().getString(R.string.telextra));
        mail = datos.getString(getResources().getString(R.string.mailextra));
        desc = datos.getString(getResources().getString(R.string.descextra));

        nomdet.setText(nombre);
        fechadet.setText(fecha);
        maildet.setText(mail);
        teldet.setText(telefono);
        descdet.setText(desc);


    }
    public void onClick(View v) {
        String nom = nomdet.getText().toString();
        String fec = fechadet.getText().toString();
        String tel = teldet.getText().toString();
        String email = maildet.getText().toString();
        String descr = descdet.getText().toString();
        Intent sigInt = new Intent(detalle.this, MainActivity.class);
        sigInt.putExtra(getResources().getString(R.string.nomextra),nom);
        sigInt.putExtra(getResources().getString(R.string.fechaextra),fec);
        sigInt.putExtra(getResources().getString(R.string.telextra),tel);
        sigInt.putExtra(getResources().getString(R.string.mailextra),email);
        sigInt.putExtra(getResources().getString(R.string.descextra),descr);
        startActivity(sigInt);
        finish();
    }
}