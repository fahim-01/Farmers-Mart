package com.example.materialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DashBoard extends AppCompatActivity implements View.OnClickListener  {

    private Button HistoryButton,expertIdButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        HistoryButton = findViewById(R.id.historyId);
        expertIdButton=findViewById(R.id.expertId);

        HistoryButton.setOnClickListener(this);
        expertIdButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.historyId:
            {

                Intent intent = new Intent(DashBoard.this,PreviosRecord.class);
                startActivity(intent);
                break;

            }
            case R.id.expertId:
            {

                Intent intent = new Intent(DashBoard.this, ExpertsAdvice.class);
                startActivity(intent);
                break;

            }

        }
    }
}
