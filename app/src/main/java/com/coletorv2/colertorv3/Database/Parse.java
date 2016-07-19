package com.coletorv2.colertorv3.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.coletorv2.colertorv3.Dominio.Entidades.Contato;
import com.coletorv2.colertorv3.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * This class helps open, create, and upgrade the database file.
 */
public  class Parse extends SQLiteOpenHelper {

    private final Context fContext;

    Parse(Context context) {
        super(context, "sampledb", null, 1);
        fContext = context;
    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        //Add default records to animals
        ContentValues _Values = new ContentValues();
        //Get xml resource file
        Resources res = fContext.getResources();

        //Open xml file
        XmlResourceParser _xml = res.getXml(R.xml.talhoes);
        try
        {
            //Check for end of document
            int eventType = _xml.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                //Search for record tags
                if ((eventType == XmlPullParser.START_TAG) &&(_xml.getName().equals("record"))){
                    //Record tag found, now get values and insert record
                    String _talhao = _xml.getAttributeValue(null, Contato.TALHAO);
                    String _material = _xml.getAttributeValue(null, Contato.MATERIAL);
                    String _area = _xml.getAttributeValue(null, Contato.AREA);
                    String _data = _xml.getAttributeValue(null, Contato.DATA);
                    String _sobrevivencia = _xml.getAttributeValue(null, Contato.SOBREVIVENCIA);
                    String _densidade = _xml.getAttributeValue(null, Contato.DENSIDADE);
                    String _homogeneidade = _xml.getAttributeValue(null, Contato.HOMOGENEIDADE);
                    String _aspecto = _xml.getAttributeValue(null, Contato.ASPECTO);
                    String _mato = _xml.getAttributeValue(null, Contato.MATO);
                    String _formiga = _xml.getAttributeValue(null, Contato.FORMIGA);
                    String _praga = _xml.getAttributeValue(null, Contato.PRAGAS);
                    String _conservacao = _xml.getAttributeValue(null, Contato.CONSERVACAO);


                    _Values.put(Contato.TALHAO, _talhao);
                    _Values.put(Contato.MATERIAL, _material);
                    _Values.put(Contato.AREA, _area);
                    _Values.put(Contato.DATA, _data);
                    _Values.put(Contato.SOBREVIVENCIA, _sobrevivencia);
                    _Values.put(Contato.DENSIDADE, _densidade);
                    _Values.put(Contato.HOMOGENEIDADE, _homogeneidade);
                    _Values.put(Contato.ASPECTO, _aspecto);
                    _Values.put(Contato.MATO, _mato);
                    _Values.put(Contato.FORMIGA, _formiga);
                    _Values.put(Contato.PRAGAS, _praga);
                    _Values.put(Contato.CONSERVACAO, _conservacao);



                    db.insert(Contato.TABELA, null, _Values);
                }
                eventType = _xml.next();
            }
        }


        //Catch errors
       catch (XmlPullParserException e)
        {
            e.printStackTrace();
        }
       catch (IOException e)
        {
            e.printStackTrace();

             }
        finally
        {
            //Close the xml file
            _xml.close();
        }
    }

    /* Update database to latest version */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Crude update, make sure to implement a correct one when needed.

        onCreate(db);
    }
}