package com.coletorv2.colertorv3.Database;

/**
 * Created by Raphael on 03/03/2016.
 */
public class scriptsql {

    public static String getCreateContato()
    {
        StringBuilder sqlbuilder=new StringBuilder();
        sqlbuilder.append ("CREATE TABLE IF NOT EXISTS FORMULARIO ( ");
        sqlbuilder.append ("_id                INTEGER       NOT NULL ");
        sqlbuilder.append ("PRIMARY KEY AUTOINCREMENT, ");
        sqlbuilder.append ("TALHAO           VARCHAR (150), ");
        sqlbuilder.append ("MATERIAL           VARCHAR (150), ");
        sqlbuilder.append ("AREA           VARCHAR (14), ");
        sqlbuilder.append ("DATA           DATE, ");
        sqlbuilder.append ("SOBREVIVENCIA       VARCHAR (1) , ");
        sqlbuilder.append ("DENSIDADE       VARCHAR (1), ");
        sqlbuilder.append ("HOMOGENEIDADE       VARCHAR (1), ");
        sqlbuilder.append ("ASPECTO       VARCHAR (1), ");
        sqlbuilder.append ("MATO       VARCHAR (1), ");
        sqlbuilder.append ("FORMIGA       VARCHAR (1), ");
        sqlbuilder.append ("PRAGAS       VARCHAR (1), ");
        sqlbuilder.append ("CONSERVACAO       VARCHAR (1) ");
        sqlbuilder.append (");");

        return sqlbuilder.toString();


    }

}


