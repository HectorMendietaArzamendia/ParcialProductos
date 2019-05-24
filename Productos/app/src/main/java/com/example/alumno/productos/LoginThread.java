package com.example.alumno.productos;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;

import java.io.IOException;

/**
 * Created by alumno on 23/05/2019.
 */

public class LoginThread extends Thread {
    private Handler handler;
    private EditText etUser;
    private  EditText etClave;

    public LoginThread(Handler handler, EditText etUser, EditText etClave) {
        this.handler = handler;
        this.etUser = etUser;
        this.etClave = etClave;
    }

    @Override
    public void run(){
        String json = null;
        HttpConection conn = new HttpConection("GET");

        try {
            json = conn.getStringData("http://192.168.2.182:3000/login/" + etUser.getText() + "/" + etClave.getText());
            Message mensaje = new Message();
            mensaje.obj = json;
            handler.sendMessage(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
