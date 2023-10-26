package org.cuatrovientos.recyclerviewonclick.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.cuatrovientos.recyclerviewonclick.R;

public class SecondactivityActivity extends AppCompatActivity {
    ImageView imgView;
    ConstraintLayout constraintLayout;
    TextView txtTitulo, txtDescripcion;
    Button volver;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        imgView = findViewById(R.id.imgSecond);
        txtTitulo = findViewById(R.id.txtTitleSecond);
        txtDescripcion = findViewById(R.id.textDescripcion);
        volver = findViewById(R.id.btnVolver);
        constraintLayout = findViewById(R.id.cL);
        intent = new Intent(SecondactivityActivity.this, MainActivity.class);

        txtTitulo.setText(getIntent().getExtras().getString("Titulo"));
        txtTitulo.setBackgroundResource(getIntent().getExtras().getInt("ColorTexto"));
        txtDescripcion.setText(getIntent().getExtras().getString("Descripcion"));
        imgView.setImageResource(getIntent().getExtras().getInt("Imagen"));
        imgView.setBackgroundResource(getIntent().getExtras().getInt("ColorImagen"));
        constraintLayout.setBackgroundResource(getIntent().getExtras().getInt("ColorImagen"));

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}