package org.cuatrovientos.recyclerviewonclick.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.cuatrovientos.recyclerviewonclick.R;
import org.cuatrovientos.recyclerviewonclick.adapters.RecyclerDataAdapter;
import org.cuatrovientos.recyclerviewonclick.modle.Imagenes;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    RecyclerDataAdapter recyclerDataAdapter;
    RecyclerView recyclerView;
    private Intent intent;
    Realm realm;
    RealmResults<Imagenes> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        intent = new Intent(MainActivity.this, SecondactivityActivity.class);
        realm = Realm.getDefaultInstance();
        results = realm.where(Imagenes.class).findAll();
        recyclerDataAdapter = new RecyclerDataAdapter(results, new RecyclerDataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Imagenes objeto, int position) {
                intent.putExtra("Titulo", objeto.getTitulo());
                intent.putExtra("Imagen", objeto.getImagen());
                intent.putExtra("ColorTexto", objeto.getColorTexto());
                intent.putExtra("ColorImagen", objeto.getColorImagen());
                intent.putExtra("Descripcion", objeto.getDescripcion());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerDataAdapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}