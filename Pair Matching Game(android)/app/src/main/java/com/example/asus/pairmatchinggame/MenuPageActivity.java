package com.example.asus.pairmatchinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuPageActivity extends AppCompatActivity {
    Button btnsub2,btnsub3,btnsub4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        btnsub2 = (Button) findViewById(R.id.buttonsub2);
        btnsub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuPageActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnsub3 = (Button) findViewById(R.id.buttonsub3);
        btnsub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuPageActivity.this, DbActivity.class);
                startActivity(i);
            }
        });
        btnsub4=(Button)findViewById(R.id.buttonsub4);
        btnsub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuPageActivity.this, HomePageActivity.class);
                startActivity(i);
            }
        });
    }
}
