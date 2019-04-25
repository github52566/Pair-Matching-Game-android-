package com.example.asus.pairmatchinggame;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DbActivity extends AppCompatActivity {
    EditText player_name,score_final;
    TextView textView;
    DB_Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        player_name=(EditText)findViewById(R.id.player_name);
        score_final=(EditText)findViewById(R.id.score_final);
        textView=(TextView)findViewById(R.id.textView);
        controller=new DB_Controller(this," ",null,4);
    }

    public void btn_click(View view) {
        switch (view.getId()){
            case R.id.button_add:
                try {

                }catch  (SQLiteException e){
                    Toast.makeText(DbActivity.this,"ALREADY EXISTS",Toast.LENGTH_SHORT).show();
                }
                controller.insert_player(player_name.getText().toString(),score_final.getText().toString());
                break;
            case R.id.button_delete:
                controller.delete_player(player_name.getText().toString());
                break;
            case R.id.button_update:
                AlertDialog.Builder dialog=new AlertDialog.Builder(DbActivity.this);
                dialog.setTitle("ENTER NEW PLAYER_NAME");

                final EditText new_player_name=new EditText(this);
                dialog.setView(new_player_name);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        controller.update_player(player_name.getText().toString(),new_player_name.getText().toString());

                    }
                });
                dialog.show();
                break;
            case R.id.list_name:
                controller.list_all_players(textView);

                break;
        }
    }
}

