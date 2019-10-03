package com.example.jimmy.magic;

import android.content.Intent;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    private Button calcButton;
    private Button noteButton;
    private Button shutdownButton;
    private Button logoutButton;
    private Button chromeButton;
    private Button spamMouse;
    private Button cliButton;

    private EditText urlText;
    private EditText CLIText;

    private String ip;
    private String url = "www.bing.com";
    private String cliCommand = "dir";

    private MagicClient Mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        MainActivity ma = new MainActivity();

        ip = getIntent().getStringExtra("key");

        urlText = (EditText) findViewById(R.id.URLText);
        CLIText = (EditText) findViewById(R.id.CLIText);

        Mc = new MagicClient(ip);
        new Thread(Mc).start();

        createButtons();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Mc.closeSocket();
    }

    public void createButtons() {
        calcButton = (Button) findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Mc.setCommand(1);
            }
        });

        noteButton = (Button) findViewById(R.id.noteButton);
        noteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Mc.setCommand(2);
            }
        });

        shutdownButton = (Button) findViewById(R.id.shutdownButton);
        shutdownButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Mc.setCommand(4);
            }
        });

        logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mc.setCommand(3);
            }
        });

        chromeButton = (Button) findViewById(R.id.chromeButton);
        chromeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                url = urlText.getEditableText().toString();
                Mc.setURL(url);
                Mc.setCommand(5);
            }
        });

        cliButton = (Button) findViewById(R.id.cliButton);
        cliButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                cliCommand = CLIText.getEditableText().toString();
                Mc.setCliCommand(cliCommand);
                Mc.setCommand(8);
            }
        });

        spamMouse = (Button) findViewById(R.id.SpamMouse);
        spamMouse.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Mc.setCommand(6);
            }
        });
    }

}
