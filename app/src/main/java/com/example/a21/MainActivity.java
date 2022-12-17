package com.example.a21;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent=getIntent();

        String text=intent.getStringExtra(LoginActivity.USER_PASTE);

        getSupportActionBar().setTitle("Welcome"+" "+text);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                AlertDialog.Builder myDialog=new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("Weight in kilograms? example 21.6");

                final EditText weightInput=new EditText(MainActivity.this);
                weightInput.setInputType(InputType.TYPE_CLASS_PHONE );
                myDialog.setView(weightInput);

                myDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        myText=weightInput.getText().toString();
                        Toast.makeText(MainActivity.this, "Weight is"+myText, Toast.LENGTH_LONG).show();


                    }
                });

                myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                myDialog.show();



            default: return super.onOptionsItemSelected(item);   }

    }
}