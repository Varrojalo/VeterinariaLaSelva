package cl.inacap.veterinarialaselva.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import cl.inacap.veterinarialaselva.R;
import cl.inacap.veterinarialaselva.model.dto.Animal;

public class VistaAnimal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        Intent intent = getIntent();

        int idAnimal = intent.getIntExtra("ANIMAL_ID",1);

    }
}
