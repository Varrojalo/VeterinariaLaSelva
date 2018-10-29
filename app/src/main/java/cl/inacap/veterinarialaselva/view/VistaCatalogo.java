package cl.inacap.veterinarialaselva.view;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        listViewAnimales = findViewById(R.id.lista_animales);
        listaAnimales = new ArrayList();
        listaAnimales.add(new Animal(1,"Misha",R.drawable.ic_user_black_24dp,"Gato","Desconocido",new Date(2018-1900,4-1,20),true));
        listaAnimales.add(new Animal(2,"Jacinta",R.drawable.ic_user_black_24dp,"Perro","Maltes",new Date(2007-1900,5-1,1),true));
        listaAnimales.add(new Animal(3,"Frank",R.mipmap.frank,"Perro","Pug",new Date(1920-1900,1-1,20),false));

        Animal[] data = new Animal[listaAnimales.size()];
        data = listaAnimales.toArray(data);
        AnimalAdapter adapter = new AnimalAdapter(this.getApplicationContext(),R.layout.item_animal, data);

        listViewAnimales.setAdapter(adapter);

        listViewAnimales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView)view.findViewById(R.id.idAnimal);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
                int idAnimal = Integer.parseInt(v.getText().toString());
                Intent intent = new Intent(getBaseContext(), VistaAnimal.class);
                intent.putExtra("ANIMAL_ID", idAnimal);
                intent.putExtra("LISTA_ANIMALES", listaAnimales);
                startActivity(intent);
            }
        });
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
