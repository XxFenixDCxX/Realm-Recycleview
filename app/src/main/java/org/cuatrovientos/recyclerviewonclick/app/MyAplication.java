package org.cuatrovientos.recyclerviewonclick.app;

import android.app.Application;

import org.cuatrovientos.recyclerviewonclick.R;
import org.cuatrovientos.recyclerviewonclick.modle.Imagenes;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyAplication extends Application {
    public static AtomicInteger imagenesID = new AtomicInteger();
    private Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        imagenesID = getIdByTable(realm, Imagenes.class);
        realm.close();
    }

    private void setUpRealmConfig(){
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();

        if (results.size()>0){
            return new AtomicInteger(results.max("id").intValue());
        }else{
            realm.beginTransaction();
            Imagenes genios = new Imagenes("GENIOS", R.drawable.genie, R.color.lime, R.color.dark_lime, "Los genios son magicos y chulos");
            realm.copyToRealm(genios);
            Imagenes fantasmas = new Imagenes("FANTASMAS", R.drawable.ghost, R.color.orange, R.color.orange_dark, "Los fantasmas no se ven a primera vista");
            realm.copyToRealm(fantasmas);
            Imagenes krakens = new Imagenes("KRAKENS", R.drawable.kraken, R.color.amber, R.color.dark_amber,"Los krakens son animales marinos muy peligrosos");
            realm.copyToRealm(krakens);
            Imagenes pinochos = new Imagenes("PINOCHOS", R.drawable.pinocchio, R.color.brown, R.color.dark_brown, "Ha pinocho le crece la nariz cuando miente");
            realm.copyToRealm(pinochos);
            Imagenes unicornios = new Imagenes("UNICORNIOS", R.drawable.unicorn, R.color.green, R.color.dark_green, "Los unicornios son animales magicos como caballos pero con un cuerno");
            realm.copyToRealm(unicornios);
            Imagenes brujas = new Imagenes("BRUJAS", R.drawable.witch, R.color.purple_500, R.color.purple_700, "Las brujas son magas que puedden ser malas");
            realm.copyToRealm(brujas);
            Imagenes brujos = new Imagenes("BRUJOS", R.drawable.wizard, R.color.red, R.color.red_dark, "Los brujos son magos que pueden ser malos");
            realm.copyToRealm(brujos);
            Imagenes adas = new Imagenes("ADAS", R.drawable.fairy, R.color.teal_200, R.color.teal_700, "Las adas son seres diminutos y magicos");
            realm.copyToRealm(adas);
            realm.commitTransaction();
            return new AtomicInteger(0);
        }
    }
}
