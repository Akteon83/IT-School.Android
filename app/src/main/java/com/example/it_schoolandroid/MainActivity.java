package com.example.it_schoolandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import com.example.it_schoolandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final TaskCreator taskCreator = new TaskCreator();
    int correctOption = R.id.button_1;
    int count;
    int difficulty = MenuActivity.getDifficulty();
    MyTimer timer = new MyTimer(30000, 1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        generateTask();
        MyClickListener listener = new MyClickListener();
        timer.start();
        binding.button1.setOnClickListener(listener);
        binding.button2.setOnClickListener(listener);
        binding.button3.setOnClickListener(listener);
    }

    private void generateTask() {
        taskCreator.createNewTask(difficulty);
        binding.task.setText(taskCreator.getTask());
        switch (taskCreator.random.nextInt(3)) {
            case 0:
                binding.option1.setText(String.valueOf(taskCreator.getAnswer()));
                binding.option2.setText(String.valueOf(taskCreator.getFakeAnswer()));
                binding.option3.setText(String.valueOf(taskCreator.getFakeAnswer()));
                correctOption = R.id.button_1;
                break;
            case 1:
                binding.option1.setText(String.valueOf(taskCreator.getFakeAnswer()));
                binding.option2.setText(String.valueOf(taskCreator.getAnswer()));
                binding.option3.setText(String.valueOf(taskCreator.getFakeAnswer()));
                correctOption = R.id.button_2;
                break;
            case 2:
                binding.option1.setText(String.valueOf(taskCreator.getFakeAnswer()));
                binding.option2.setText(String.valueOf(taskCreator.getFakeAnswer()));
                binding.option3.setText(String.valueOf(taskCreator.getAnswer()));
                correctOption = R.id.button_3;
                break;
        }
    }

    class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == correctOption) {
                ++count;
                binding.count.setText("Счёт: " + count);
                generateTask();
            } else {
                Toast.makeText(MainActivity.this, "Неверный ответ!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                closeActivity();
            }
        }
    }

    class MyTimer extends CountDownTimer {

        public MyTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {
            binding.timer.setText(l >= 10000 ? "00:" + l / 1000 : "00:0" + l / 1000);
        }

        @Override
        public void onFinish() {
            Toast.makeText(MainActivity.this, "Время вышло!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
            closeActivity();
        }
    }

    private void closeActivity() {
        this.finish();
        timer.cancel();
    }
}