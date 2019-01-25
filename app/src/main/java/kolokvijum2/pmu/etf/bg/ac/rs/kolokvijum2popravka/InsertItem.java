package kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka;

import android.os.AsyncTask;

import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.AppDatabase;
import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.DatabaseDao;
import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.Item;

/**
 * Created by Matija on 25 Jan 19.
 */
public class InsertItem extends AsyncTask<Item, Object, Object> {

    private DatabaseDao dbDao;

    public InsertItem(DatabaseDao mDB) {
        this.dbDao = mDB;
    }

    @Override
    protected Object doInBackground(Item... items) {
        for(Item item: items)
            dbDao.insert(item);

        return null;
    }


}
