package com.e.contactos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, fecha, telefono, mail, descrip;
    private Button siguiente;
    private DatePicker piker;
    private int dia, mes, anio;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        fecha = findViewById(R.id.fecha);
        telefono = findViewById(R.id.telefono);
        mail = findViewById(R.id.email);
        descrip = findViewById(R.id.descrip);
        piker = findViewById(R.id.piker);
        siguiente = findViewById(R.id.siguiente);


piker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
       monthOfYear=monthOfYear+1;
        fecha.setText(dayOfMonth +"/"+ monthOfYear +"/"+year);
    }
});


siguiente.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if (!nombre.getText().toString().isEmpty() && !fecha.getText().toString().isEmpty() && !telefono.getText().toString().isEmpty()
                && !mail.getText().toString().isEmpty() && !descrip.getText().toString().isEmpty()){
            String nom = nombre.getText().toString();
            String fec = fecha.getText().toString();
            String tel = telefono.getText().toString();
            String email = mail.getText().toString();
            String descr = descrip.getText().toString();
            Intent sigInt = new Intent(MainActivity.this, detalle.class);
            sigInt.putExtra(getResources().getString(R.string.nomextra),nom);
            sigInt.putExtra(getResources().getString(R.string.fechaextra),fec);
            sigInt.putExtra(getResources().getString(R.string.telextra),tel);
            sigInt.putExtra(getResources().getString(R.string.mailextra),email);
            sigInt.putExtra(getResources().getString(R.string.descextra),descr);
            startActivity(sigInt);



        }

    }
});



    }

    @Override
    protected void onResume() {
        super.onResume();
try {


    Bundle editdatos = getIntent().getExtras();
    String nomdato = editdatos.getString(getResources().getString(R.string.nomextra));
    String fechadato = editdatos.getString(getResources().getString(R.string.fechaextra));
    String teldato = editdatos.getString(getResources().getString(R.string.telextra));
    String maildato = editdatos.getString(getResources().getString(R.string.mailextra));
    String descdato = editdatos.getString(getResources().getString(R.string.descextra));
    if (!nomdato.isEmpty() && !fechadato.isEmpty() && !teldato.isEmpty() && !maildato.isEmpty() && !descdato.isEmpty()) {

        nombre.setText(nomdato);
        fecha.setText(fechadato);
        telefono.setText(teldato);
        mail.setText(maildato);
        descrip.setText(descdato);

    }
}catch (Exception e){

}
    }
}