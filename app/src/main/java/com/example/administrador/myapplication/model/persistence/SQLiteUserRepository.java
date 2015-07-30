package com.example.administrador.myapplication.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrador.myapplication.model.entities.Client;
import com.example.administrador.myapplication.model.entities.User;
import com.example.administrador.myapplication.util.AppUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 30/07/2015.
 */
public class SQLiteUserRepository implements UserRepository {

    public static SQLiteUserRepository singletonInstance;

    private SQLiteUserRepository() {
        super();
    }

    public static SQLiteUserRepository getInstance() {
        if (SQLiteUserRepository.singletonInstance == null) {
            SQLiteUserRepository.singletonInstance = new SQLiteUserRepository();
        }
        return SQLiteUserRepository.singletonInstance;
    }

    @Override
    public void save(User user) {
        DatabaseHelper helper = new DatabaseHelper(AppUtil.CONTEXT);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = UserContract.getContentValues(user);
        db.insert(UserContract.TABLE, null, values);
        db.close();
        helper.close();
    }

    @Override
    public List<User> authentication(User user) {
        DatabaseHelper helper = new DatabaseHelper(AppUtil.CONTEXT);
        SQLiteDatabase db = helper.getReadableDatabase();
        String where = UserContract.LOGIN + " = ? AND " + UserContract.PASSWORD + " = ? ";
        String argumentos[] = new String[] { user.getLogin(), user.getPassword()};
        Cursor cursor = db.query(UserContract.TABLE, UserContract.COLUMNS, where, argumentos, null, null, null);
        List<User> users = UserContract.usersList(cursor);
        db.close();
        helper.close();
        return users;
    }

    @Override
    public List<User> getAll() {
        DatabaseHelper helper = new DatabaseHelper(AppUtil.CONTEXT);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.query(UserContract.TABLE, UserContract.COLUMNS, null, null, null, null, null);
        List<User> users = UserContract.usersList(cursor);
        db.close();
        helper.close();
        return users;
    }
}
