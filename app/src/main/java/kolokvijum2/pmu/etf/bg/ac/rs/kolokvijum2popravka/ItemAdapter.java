package kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kolokvijum2.pmu.etf.bg.ac.rs.kolokvijum2popravka.db.Item;

/**
 * Created by Matija on 25 Jan 19.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private List<Item> items = new ArrayList<>();


    class ItemHolder extends RecyclerView.ViewHolder {
        private TextView mTextName;
        private TextView mTextTodo;

        public ItemHolder(View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.item_name);
            mTextTodo = itemView.findViewById(R.id.item_todo);
        }
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item, parent, false);

        return new ItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Item currItem = items.get(position);
        holder.mTextName.setText(currItem.name);
        holder.mTextTodo.setText(currItem.todo);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
