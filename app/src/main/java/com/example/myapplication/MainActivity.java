package com.example.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{
    Button  BTCN,BTT;
    EditText TVT,mail;
    RadioButton BTN,BTN2;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BTT =  (Button)findViewById(R.id.BTT);
        BTCN =  (Button)findViewById(R.id.BTCN);
        TVT =  (EditText)findViewById(R.id.TVT);
        mail =  (EditText)findViewById(R.id.mail);
        BTN2 =  (RadioButton) findViewById(R.id.BTN2);
        BTN =  (RadioButton) findViewById(R.id.BTN);
        spinner = (Spinner)findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


        BTT.setOnClickListener(new View.OnClickListener() {
            // thực thi phương thức callback onClick
            public void onClick(View v) {
                // nội dung thực thi
                cancel(v);
            }
        });

        BTCN.setOnClickListener(new View.OnClickListener() {
            // thực thi phương thức callback onClick
            public void onClick(View v) {
                String msg = "My name: " + TVT.getText().toString() +
                        System.getProperty("line.separator") +
                        "Email: " + mail.getText().toString();
                if(BTN2.isChecked())
                    msg += BTN2.getText().toString();
                else
                    msg += BTN.getText().toString();

                msg += System.getProperty("line.separator") + "My language: " +
                        spinner.getSelectedItem().toString();
                // nội dung thực thi
                info(v,msg);
                TVT.setText("");
                mail.setText("");
            }
        });

    }

    public void cancel(View v){
        System.exit(0);
    }

    public void info (View v, String msg){
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("My First App");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
