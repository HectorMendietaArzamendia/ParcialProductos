package com.example.alumno.productos;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class XmlParser {

    public static List<Producto> obtenerProductos(String xml){
        List<Producto> productos = new ArrayList<Producto>();
        Producto p = null;

        XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            xmlPullParser.setInput(new StringReader(xml));
            int event = xmlPullParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){
                if(event == XmlPullParser.START_TAG){
                    if("producto".equals(xmlPullParser.getName())){
                        p = new Producto();
                    }
                    if("id".equals(xmlPullParser.getName())){
                        if(p != null) p.setId(Integer.valueOf(xmlPullParser.nextText()));
                    }
                    if("nombre".equals(xmlPullParser.getName())){
                        if(p != null) p.setNombre(xmlPullParser.nextText());
                    }
                    if("precio".equals(xmlPullParser.getName())){
                        if(p != null) p.setPrecio(Double.valueOf(xmlPullParser.nextText()));
                    }
                    if("cantidad".equals(xmlPullParser.getName())){
                        if(p != null) p.setCantidad(Integer.valueOf(xmlPullParser.nextText()));
                    }
                }
                else if(event == XmlPullParser.END_TAG){
                    if("producto".equals(xmlPullParser.getName())){
                        productos.add(p);
                    }
                }
                
                event = xmlPullParser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}