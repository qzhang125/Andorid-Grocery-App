package com.example.map524_assignment1;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView storeName;
        TextView storeAddress;
        ImageView storeImage;
        ImageView checkImage;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            storeName = itemView.findViewById(R.id.textView10);
            storeName.setOnClickListener(this);
            storeAddress = itemView.findViewById(R.id.textView11);
            storeAddress.setOnClickListener(this);
            storeImage = itemView.findViewById(R.id.imageView5);
            storeImage.setOnClickListener(this);
            checkImage = itemView.findViewById(R.id.imageView6);
            checkImage.setOnClickListener(this);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.imageView5:
                    saveToGallery();
                    break;
            }
        }
        //Assignment 2B
        /*void showNameDialog() {
            AlertDialog.Builder nameAlert= new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            nameAlert.setTitle("Click information");
            nameAlert.setIcon(R.drawable.ic_baseline_info_24);
            nameAlert.setMessage("You clicked the store name");
            nameAlert.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            nameAlert.create().show();
        }*/
        /*void showAddressDialog(){
            AlertDialog.Builder addressAlert= new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            addressAlert.setTitle("Click information");
            addressAlert.setIcon(R.drawable.ic_baseline_info_24);
            addressAlert.setMessage("You clicked the store address");
            addressAlert.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            addressAlert.create().show();
        }*/
        /*void showIconDialog(){
            AlertDialog.Builder iconAlert= new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            iconAlert.setTitle("Click information");
            iconAlert.setIcon(R.drawable.ic_baseline_info_24);
            iconAlert.setMessage("You clicked the store logo");
            iconAlert.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            iconAlert.create().show();
        }*/
        /*void showStatusDialog(){
            AlertDialog.Builder statusAlert= new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            statusAlert.setTitle("Click information");
            statusAlert.setIcon(R.drawable.ic_baseline_info_24);
            statusAlert.setMessage("You clicked the status");
            statusAlert.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            statusAlert.create().show();
        }*/
        /*void showTheRow(){
            int index = getAdapterPosition();
            AlertDialog.Builder rowAlert= new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
            rowAlert.setTitle("Click information");
            rowAlert.setIcon(R.drawable.ic_baseline_info_24);
            rowAlert.setMessage("You clicked the " + storelist[index].storeName + " row.");
            rowAlert.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            rowAlert.create().show();
        }*/

        //Assignment 3
        void saveToGallery(){
            int index = getAdapterPosition();
            String fileName = storelist[index].storeName;

            BitmapDrawable drawable = (BitmapDrawable) storeImage.getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            MediaStore.Images.Media.insertImage(storeImage.getContext().getContentResolver(), bitmap,fileName,"Grocery stores" );
            Toast.makeText(storeName.getContext(),"Image has been saved in gallery", Toast.LENGTH_SHORT).show();
        }

    }
}
