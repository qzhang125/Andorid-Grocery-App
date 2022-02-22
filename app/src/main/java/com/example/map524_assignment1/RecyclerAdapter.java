package com.example.map524_assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    Context context;
    Stores[] storelist;
    RecyclerAdapter(Context context, Stores[] stores){
        this.context = context;
        this.storelist = stores;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_row_layout,parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.storeName.setText(storelist[position].storeName);
        holder.storeAddress.setText(storelist[position].address);
        holder.storeImage.setImageBitmap(storelist[position].image);
        holder.checkImage.setImageBitmap(storelist[position].checkImg);
    }

    @Override
    public int getItemCount() {
        return storelist.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView storeName;
        TextView storeAddress;
        ImageView storeImage;
        ImageView checkImage;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            storeName = itemView.findViewById(R.id.textView10);
            storeAddress = itemView.findViewById(R.id.textView11);
            storeImage = itemView.findViewById(R.id.imageView5);
            checkImage = itemView.findViewById(R.id.imageView6);
        }
    }
}
