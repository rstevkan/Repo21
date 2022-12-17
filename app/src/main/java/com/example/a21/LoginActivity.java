package com.example.a21;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public static final String USER_PASTE="user extra" ;
    public Button button;
    public EditText etUser;
    public EditText etPassword;
    public String textUser;
    public String textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }

        });
    }

    public void openActivity2() {

        textUser = etUser.getText().toString();
        textPassword=etPassword.getText().toString();

        if ((textUser.equalsIgnoreCase("steva"))
                &&(textPassword.equalsIgnoreCase("12345"))) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(USER_PASTE, textUser);
            startActivity(intent);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Incorrect user or password")
                    .setCancelable(false)
                    .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog alert=builder.create();
            alert.show();
           }
    }

    public void findViews(){
        button = (Button) findViewById(R.id.button);
        etUser = (EditText) findViewById(R.id.user);
        etPassword=(EditText) findViewById(R.id.password);

    }
}