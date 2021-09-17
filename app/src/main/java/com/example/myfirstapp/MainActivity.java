package com.example.myfirstapp;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Llenar un spinner/combobox
        List<String> genders = new ArrayList();
        genders.add("<Seleccione>");
        genders.add("Femenino");
        genders.add("Masculino");
        genders.add("Otro");
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = findViewById(R.id.genderComboBox);
        //Creating the ArrayAdapter instance having the genders
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,genders);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(arrayAdapter);
        spin.setSelection(0);

        RadioButton yes = findViewById(R.id.yesRDBTN);
        yes.setChecked(true);
        DatePicker birth = findViewById(R.id.fechaNaciSPN);
        birth.updateDate(2000,0,1);

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        RadioButton no = findViewById(R.id.noRDBTN);
        RadioButton yes = findViewById(R.id.yesRDBTN);

        CheckBox java = findViewById(R.id.javaCheck);
        CheckBox js = findViewById(R.id.jsCheck);
        CheckBox python = findViewById(R.id.pythonCheck);
        CheckBox c = findViewById(R.id.cCheck);
        CheckBox csharp = findViewById(R.id.csharpCheck);
        CheckBox go = findViewById(R.id.goCheck);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.yesRDBTN:
                if (checked)
                    no.setChecked(false);
                    yes.setChecked(true);
                    java.setEnabled(true);
                    js.setEnabled(true);
                    python.setEnabled(true);
                    c.setEnabled(true);
                    csharp.setEnabled(true);
                    go.setEnabled(true);
                    break;
            case R.id.noRDBTN:
                if (checked)
                    // Ninjas rule
                    yes.setChecked(false);
                    java.setEnabled(false);
                    js.setEnabled(false);
                    python.setEnabled(false);
                    c.setEnabled(false);
                    csharp.setEnabled(false);
                    go.setEnabled(false);

                    java.setChecked(false);
                    js.setChecked(false);
                    python.setChecked(false);
                    c.setChecked(false);
                    csharp.setChecked(false);
                    go.setChecked(false);
                    break;
        }
    }

    public void sendInfo(View view) {

        if(verifyFields(view))
        {
            Intent intent = new Intent(this, DisplayInfo.class);
            EditText nombre = findViewById(R.id.nombreTextField);
            EditText apellido = findViewById(R.id.apellidoTextField);
            DatePicker birth = findViewById(R.id.fechaNaciSPN);
            RadioButton yes = findViewById(R.id.yesRDBTN);
            RadioButton no = findViewById(R.id.noRDBTN);
            Spinner gender = findViewById(R.id.genderComboBox);

            CheckBox java = findViewById(R.id.javaCheck);
            CheckBox js = findViewById(R.id.jsCheck);
            CheckBox python = findViewById(R.id.pythonCheck);
            CheckBox c = findViewById(R.id.cCheck);
            CheckBox csharp = findViewById(R.id.csharpCheck);
            CheckBox go = findViewById(R.id.goCheck);

            intent.putExtra("nombre", nombre.getText().toString().trim());
            intent.putExtra("apellido", apellido.getText().toString().trim());

            int day = birth.getDayOfMonth();
            int month = birth.getMonth() + 1;
            int year = birth.getYear();
            intent.putExtra("day", day);
            intent.putExtra("month", month);
            intent.putExtra("year", year);

            intent.putExtra("yes", yes.isChecked());
            intent.putExtra("no", no.isChecked());

            intent.putExtra("gender", gender.getSelectedItem().toString().trim());

            intent.putExtra("java", java.isChecked());
            intent.putExtra("js", js.isChecked());
            intent.putExtra("python", python.isChecked());
            intent.putExtra("c", c.isChecked());
            intent.putExtra("csharp", csharp.isChecked());
            intent.putExtra("go", go.isChecked());

            startActivity(intent);
        }
    }

    public void limpiar(View view) {
        EditText nombre = findViewById(R.id.nombreTextField);
        EditText apellido = findViewById(R.id.apellidoTextField);
        DatePicker birth = findViewById(R.id.fechaNaciSPN);
        RadioButton yes = findViewById(R.id.yesRDBTN);
        RadioButton no = findViewById(R.id.noRDBTN);
        Spinner gender = findViewById(R.id.genderComboBox);

        CheckBox java = findViewById(R.id.javaCheck);
        CheckBox js = findViewById(R.id.jsCheck);
        CheckBox python = findViewById(R.id.pythonCheck);
        CheckBox c = findViewById(R.id.cCheck);
        CheckBox csharp = findViewById(R.id.csharpCheck);
        CheckBox go = findViewById(R.id.goCheck);

        nombre.setText("");
        apellido.setText("");
        birth.updateDate(2000,0,1);
        yes.setChecked(true);
        no.setChecked(false);
        gender.setSelection(0);
        java.setChecked(false);
        js.setChecked(false);
        python.setChecked(false);
        c.setChecked(false);
        csharp.setChecked(false);
        go.setChecked(false);

        Snackbar snackbar = Snackbar.make(view, "Se han limpiado los campos", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public boolean verifyFields(View view) {

        EditText nombre = findViewById(R.id.nombreTextField);
        EditText apellido = findViewById(R.id.apellidoTextField);
        RadioButton yes = findViewById(R.id.yesRDBTN);
        Spinner gender = findViewById(R.id.genderComboBox);

        CheckBox java = findViewById(R.id.javaCheck);
        CheckBox js = findViewById(R.id.jsCheck);
        CheckBox python = findViewById(R.id.pythonCheck);
        CheckBox c = findViewById(R.id.cCheck);
        CheckBox csharp = findViewById(R.id.csharpCheck);
        CheckBox go = findViewById(R.id.goCheck);

        Snackbar snackbar;

        if(nombre.getText().toString().trim().equals("")){
            snackbar = Snackbar.make(view, "Debe digitar su nombre", Snackbar.LENGTH_LONG);
            snackbar.show();
            return false;
        }else if(apellido.getText().toString().trim().equals("")){
            snackbar = Snackbar.make(view, "Debe digitar su apellido", Snackbar.LENGTH_LONG);
            snackbar.show();
            return false;
        }else if(gender.getSelectedItem().toString().equalsIgnoreCase("<Seleccione>")){
            snackbar = Snackbar.make(view, "Seleccione su género", Snackbar.LENGTH_LONG);
            snackbar.show();
            return false;
        }
        else if(yes.isChecked()){

            if(java.isChecked() || js.isChecked() || python.isChecked() || c.isChecked() || csharp.isChecked() || go.isChecked())
            {
                return true;
            }else{
                snackbar = Snackbar.make(view, "Elija los lenguajes que le gusten", Snackbar.LENGTH_LONG);
                snackbar.show();
                return false;
            }

        }
        else {
            return true;
        }

    }
}