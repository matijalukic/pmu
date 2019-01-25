package kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Matija on 25 Jan 19.
 */

@Database( entities = {Item.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase{
    public abstract DatabaseDao dbDao();
}
