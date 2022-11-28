package com.example.it_schoolandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.it_schoolandroid.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding binding;
    static String email;
    static String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NewClickListener listener = new NewClickListener();
        binding.register.setOnClickListener(listener);
        binding.password.getText();
        Log.i("RegisterData", "Registration process started");
    }

    public static String getEmail() {
        return email;
    }
    public static String getPassword() {
        return password;
    }

    class NewClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            email = binding.email.getText().toString();
            password = binding.password.getText().toString();
            if (email.contains("@") && password.length() > 8 && !(email == "rickroll@gmail.com" && password != "RickAstley")) {
                email = binding.email.getText().toString();
                Log.i("RegisterData", "email defined as " + email);
                password = binding.password.getText().toString();
                Log.i("RegisterData", "password defined as " + password);
                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intent);
                closeActivity();
            } else if (email == "rickroll@gmail.com") {
                Log.e("RegisterData", "Wrong password!");
            } else {
                Log.e("RegisterData", "Email or password are defined incorrectly");
            }
        }
    }

    private void closeActivity() {
        this.finish();
    }
}