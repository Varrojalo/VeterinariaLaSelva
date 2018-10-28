package cl.inacap.veterinarialaselva.view;

import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.controller.AdapterDatos;
import cl.inacap.veterinarialaselva.model.dao.AnimalDAO;
import cl.inacap.veterinarialaselva.model.dto.Animal;

public class VistaCatalogo extends AppCompatActivity {

    ListView listViewAnimales;
    ArrayList<Animal> listaAnimales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);
        AnimalDAO animalDAO = null;
        listaAnimales = animalDAO.obtenerAnimales();

        listViewAnimales = findViewById(R.id.lista_animales);// recycler es el nombre del recycler view cambiarlo por el que se le ponga


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        // Retrieve the SearchView and plug it into SearchManager
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }
}
