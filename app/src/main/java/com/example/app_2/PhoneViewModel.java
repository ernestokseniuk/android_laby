package com.example.app_2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.app_2.model.Phone;
import com.example.app_2.model.PhoneRepository;

import java.util.List;

public class PhoneViewModel extends AndroidViewModel {
    private final PhoneRepository repository;
    private final LiveData<List<Phone>> allPhones;

    public PhoneViewModel(@NonNull Application application) {
        super(application);
        this.repository = new PhoneRepository(application); // Jeśli repozytorium wymaga aplikacji w konstruktorze
        this.allPhones = this.repository.findAllPhones();
    }

    public LiveData<List<Phone>> getAllPhones(){
        return this.allPhones;
    }

    public void deleteAllPhones(){
        this.repository.deleteAllPhones(); // Poprawiona metoda
    }
}
