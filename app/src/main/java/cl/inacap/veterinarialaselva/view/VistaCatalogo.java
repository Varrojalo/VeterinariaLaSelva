package cl.inacap.veterinarialaselva.view;

import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.widget.ListView;

import java.sql.Date;
import java.util.ArrayList;

import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.controller.AdapterDatos;
import cl.inacap.veterinarialaselva.controller.AnimalAdapter;
import cl.inacap.veterinarialaselva.model.dao.AnimalDAO;
import cl.inacap.veterinarialaselva.model.dto.Animal;

public class VistaCatalogo extends AppCompatActivity {

    ListView listViewAnimales;
    ArrayList<Animal> listaAnimales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listaAnimales = new ArrayList();
        listaAnimales.add(new Animal(1,"Misha",R.drawable.ic_user_black_24dp,"Gato","Desconocido",new Date(2018,4,20),true));
        listaAnimales.add(new Animal(2,"Jacinta",R.drawable.ic_user_black_24dp,"Perro","Maltes",new Date(2007,5,1),true));
        listaAnimales.add(new Animal(1,"Frank",R.drawable.ic_user_black_24dp,"Perro","Pug",new Date(1920,1,20),false));

        Animal[] data = new Animal[listaAnimales.size()];
        data = listaAnimales.toArray(data);
        AnimalAdapter adapter = new AnimalAdapter(this,R.layout.item_animal, data);
        listViewAnimales = findViewById(R.id.lista_animales);
        listViewAnimales.setAdapter(adapter);

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
