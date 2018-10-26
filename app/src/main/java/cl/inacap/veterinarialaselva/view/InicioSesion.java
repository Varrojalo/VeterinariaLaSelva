package cl.inacap.veterinarialaselva.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.model.dao.UsuarioDAO;
import cl.inacap.veterinarialaselva.model.dto.Usuario;

public class InicioSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
    }

    public void abrirRegistro(View v)
    {
        Intent intento = new Intent(InicioSesion.this,Registro.class);
        InicioSesion.this.startActivity(intento);
    }
    public void iniciarSesion(View v)
    {
        EditText user = findViewById(R.id.inputUsuario);
        EditText password = findViewById(R.id.inputContraseña);

        String usuario = user.getText().toString().trim();
        String contraseña = password.getText().toString().trim();
        boolean usuarioEncontrado = false;

        UsuarioDAO uDao = new UsuarioDAO();
        ArrayList<Usuario> usuarios = new ArrayList();
        usuarios = uDao.obtenerUsuarios();

        for (int i = 0; i < usuarios.size();i++)
        {
            if(usuario.equals(usuarios.get(i).getNombre()) && contraseña.equals(usuarios.get(i).getContracena()))
            {
                usuarioEncontrado = true;
                break;
            }
        }
        if(usuarioEncontrado)
        {
            //usuario Encontrado! INICIA SESION
            Intent intento = new Intent(InicioSesion.this,Principal.class);
            InicioSesion.this.startActivity(intento);
        }
        else
        {
            //usuario NO encontrado!

        }
    }
}
