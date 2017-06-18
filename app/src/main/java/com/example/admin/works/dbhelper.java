package com.example.admin.works;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.id;
import static android.R.attr.version;

/**
 * Created by Admin on 5/12/2017.
 */

public class dbhelper extends SQLiteOpenHelper {

    static String name ="works";
    static int version = 1;

    String createTable="CREATE TABLE  if not exists \"users\" (\n" +
            "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\t`name`\tTEXT,\n" +
            "\t`gender`\tTEXT,\n" +
            "\t`email`\tTEXT,\n" +
            "\t`mobile`\tTEXT,\n" +
            "\t`address`\tTEXT,\n" +
            "\t`username`\tTEXT,\n" +
            "\t`password`\tTEXT,\n" +
            "\t`con_pass`\tTEXT\n" +
            ")";

    public dbhelper(Context context) {
        super(context, name, null, version);

        getWritableDatabase().execSQL(createTable);
    }
    public void insertUser(ContentValues cv){
        getWritableDatabase().insert("users", "",cv);

    }

    public void update(ContentValues cv, String id){
        getWritableDatabase().update("users",cv,"id="+id, null);
    }
    public void deleteUser(String id){
        getWritableDatabase().delete("users", "id="+id, null);
    }

    public boolean login(String username, String password){
        String sql = "Select count(*) from users where username ='"+username+"' " +
                "and password ='"+password+"'";
        SQLiteStatement statement = getWritableDatabase().compileStatement(sql);
        long l = statement.simpleQueryForLong();


        statement.close();

        if(l>0){
            return true;
        }
        else return false;

    }



    public ArrayList<UserInfo> getUserList(){
        String sql = "select * from users";

        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        ArrayList<UserInfo> list = new ArrayList<UserInfo>();

        while(cursor.moveToNext()){
            UserInfo info = new UserInfo();

            info.id = cursor.getString(cursor.getColumnIndex("id"));
            info.name = cursor.getString(cursor.getColumnIndex("name"));
            info.gender = cursor.getString(cursor.getColumnIndex("gender"));
            info.email = cursor.getString(cursor.getColumnIndex("email"));
            info.mobile = cursor.getString(cursor.getColumnIndex("mobile"));
            info.address = cursor.getString(cursor.getColumnIndex("address"));
            info.username = cursor.getString(cursor.getColumnIndex("username"));
            info.password = cursor.getString(cursor.getColumnIndex("password"));
            info.con_pass = cursor.getString(cursor.getColumnIndex("con_pass"));

            list.add(info);


        }
        cursor.close();
        return list;

    }

    public UserInfo getUserInfo( String id){
        String sql = "Select * from users where id="+id;

        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        UserInfo info = new UserInfo();

        while (cursor.moveToNext()){

            info.id = cursor.getString(cursor.getColumnIndex("id"));
            info.name = cursor.getString(cursor.getColumnIndex("name"));
           // info.gender = cursor.getString(cursor.getColumnIndex("gender"));
            info.email = cursor.getString(cursor.getColumnIndex("email"));
            info.mobile = cursor.getString(cursor.getColumnIndex("mobile"));
            info.address = cursor.getString(cursor.getColumnIndex("address"));
            info.username = cursor.getString(cursor.getColumnIndex("username"));


        }
        cursor.close();
        return info;
    }







    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
