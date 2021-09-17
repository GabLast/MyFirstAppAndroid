package com.example.myfirstapp;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DisplayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        Intent intent = getIntent();
        TextView view = findViewById(R.id.displayinfo);

        String nombre = intent.getStringExtra("nombre");
        String apellido = intent.getStringExtra("apellido");
        int day = intent.getIntExtra("day", -1);
        int month = intent.getIntExtra("month", -1);
        int year = intent.getIntExtra("year", -1);
        boolean yes = intent.getBooleanExtra("yes", true);
        boolean no = intent.getBooleanExtra("no", false);
        String gender = intent.getStringExtra("gender");

        String string = "¡Hola! Mi nombre es " + nombre + " " + apellido + ".\n\n" +
                "Soy de género " + gender + " y nací en la fecha " + day + "/" + month + "/" + year + ".\n\n";

        if(yes)
        {
            List<String> lenguajes = new ArrayList();

            boolean java = intent.getBooleanExtra("java", true);
            boolean js = intent.getBooleanExtra("js", true);
            boolean python = intent.getBooleanExtra("python", true);
            boolean c = intent.getBooleanExtra("c", true);
            boolean csharp = intent.getBooleanExtra("csharp", true);
            boolean go = intent.getBooleanExtra("go", true);

            if(java)
            {
                lenguajes.add("Java");
            }
            if(js)
            {
                lenguajes.add("JS");
            }
            if(python)
            {
                lenguajes.add("Python");
            }
            if(c)
            {
                lenguajes.add("C/C++");
            }
            if(csharp)
            {
                lenguajes.add("C#");
            }
            if(go)
            {
                lenguajes.add("Go Language");
            }

            string += "Me gusta programar. ";

            if(lenguajes.size() > 1)
            {
                string += "Mis lenguajes favoritos son: ";
            }else {
                string += "Mi lenguaje favorito es ";
            }

            int i;
            for (i = 0; i < lenguajes.size(); i++)
            {
                string += lenguajes.get(i);

                if(i == lenguajes.size() - 2)
                {
                    string += " y ";
                }else if(i < lenguajes.size() - 1)
                {
                    string += ", ";
                }else {
                    string += ".";
                }
            }

        }else if (no) {
            string += "Debido a mis preferencias, no me gusta programar.";
        }else {
            string += "ERROR CON SELECCION DE RADIO BUTTON.";
        }

        view.setText(string);
    }

}