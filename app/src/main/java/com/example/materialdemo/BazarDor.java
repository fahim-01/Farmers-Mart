package com.example.materialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class BazarDor extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView ;
    private String[] itemDetails ;


    int[] pic = {R.drawable.amon,R.drawable.amon2,R.drawable.amon3,R.drawable.amon4,
            R.drawable.iri1,R.drawable.iri2,R.drawable.amon3,R.drawable.iri3,
            R.drawable.amon,R.drawable.amon2,R.drawable.amon3,R.drawable.amon4,
            R.drawable.iri1,R.drawable.iri2,R.drawable.amon3,R.drawable.iri3,
            R.drawable.amon,R.drawable.amon2,R.drawable.amon3,R.drawable.amon4,
            R.drawable.iri1,R.drawable.iri2,R.drawable.amon3,R.drawable.iri3,
            R.drawable.amon,R.drawable.amon2,R.drawable.amon3,R.drawable.amon4,
            R.drawable.iri1,R.drawable.iri2,R.drawable.amon3,R.drawable.iri3,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bazar_dor);






        itemDetails = getResources().getStringArray(R.array.item_name);
        String[] itemsNamePrice = new String[itemDetails.length];
        for(int i = 0; i < itemDetails.length; i++){
            String[] arr = itemDetails[i].split(",");
            itemsNamePrice[i] = arr[0] + "      " + "৳ " + arr[1] + "/মন";
        }

        listView = findViewById(R.id.bazardor_listview_id);
        CustomAdapter adapter = new CustomAdapter(this,itemsNamePrice,pic);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent(BazarDor.this,PreviosRecord.class);
        startActivity(intent);
    }
}
