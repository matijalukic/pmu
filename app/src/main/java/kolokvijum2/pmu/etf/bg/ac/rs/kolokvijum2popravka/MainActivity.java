package kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.AppDatabase;
import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.Item;

public class MainActivity extends AppCompatActivity {

    private EditText nameEdit, todoEdit;
    private Button addItem;
    private RecyclerView mListView;
    private List<String> itemList;
    private ItemViewModel items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameEdit = findViewById(R.id.edit_name);
        todoEdit = findViewById(R.id.edit_todo);
        mListView = findViewById(R.id.items);
        mListView.setLayoutManager(new LinearLayoutManager(this));
        items = ViewModelProviders.of(this).get(ItemViewModel.class);

        final ItemAdapter itemAdapter = new ItemAdapter();
        mListView.setAdapter(itemAdapter);


        itemList = new ArrayList<>();
        items.getItems().observeForever(new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                itemAdapter.setItems(items);
            }
        });

    }

    public void submitItem(View view) {
        String name = nameEdit.getText().toString();
        String todo = todoEdit.getText().toString();

        Item newItem = new Item();
        newItem.name = name;
        newItem.todo = todo;

        // run async taks
        new InsertItem(items.getAppDatabase().dbDao()).execute(newItem);

    }
}
