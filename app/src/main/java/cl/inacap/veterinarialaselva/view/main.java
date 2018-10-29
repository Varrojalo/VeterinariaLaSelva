package cl.inacap.veterinarialaselva.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import cl.inacap.veterinarialaselva.CatalogoFragment;
import cl.inacap.veterinarialaselva.PrincipalFragment;
import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.UsuarioFragment;
import cl.inacap.veterinarialaselva.model.dao.UsuarioDAO;
import cl.inacap.veterinarialaselva.model.dto.Usuario;

public class main extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MAIN";
    BottomNavigationView bNavigation;
    UsuarioDAO uDao = new UsuarioDAO();
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        int idUsuario = intent.getIntExtra("ANIMAL_ID",1);
        Usuario usuario = uDao.obtenerUsuario(idUsuario); //TODO: implementar el metodo obtenerUsuario de la clase UsuarioDAO

        bNavigation = findViewById(R.id.navegacionPrincipal);

        bNavigation.setOnNavigationItemSelectedListener(this);
        bNavigation.setSelectedItemId(R.id.navigation_home);

    }

    UsuarioFragment usuarioF = new UsuarioFragment();
    CatalogoFragment catalogoF = new CatalogoFragment();
    PrincipalFragment principalF = new PrincipalFragment();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.i(TAG,"Item seleccionado");
        switch (item.getItemId())
        {
            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_container,principalF).commit();
                return true;
            case R.id.navigation_catalog:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_container,catalogoF).commit();
                return true;
            case R.id.navigation_user:
                usuarioF.setUsuario(usuario);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_container,usuarioF).commit();
                return true;
        }
        return false;
    }
}
