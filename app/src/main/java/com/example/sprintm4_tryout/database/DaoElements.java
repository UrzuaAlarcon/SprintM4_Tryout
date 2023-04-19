package com.example.sprintm4_tryout.database;

import androidx.room.Dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.sprintm4_tryout.modelo.Elements;

import java.util.List;

@Dao
public interface DaoElements {

    @Insert
    long insertarElemento(Elements elements);

    @Update
    void actualizarElemento(Elements elements);

    @Delete
    void eliminarElemento(Elements elements);

    @Query("SELECT * FROM Elements")
    List<Elements> obtenerElementos();

}
