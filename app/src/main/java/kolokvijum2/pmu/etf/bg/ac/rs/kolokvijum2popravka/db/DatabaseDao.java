package kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.RoomDatabase;

import java.util.List;

/**
 * Created by Matija on 25 Jan 19.
 */
@Dao
public interface DatabaseDao{
    @Query("SELECT * FROM Item ORDER BY id DESC")
    public LiveData<List<Item>> getAll();

    @Insert
    public void insert(Item item);
}
