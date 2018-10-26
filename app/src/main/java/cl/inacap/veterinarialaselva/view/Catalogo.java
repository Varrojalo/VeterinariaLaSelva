package cl.inacap.veterinarialaselva.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.controller.AdapterDatos;
import cl.inacap.veterinarialaselva.model.dao.AnimalDAO;
import cl.inacap.veterinarialaselva.model.dto.Animal;

public class Catalogo extends AppCompatActivity {

    RecyclerView recyclerAnimales;
    ArrayList<Animal> listaAnimales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        AnimalDAO animalDAO = null;
        listaAnimales = animalDAO.obtenerAnimales();

        recyclerAnimales = findViewById(R.id.lista_animales);// recycler es el nombre del recycler view cambiarlo por el que se le ponga
        recyclerAnimales.setLayoutManager(new LinearLayoutManager(this));
        AdapterDatos adapter = new AdapterDatos(listaAnimales);
        recyclerAnimales.setAdapter(adapter);

    }
}
