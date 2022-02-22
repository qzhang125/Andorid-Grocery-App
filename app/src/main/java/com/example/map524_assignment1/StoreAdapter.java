package com.example.map524_assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StoreAdapter extends BaseAdapter {
    Stores[] stores;
    Context context;
    StoreAdapter(Stores [] stores, Context context){
        this.stores = stores;
        this.context = context;
    }
    @Override
    public int getCount() {
        return stores.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.store_layout, viewGroup, false);
        TextView storeName = view.findViewById(R.id.textView4);
        TextView storeAddress = view.findViewById(R.id.textView6);
        ImageView storeImage = view.findViewById(R.id.imageView2);
        ImageView checkImage = view.findViewById(R.id.imageView3);
        storeName.setText(stores[i].storeName);
        storeAddress.setText(stores[i].address);
        storeImage.setImageBitmap(stores[i].image);
        checkImage.setImageBitmap(stores[i].checkImg);

        return view;
    }
}
