package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase sqLiteDatabase=this.openOrCreateDatabase("Users", MODE_PRIVATE,null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events (name VARCHAR, age INT(4))");
           //sqLiteDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Sarvottam', 20)");
           //sqLiteDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Nick', 18)");

            Cursor c= sqLiteDatabase.rawQuery("SELECT * FROM users WHERE age<18",null);
            int nameIndex =c.getColumnIndex("name");
            int ageIndex =c.getColumnIndex("age");
            c.moveToFirst();

            while(c!=null){
                Log.i("UserResults - name", c.getString(nameIndex));
                Log.i("UserResults - age", Integer.toString(c.getInt(ageIndex)));

                c.moveToNext();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
