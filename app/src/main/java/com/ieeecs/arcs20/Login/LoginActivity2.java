package com.ieeecs.arcs20.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ieeecs.arcs20.APIClient;
import com.ieeecs.arcs20.APIInterface;
import com.ieeecs.arcs20.MainActivity;
import com.ieeecs.arcs20.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity2 extends AppCompatActivity {

    TextView signUpText,alertText;
    ImageButton continueButton;
    EditText emailID, password;
    RelativeLayout fragmentContainer;
    ProgressBar progressBar;
    FragmentManager fragmentManager;
    SignUpFragment signUpFragment;
    ImageView arcsLogo;
    Boolean signUpFrag, loginStatus, otpFrag, passwordFrag;
    SharedPreferences sp;
    String USERNAME = "USERNAME";

    LinearLayout progressLayout, signUpField;
    TextView arcsText, forgotPassword, signingIn;


    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        continueButton = findViewById(R.id.sign_in_button);
        signUpText = findViewById(R.id.signup);
        emailID = findViewById(R.id.email);
        password = findViewById(R.id.password);
        fragmentContainer = findViewById(R.id.fragment_container);
        progressBar = findViewById(R.id.progress_bar);
        progressLayout = findViewById(R.id.progress_layout);
        alertText = findViewById(R.id.alert_text);



        signUpFrag = loginStatus = otpFrag = false;

        apiInterface = APIClient.getClient().create(APIInterface.class);            //API client interface

        //Initialising SP
        sp = getSharedPreferences("key", 0);

        //Getting the login session status
        loginStatus = sp.getBoolean("loginStatus",false);

        //Login Status Check
        try {
            if (loginStatus) {
                Intent intent = new Intent(LoginActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
        catch(Exception e){}


        //Flag variables for active fragment
        signUpFrag = false;

        //Login Process
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Closing the keyboard
                try {
                    InputMethodManager inputManager = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                }
                catch (Exception e){}
                login();
            }
        });


        //Sign Up Process
        signUpText.setOnClickListener(new View.OnClickListener() {
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

    void login()
    {
        String email = emailID.getText().toString();
        String pass = password.getText().toString();

        if (email.isEmpty()) {
            emailID.setError("Email is required");
            emailID.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailID.setError("Please enter a valid email");
            emailID.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            password.setError("Password is required");
            password.requestFocus();
            return;
        }

        if (pass.length() < 8) {
            password.setError("Minimum length of password should be 8");
            password.requestFocus();
            return;
        }


        Call<HashMap<String, Boolean>> call = apiInterface.loginUser(emailID.getText().toString(),password.getText().toString());
        progressBar.setVisibility(View.VISIBLE);
        signingIn.setVisibility(View.VISIBLE);
        continueButton.setEnabled(false);
        signUpText.setEnabled(false);
        call.enqueue(new Callback<HashMap<String, Boolean>>() {
            @Override
            public void onResponse(Call<HashMap<String, Boolean>> call, Response<HashMap<String, Boolean>> response) {
                //On successful login
                HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
                hashMap = response.body();

                if(hashMap.get("success")) {
                    SharedPreferences.Editor editor = sp.edit();
                    String jwtToken = response.headers().get("Token");
                    editor.putString("jwtToken",jwtToken);                           //JWT Token
                    editor.putBoolean("loginStatus", true);                       //Login Session set to true
                    editor.putString("email", emailID.getText().toString());         //Email
                    editor.putString("password", password.getText().toString());     //Password
                    editor.apply();

                    Log.e("JWTToken",jwtToken);

                    //Initialising the username
                    editor.putString("username", USERNAME);
                    progressBar.setVisibility(View.GONE);
                    signingIn.setVisibility(View.GONE);
                    finish();
                    startActivity(new Intent(LoginActivity2.this, MainActivity.class));

                }
                else
                {
                    progressBar.setVisibility(View.GONE);
                    signingIn.setVisibility(View.GONE);
                    continueButton.setEnabled(true);
                    signUpText.setEnabled(true);
                    Toast.makeText(getApplicationContext(),"Username or Password may be wrong !", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<HashMap<String, Boolean>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"An error has occurred...!", Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.GONE);
                signingIn.setVisibility(View.GONE);
                continueButton.setEnabled(true);
                signUpText.setEnabled(true);
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(signUpFrag)
        {
            //Removing SignUp fragment to Login Activity
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right);
            transaction.remove(signUpFragment).commit();
            fragmentContainer.setClickable(false);
            signUpFrag = false;
        }
        else if(otpFrag)
        {
            //Removing SignUp fragment to Login Activity
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_from_right);
            transaction.remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container)).commit();
            fragmentContainer.setClickable(false);
            otpFrag = false;
        }
        else
            super.onBackPressed();
    }
}