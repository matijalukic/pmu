package kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Matija on 25 Jan 19.
 */


@Entity
public class Item {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;
    public String todo;

}
