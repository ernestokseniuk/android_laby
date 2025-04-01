package com.example.app_2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.app_2.model.Phone;
import com.example.app_2.model.PhoneRepository;

import java.util.List;

public class PhoneViewModel {
    private final PhoneRepository repository;
    private final LiveData<List<Phone>> allPhones;

    public PhoneViewModel(@NonNull Application application) {
        this.repository = new PhoneRepository(application);
        this.allPhones = this.repository.findAllPhones();
    }

    public LiveData<List<Phone>> getAllPhones(){
        return this.allPhones;
    }

    public void deleteAllPhones(){
        this.repository.deleteAllPones();
    }
}
