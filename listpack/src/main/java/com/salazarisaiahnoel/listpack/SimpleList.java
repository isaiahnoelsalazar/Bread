package com.salazarisaiahnoel.listpack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salazarisaiahnoel.listpack.adapters.SimpleListAdapter;

import java.util.List;

public class SimpleList {

    Context context;
    List<String> data;
    RecyclerView rv;
    LinearLayoutManager llm;
    SimpleListAdapter sla;
    int clickListener = 0;
    SimpleListAdapter.OnItemClickListener listener;
    SimpleListAdapter.OnItemLongClickListener listenerLong;

    public SimpleList(Context context, RecyclerView rv, List<String> data){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        clickListener = 0;
        refresh();
    }

    public SimpleList(Context context, RecyclerView rv, List<String> data, SimpleListAdapter.OnItemClickListener listener){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        clickListener = 1;
        this.listener = listener;
        refresh();
    }

    public SimpleList(Context context, RecyclerView rv, List<String> data, SimpleListAdapter.OnItemLongClickListener listenerLong){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        clickListener = 2;
        this.listenerLong = listenerLong;
        refresh();
    }

    public SimpleList(Context context, RecyclerView rv, List<String> data, SimpleListAdapter.OnItemClickListener listener, SimpleListAdapter.OnItemLongClickListener listenerLong){
        this.context = context;
        this.data = data;
        this.rv = rv;
        llm = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(llm);
        clickListener = 3;
        this.listener = listener;
        this.listenerLong = listenerLong;
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
        switch (clickListener){
            case 1:
                try {
                    int paddingAll = sla.getItemPadding();
                    int paddingLeft = sla.getItemPadding1();
                    int paddingTop = sla.getItemPadding2();
                    int paddingRight = sla.getItemPadding3();
                    int paddingBottom = sla.getItemPadding4();
                    boolean singlePadding = sla.getSinglePadding();
                    sla = new SimpleListAdapter(clickListener, data, listener);
                    rv.setAdapter(sla);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    sla = new SimpleListAdapter(clickListener, data, listener);
                    rv.setAdapter(sla);
                }
                break;
            case 2:
                try {
                    int paddingAll = sla.getItemPadding();
                    int paddingLeft = sla.getItemPadding1();
                    int paddingTop = sla.getItemPadding2();
                    int paddingRight = sla.getItemPadding3();
                    int paddingBottom = sla.getItemPadding4();
                    boolean singlePadding = sla.getSinglePadding();
                    sla = new SimpleListAdapter(clickListener, data, listenerLong);
                    rv.setAdapter(sla);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    sla = new SimpleListAdapter(clickListener, data, listenerLong);
                    rv.setAdapter(sla);
                }
                break;
            case 3:
                try {
                    int paddingAll = sla.getItemPadding();
                    int paddingLeft = sla.getItemPadding1();
                    int paddingTop = sla.getItemPadding2();
                    int paddingRight = sla.getItemPadding3();
                    int paddingBottom = sla.getItemPadding4();
                    boolean singlePadding = sla.getSinglePadding();
                    sla = new SimpleListAdapter(clickListener, data, listener, listenerLong);
                    rv.setAdapter(sla);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    sla = new SimpleListAdapter(clickListener, data, listener, listenerLong);
                    rv.setAdapter(sla);
                }
                break;
            default:
                try {
                    int paddingAll = sla.getItemPadding();
                    int paddingLeft = sla.getItemPadding1();
                    int paddingTop = sla.getItemPadding2();
                    int paddingRight = sla.getItemPadding3();
                    int paddingBottom = sla.getItemPadding4();
                    boolean singlePadding = sla.getSinglePadding();
                    sla = new SimpleListAdapter(clickListener, data);
                    rv.setAdapter(sla);
                    if (singlePadding){
                        setItemPadding(paddingAll);
                    } else {
                        setItemPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    }
                } catch (Exception ignored){
                    sla = new SimpleListAdapter(clickListener, data);
                    rv.setAdapter(sla);
                }
                break;
        }

    }

    public void setItemPadding(int value){
        sla.setItemPadding(value);
    }

    public void setItemPadding(int value1, int value2, int value3, int value4){
        sla.setItemPadding(value1, value2, value3, value4);
    }
}