package com.example.materialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FloatingActionButton fab;
    private Button bazardorButton, jogajogbutton, nijerhisab, proshnobank,sobarmajheamiButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bazardorButton = findViewById(R.id.bazardorbuttonId);
        jogajogbutton = findViewById(R.id.jugajugbuttonId);
        nijerhisab = findViewById(R.id.bektigotohisabId);
        proshnobank = findViewById(R.id.proshnobankId);
        sobarmajheamiButton=findViewById(R.id.sobar_majhe_ami_Id);

        bazardorButton.setOnClickListener(this);
        jogajogbutton.setOnClickListener(this);
        nijerhisab.setOnClickListener(this);
        proshnobank.setOnClickListener(this);
        sobarmajheamiButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.bazardorbuttonId: {

                Intent intent = new Intent(MainActivity.this, BazarDor.class);
                startActivity(intent);
                break;

            }

            case R.id.bektigotohisabId: {

                Intent intent = new Intent(MainActivity.this, DashBoard.class);
                startActivity(intent);
                break;

            }
            case R.id.sobar_majhe_ami_Id: {

                Intent intent = new Intent(MainActivity.this, Sobar_majhe_ami.class);
                startActivity(intent);
                break;

            }

        }
    }
}




