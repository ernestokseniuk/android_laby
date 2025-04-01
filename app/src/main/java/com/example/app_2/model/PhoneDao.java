package com.example.app_2.model;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface PhoneDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Phone phone);

    @Query("select * from phones")
    LiveData<List<Phone>> findAllPhones();


    @Query("delete from phones")
    void deleteAllPhones();
}
