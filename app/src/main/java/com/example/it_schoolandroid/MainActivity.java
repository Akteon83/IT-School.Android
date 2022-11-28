package com.example.it_schoolandroid;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.it_schoolandroid.databinding.ActivityMainBinding;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        MyClickListener listener = new MyClickListener();
        binding.makePhoto.setOnClickListener(listener);
        binding.hello.setText("Привет, " + MenuActivity.getEmail());
        Log.i("RegisterData", "Main Activity opened");
    }

    private static final int PHOTO_REQUEST_CODE = 1;

    class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.i("RegisterData", "Looking for a photo");
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PHOTO_REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PHOTO_REQUEST_CODE:
                    Uri selectedImage = data.getData();
                    try {
                        InputStream imageStream = getContentResolver().openInputStream(selectedImage);
                        Bitmap neededImage = BitmapFactory.decodeStream(imageStream);
                        binding.beautifulPicture.setImageBitmap(neededImage);
                        Log.i("RegisterData", "Image chosen and set");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Log.e("RegisterData", "You somehow caught an exception");
                    }
            }
        }
    }
}