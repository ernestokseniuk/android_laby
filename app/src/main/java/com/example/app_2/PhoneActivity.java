package com.example.app_2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app_2.databinding.ActivityMainBinding;
import com.example.app_2.databinding.ActivityPhoneBinding;

public class PhoneActivity extends AppCompatActivity {

    private ActivityPhoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        this.binding = ActivityPhoneBinding.inflate(this.getLayoutInflater());
        setContentView(this.binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(this.binding.phoneMain, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}