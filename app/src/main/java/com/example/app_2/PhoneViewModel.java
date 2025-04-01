package com.example.app_2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.app_2.model.Phone;
import com.example.app_2.model.PhoneRepository;

import java.util.List;

public class PhoneViewModel {
    private PhoneRepository repository;
    private LiveData<List<Phone>> allPhones;

    public PhoneViewModel(@NonNull Application application) {
        this.repository = new PhoneRepository(application);

    }
}
