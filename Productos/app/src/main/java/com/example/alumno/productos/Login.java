package com.example.alumno.productos;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements Handler.Callback, View.OnClickListener {
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        handler = new Handler(this);

        Button btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);

    }

    @Override
    public boolean handleMessage(Message msg) {
        try {
            JSONObject json = new JSONObject((String) msg.obj);
            String tipo = json.getString("type");
            if (!("error".equals(tipo))){
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("tipo", tipo);
                startActivity(i);
                finish();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        EditText etUser = (EditText) findViewById(R.id.etUser);
        EditText etClave = (EditText) findViewById(R.id.etClave);
        LoginThread thread = new LoginThread(handler, etUser, etClave);
        thread.start();
    }
}
