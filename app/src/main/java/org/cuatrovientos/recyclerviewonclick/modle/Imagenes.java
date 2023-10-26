package org.cuatrovientos.recyclerviewonclick.modle;

import org.cuatrovientos.recyclerviewonclick.app.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Imagenes extends RealmObject {
    @PrimaryKey
    private int id;
    private String titulo, descripcion;
    private int imagen, colorImagen, colorTexto;
    public Imagenes(){}
    public Imagenes(String titulo, int imagen, int colorImagen, int colorTexto, String descripcion){
        this.id = MyAplication.imagenesID.incrementAndGet();
        this.titulo = titulo;
        this.imagen = imagen;
        this.colorImagen = colorImagen;
        this.colorTexto = colorTexto;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getColorImagen() {
        return colorImagen;
    }

    public void setColorImagen(int colorImagen) {
        this.colorImagen = colorImagen;
    }

    public int getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(int colorTexto) {
        this.colorTexto = colorTexto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
