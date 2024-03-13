package com.salazarisaiahnoel.listpack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SimpleList {

    Context context;
    List<String> data;
    RecyclerView rv;
    LinearLayoutManager llm;
    SimpleListAdapter sla;

    public SimpleList(Context context, RecyclerView rv, List<String> data){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        refresh();
    }

    public void addItem(String a){
        data.add(a);
        refresh();
    }

    public void removeItem(int position){
        data.remove(position);
        refresh();
    }

    public List<String> getData(){
        return data;
    }

    void refresh(){
        sla = new SimpleListAdapter(data);
        rv.setAdapter(sla);
    }

    public void setItemPadding(int value){
        float scale = context.getResources().getDisplayMetrics().density;
        sla.setItemPadding((int) (value * scale + 0.5f));
    }

    public void setItemPadding(int value1, int value2, int value3, int value4){
        float scale = context.getResources().getDisplayMetrics().density;
        sla.setItemPadding((int) (value1 * scale + 0.5f), (int) (value2 * scale + 0.5f), (int) (value3 * scale + 0.5f), (int) (value4 * scale + 0.5f));
    }
}

class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.SimpleListHolder> {

    List<String> data;
    int itemPadding = 0, itemPadding1 = 0, itemPadding2 = 0, itemPadding3 = 0, itemPadding4 = 0;
    boolean singlePadding = false;

    public SimpleListAdapter(List<String> data){
        this.data = data;
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
        if (singlePadding){
            slh.button.setPadding(itemPadding, itemPadding, itemPadding, itemPadding);
        } else {
            slh.button.setPadding(itemPadding1, itemPadding2, itemPadding3, itemPadding4);
        }
        return slh;
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleListHolder holder, int position) {
        holder.button.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SimpleListHolder extends RecyclerView.ViewHolder{

        Button button;

        public SimpleListHolder(@NonNull View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.simple_list_item_id);
        }
    }
}