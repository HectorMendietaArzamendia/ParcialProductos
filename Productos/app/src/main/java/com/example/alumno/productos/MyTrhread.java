package com.example.alumno.productos;


import android.os.Handler;
import android.os.Message;

import java.io.IOException;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyTrhread extends Thread {
    Handler handler;

    public MyTrhread(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run(){
        String xml = null;
        HttpConection conn = new HttpConection("GET");
        try {
            xml = conn.getStringData("http://192.168.2.180:8080/productos.xml"); //http://192.168.2.166:8080/productos.xml
            Message mensaje = new Message();
            mensaje.obj = xml;
            handler.sendMessage(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
