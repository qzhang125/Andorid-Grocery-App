package com.example.map524_assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class StorePageActivity extends AppCompatActivity {
    RecyclerView reyView;
    TextView nameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_page);
        reyView= findViewById(R.id.recyclerView);

        //Load store logo
        Bitmap image1 = BitmapFactory.decodeResource(this.getResources(),R.drawable.walmart);
        Bitmap image2 = BitmapFactory.decodeResource(this.getResources(),R.drawable.freshco);
        Bitmap image3 = BitmapFactory.decodeResource(this.getResources(),R.drawable.superstore);
        Bitmap image4 = BitmapFactory.decodeResource(this.getResources(),R.drawable.foodbasics);
        Bitmap image5 = BitmapFactory.decodeResource(this.getResources(),R.drawable.walmart);
        Bitmap image6 = BitmapFactory.decodeResource(this.getResources(),R.drawable.freshco);
        Bitmap image7 = BitmapFactory.decodeResource(this.getResources(),R.drawable.superstore);
        Bitmap image8 = BitmapFactory.decodeResource(this.getResources(),R.drawable.foodbasics);
        Bitmap image9 = BitmapFactory.decodeResource(this.getResources(),R.drawable.walmart);
        Bitmap image10 = BitmapFactory.decodeResource(this.getResources(),R.drawable.freshco);

        //Load check box image
        Bitmap checkImg = BitmapFactory.decodeResource(this.getResources(),R.drawable.check);
        Bitmap unCheckImg = BitmapFactory.decodeResource(this.getResources(),R.drawable.uncheck);

        //Create 10 stores
        Stores store1 = new Stores("Walmart", "12 Leslie, Toronto, ON", image1);
        Stores store2 = new Stores("Freshco", "34 Markham Rd, Markham, ON", image2);
        Stores store3 = new Stores("Canadian Superstore", "55 Adam Road, Richmond Hill, ON", image3);
        Stores store4 = new Stores("Food Basics", "9 Young Road, Newmarket, ON", image4);
        Stores store5 = new Stores("Dollarama", "34 Markham Rd, Markham, ON", image5);
        Stores store6 = new Stores("Dollar Tree", "55 Adam Road, Richmond Hill, ON", image6);
        Stores store7 = new Stores("Spinneys", "9 Young Road, Newmarket, ON", image7);
        Stores store8 = new Stores("Home Depot", "12 Leslie, Toronto, ON", image8);
        Stores store9 = new Stores("Canadian Tire", "55 Adam Road, Richmond Hill, ON", image9);
        Stores store10 = new Stores("Costco", "12 Leslie, Toronto, ON", image10);


        //Assign these stores into an array
        Stores[] stores = {store1,store2,store3, store4, store5,
                store6, store7, store8, store9, store10};

        //Set the check box tobe green or grey, depends on the random status value
        for(int i = 0; i < stores.length; i++){
            if(stores[i].status == 1){
                stores[i].setCheckBox(checkImg);
            }else if(stores[i].status == 0){
                stores[i].setCheckBox(unCheckImg);
            }
        }

        //get user name
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        nameText = findViewById(R.id.textView8);
        nameText.setText("Hello " + name);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, stores);
        reyView.setAdapter(recyclerAdapter);
        reyView.setLayoutManager(new LinearLayoutManager(this));
    }
}