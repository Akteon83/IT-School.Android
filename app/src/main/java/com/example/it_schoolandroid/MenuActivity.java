package com.example.it_schoolandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.it_schoolandroid.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {

    private ActivityMenuBinding binding;
    static int difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NewClickListener listener = new NewClickListener();
        binding.difficultyLow.setOnClickListener(listener);
        binding.difficultyMedium.setOnClickListener(listener);
        binding.difficultyHigh.setOnClickListener(listener);
    }

    public static int getDifficulty() {
        return difficulty;
    }

    class NewClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.difficulty_low:
                    difficulty = 0;
                    break;
                case R.id.difficulty_medium:
                    difficulty = 1;
                    break;
                case R.id.difficulty_high:
                    difficulty = 2;
                    break;
            }
            Intent intent = new Intent(MenuActivity.this, MainActivity.class);
            startActivity(intent);
            closeActivity();
        }
    }

    private void closeActivity() {
        this.finish();
    }
}