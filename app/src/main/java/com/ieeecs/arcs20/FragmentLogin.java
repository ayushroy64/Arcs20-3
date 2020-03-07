package com.ieeecs.arcs20;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentLogin extends AppCompatActivity {
    EditText username, password;
    ImageButton login;
    SharedPreferences sp;
    String loginstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        sp = getSharedPreferences("key",0);
        loginstatus = sp.getString("Login","0");
        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);

        try{
            if(loginstatus.equals("true")){
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                String uname = sp.getString("Username","");
                intent.putExtra("Username","uname");
                startActivity(intent);
                finish();
            }
        }
        catch (Exception e){}

        login = findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(uname.equals("admin")&&pass.equals("123")){

                    Intent intent = new Intent(FragmentLogin.this,MainActivity.class);
                    intent.putExtra("Username",uname);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Login","true");
                    editor.putString("Username",uname);
                    editor.putString("Password",pass);
                    editor.apply();
                    startActivity(intent);
                    finish();

                    Toast.makeText(FragmentLogin.this, "LOGIN SUCCESS",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
