package com.ieeecs.arcs20;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    ImageButton login;
    TextView signup;
    SharedPreferences sp;
    String loginstatus;
    SignUpFragment signUpFragment;

    RelativeLayout fragmentContainer;
    FragmentManager fragmentManager;
    LinearLayout prograssLayout;

    Boolean signUpFrag, loginStatus, otpFrag, passwordFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        sp = getSharedPreferences("key",0);
        loginstatus = sp.getString("Login","0");
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.sign_in_button);
        signup = findViewById(R.id.signup);

        fragmentContainer = findViewById(R.id.fragment_container);
        prograssLayout = findViewById(R.id.progress_layout);


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


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(uname.equals("admin")&&pass.equals("123")){

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("Username",uname);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Login","true");
                    editor.putString("Username",uname);
                    editor.putString("Password",pass);
                    editor.apply();
                    startActivity(intent);
                    finish();

                    Toast.makeText(LoginActivity.this, "LOGIN SUCCESS",Toast.LENGTH_LONG).show();
                }
            }
        });

        //Sign Up Process
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Starting SingUp Process
                fragmentManager = getSupportFragmentManager();
                fragmentContainer.setClickable(true);
                signUpFragment = new SignUpFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right);
                transaction.add(R.id.fragment_container,signUpFragment).commit();
                signUpFrag = true;
            }
        });
    }
}
