package com.example.app_2;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PhoneRepository {

    private final PhoneDao phoneDao;
    private final LiveData<List<Phone>> allPhones;

    public PhoneRepository(Context context) {
        this.phoneDao = PhoneRoomDatabase.getDatabase(context).phoneDao();
        this.allPhones = this.phoneDao.findAllPhones();
    }

    public LiveData<List<Phone>> findAllPhones(){
        return this.allPhones;
    }

    public void deleteAllPones(){
        PhoneRoomDatabase.databaseWriteExecutor.execute(this.phoneDao::deleteAllPhones);
    }

}
