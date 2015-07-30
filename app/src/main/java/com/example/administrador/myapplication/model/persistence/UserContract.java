package com.example.administrador.myapplication.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;

import com.example.administrador.myapplication.model.entities.Client;
import com.example.administrador.myapplication.model.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 30/07/2015.
 */
public class UserContract {

    public static final String TABLE = "user";
    public static final String ID = "id";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String[] COLUMNS = {ID, LOGIN, PASSWORD};

    public static String getCreateSql() {
        StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE ");
        sql.append(TABLE);
        sql.append(" ( ");
        sql.append(ID + " INTEGER PRIMARY KEY, ");
        sql.append(LOGIN + " TEXT, ");
        sql.append(PASSWORD + " TEXT ");
        sql.append(" ); ");
        return sql.toString();
    }

    public static ContentValues getContentValues(User user) {
        ContentValues values = new ContentValues();
        values.put(UserContract.ID, user.getId());
        values.put(UserContract.LOGIN, user.getLogin());
        values.put(UserContract.PASSWORD, user.getPassword());
        return values;
    }

    public static User bind(Cursor cursor) {
        if (!cursor.isBeforeFirst() || cursor.moveToNext()) {
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex(UserContract.ID)));
            user.setLogin(cursor.getString(cursor.getColumnIndex(UserContract.LOGIN)));
            user.setPassword(cursor.getString(cursor.getColumnIndex(UserContract.PASSWORD)));
            return user;
        }
        return null;
    }

    public static List<User> usersList(Cursor cursor) {
        List<User> serviceOrders = new ArrayList<>();
        while (cursor.moveToNext()) {
            serviceOrders.add(bind(cursor));
        }
        return serviceOrders;
    }

}
