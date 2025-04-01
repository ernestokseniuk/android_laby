package com.example.app_2.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Phone.class}, version = 1, exportSchema = false)
public abstract class PhoneRoomDatabase extends RoomDatabase {
    // Abstrakcyjna metoda zwracająca DAO
    public abstract PhoneDao phoneDao();

    // Implementacja singletona
    private static volatile PhoneRoomDatabase INSTANCE;

    public static PhoneRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PhoneRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PhoneRoomDatabase.class, "phone_database")
                            .addCallback(sRoomDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Usługa wykonawcza do wykonywania operacji w osobnym wątku
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // Callback do obsługi zdarzeń bazy danych
    private static final RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    // Upewnienie się, że INSTANCE jest już zainicjalizowane
                    databaseWriteExecutor.execute(() -> {

                            PhoneDao dao = INSTANCE.phoneDao();
                            dao.insert(new Phone("15","Google","Pixel 9","www.google.com"));

                    });
                }
            };
}
