package com.example.jimmy.magic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button goButton;
    private EditText IPinput;
    public TextView IPText;

    private String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IPinput = (EditText) findViewById(R.id.IPTextBar);
        IPText = (TextView) findViewById(R.id.IPtext);

        goButton = (Button) findViewById(R.id.GoButton);
        goButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ip = IPinput.getEditableText().toString();
                IPText.setText(ip);
                goToMenu();
            }
        });
    }

    public void goToMenu(){
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra("key",ip);
        startActivity(intent);
    }

}
