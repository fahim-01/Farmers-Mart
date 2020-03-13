package com.example.materialdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviosRecord extends AppCompatActivity {
    private ListView listView;
    private String[] previousRecord ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previos_record);
        listView =(ListView) findViewById(R.id.PreviousRecordListViewId);

        previousRecord = getResources().getStringArray(R.array.PreviousRecord);
        String[] itemsNamePrice = new String[previousRecord.length];
        for(int i = 0; i < previousRecord.length; i++){
            String[] arr = previousRecord[i].split(",");
            itemsNamePrice[i] ="    "+ arr[0] + "                                  " + arr[1]+" টাকা";
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.sample_view_previous_record,R.id.PreRecordtextViewId,itemsNamePrice);
        listView.setAdapter(adapter);

    }
}
