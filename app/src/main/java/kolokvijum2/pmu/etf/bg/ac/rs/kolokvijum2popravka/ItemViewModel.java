package kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.Nullable;

import java.util.List;

import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.AppDatabase;
import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.DatabaseDao;
import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.Item;

/**
 * Created by Matija on 25 Jan 19.
 */

public class ItemViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;
    private LiveData<List<Item>> items;

    public ItemViewModel(@Nullable Application application) {
        super(application);
        this.appDatabase = Room.databaseBuilder(application, AppDatabase.class, "items").fallbackToDestructiveMigration().build();
        this.items = appDatabase.dbDao().getAll();
    }

    public LiveData<List<Item>> getItems() {
        return items;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }


}
