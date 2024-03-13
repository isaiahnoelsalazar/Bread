package com.salazarisaiahnoel.listpack.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarisaiahnoel.listpack.R;

import java.util.List;

public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.SimpleListHolder>{
    List<String> data;
    int itemPadding = 0, itemPadding1 = 0, itemPadding2 = 0, itemPadding3 = 0, itemPadding4 = 0;
    boolean singlePadding = false;

    int clickListener = 0;

    OnItemClickListener listener;
    OnItemLongClickListener listenerLong;

    public SimpleListAdapter(int clickListener, List<String> data){
        this.data = data;
        this.clickListener = clickListener;
    }

    public int getItemPadding(){
        return itemPadding;
    }
    public int getItemPadding1(){
        return itemPadding1;
    }
    public int getItemPadding2(){
        return itemPadding2;
    }
    public int getItemPadding3(){
        return itemPadding3;
    }
    public int getItemPadding4(){
        return itemPadding4;
    }
    public boolean getSinglePadding(){
        return singlePadding;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListAdapter.OnItemClickListener listener){
        this.data = data;
        this.listener = listener;
        this.clickListener = clickListener;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListAdapter.OnItemLongClickListener listenerLong){
        this.data = data;
        this.listenerLong = listenerLong;
        this.clickListener = clickListener;
    }

    public SimpleListAdapter(int clickListener, List<String> data, SimpleListAdapter.OnItemClickListener listener, SimpleListAdapter.OnItemLongClickListener listenerLong){
        this.data = data;
        this.listener = listener;
        this.listenerLong = listenerLong;
        this.clickListener = clickListener;
    }

    public void setItemPadding(int value){
        singlePadding = true;
        itemPadding = value;
    }

    public void setItemPadding(int value1, int value2, int value3, int value4){
        singlePadding = false;
        itemPadding1 = value1;
        itemPadding2 = value2;
        itemPadding3 = value3;
        itemPadding4 = value4;
    }

    @NonNull
    @Override
    public SimpleListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item, parent, false);
        SimpleListHolder slh = new SimpleListHolder(v);
        switch (clickListener){
            case 1:
                slh = new SimpleListHolder(v, listener);
                break;
            case 2:
                slh = new SimpleListHolder(v, listenerLong);
                break;
            case 3:
                slh = new SimpleListHolder(v, listener, listenerLong);
                break;
        }
        float scale = parent.getContext().getResources().getDisplayMetrics().density;
        if (singlePadding){
            slh.button.setPadding((int) (itemPadding * scale + 0.5f), (int) (itemPadding * scale + 0.5f), (int) (itemPadding * scale + 0.5f), (int) (itemPadding * scale + 0.5f));
        } else {
            slh.button.setPadding((int) (itemPadding1 * scale + 0.5f), (int) (itemPadding2 * scale + 0.5f), (int) (itemPadding3 * scale + 0.5f), (int) (itemPadding4 * scale + 0.5f));
        }
        return slh;
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleListHolder holder, int position) {
        holder.button.setText(data.get(position));
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(int position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SimpleListHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        Button button;
        OnItemClickListener listener;
        OnItemLongClickListener listenerLong;

        public SimpleListHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);

            itemView.setOnClickListener(null);
            itemView.setOnLongClickListener(null);
        }

        public SimpleListHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);

            this.listener = listener;

            itemView.setOnClickListener(this);
        }

        public SimpleListHolder(@NonNull View itemView, OnItemLongClickListener listenerLong) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);

            this.listenerLong = listenerLong;

            itemView.setOnLongClickListener(this);
        }

        public SimpleListHolder(@NonNull View itemView, OnItemClickListener listener, OnItemLongClickListener listenerLong) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);

            this.listener = listener;
            this.listenerLong = listenerLong;

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            listenerLong.onItemLongClick(getAdapterPosition());
            return true;
        }
    }
}
