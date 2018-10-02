package com.example.denis.person;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    Button create;
    Button read;
    Button update;
    Button delete;
    DBHelper dbHelper;
    EditText editTextID;
    EditText editTextName;
    EditText editTextLame;
    EditText editTextage;


    RVAdapter adapter;
    RecyclerView rv;

    final String LOG_TAG = "myLogs";
   // SQLiteDatabase db;
ArrayList<Person> pp = new ArrayList<Person>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        editTextID = (EditText) findViewById(R.id.etid);
        editTextName = (EditText) findViewById(R.id.etName);
        editTextLame = (EditText) findViewById(R.id.etLastname);
        editTextage = (EditText) findViewById(R.id.etage);

        create = (Button) findViewById(R.id.create);
        create.setOnClickListener(this);
        read = (Button) findViewById(R.id.read);
        read.setOnClickListener(this);
        update = (Button) findViewById(R.id.update);
        update.setOnClickListener(this);
        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);
        dbHelper = new DBHelper(this);
        //dbHelper.getWritableDatabase();
        rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);
        adapter = new RVAdapter();
        adapter.setOnItemClickListener(new RVAdapter.OnItemClickListener<Person>()
        {
            @Override
            public void onItemClick(int position, Person p)
            {
                showPerson(p);
            }
        });
        rv.setAdapter(adapter);
    }

  private void  showPerson(Person p){
       editTextID.setText(String.valueOf( p.getId()));
       editTextName.setText(p.Fname);
       editTextLame.setText(p.Lname);
       editTextage.setText(String.valueOf( p.getAge()));
    }

    private void read(SQLiteDatabase db)
    {
        Cursor c = db.query("mytable", null, null, null, null, null, null);

        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int fnameColIndex = c.getColumnIndex("fname");
            int lnameColIndex = c.getColumnIndex("lname");
            int ageColIndex = c.getColumnIndex("age");
            pp.clear();
            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.e(LOG_TAG,
                        "id = " + c.getInt(idColIndex) +
                                ", fname = " + c.getString(fnameColIndex) +
                                ", lname = " + c.getString(lnameColIndex) +
                                ", age = " + c.getString(ageColIndex)
                );

                Person p = new Person(c.getInt(idColIndex), c.getString(fnameColIndex),c.getString(lnameColIndex), c.getInt(ageColIndex));
                pp.add(p);

                //   Log.d(LOG_TAG, String.valueOf(pp.get(0).Age));

                adapter.updateList(pp);

//                        cardid.setText(c.getInt(idColIndex));
//                        cardfname.setText(c.getString(fnameColIndex) + "");
//                        cardlname.setText(c.getString(lnameColIndex) + "");
//                        cardage.setText(c.getInt(idColIndex));


                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());

        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();
    }

    @Override
    public void onClick(View v) {
        // создаем объект для данных
        ContentValues cv = new ContentValues();

        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        switch (v.getId()) {
            case R.id.create:
                // получаем данные из полей ввода
                if(editTextID.getText().toString().equals("")) {
                    break;
                }
                int id = Integer.parseInt(editTextID.getText().toString());
                String fname = editTextName.getText().toString();
                String lname = editTextLame.getText().toString();
                int age = Integer.parseInt(editTextage.getText().toString());

                Log.e(LOG_TAG, "--- Insert in mytable: ---");
                // подготовим данные для вставки в виде пар: наименование столбца - значение
                cv.put("id",id);
                cv.put("fname", fname);
                cv.put("lname", lname);
                cv.put("age",age);
                // вставляем запись и получаем ее ID
                long rowID = db.insert("mytable", null, cv);
                Log.e(LOG_TAG, "row inserted, ID = " + rowID);
                editTextID.setText("");
                editTextName.setText("");
                editTextLame.setText("");
                editTextage.setText("");
                read(db);
                break;

            case R.id.read:
                Log.e(LOG_TAG, "--- Rows in mytable: ---");
                // делаем запрос всех данных из таблицы mytable, получаем Cursor
                read(db);
                break;


            case R.id.update:
                 id = Integer.parseInt(editTextID.getText().toString());
                 fname = editTextName.getText().toString();
                 lname = editTextLame.getText().toString();
                 age = Integer.parseInt(editTextage.getText().toString());

//                if (id.equalsIgnoreCase("")) {
//                    break;
//                }
                Log.d(LOG_TAG, "--- Update mytable: ---");
                // подготовим значения для обновления
                cv.put("id",id);
                cv.put("fname", fname);
                cv.put("lname", lname);
                cv.put("age",age);
                // обновляем по id
                int updCount = db.update("mytable", cv, "id = ?",
                        new String[] {editTextID.getText()+""});
                Log.d(LOG_TAG, "updated rows count = " + updCount);

                editTextID.setText("");
                editTextName.setText("");
                editTextLame.setText("");
                editTextage.setText("");
                read(db);
                break;

            case R.id.delete:
               db.delete("mytable","id=?",new String[]{editTextID.getText()+""});
                editTextID.setText("");
                editTextName.setText("");
                editTextLame.setText("");
                editTextage.setText("");
                read(db);
                break;
        }
        // закрываем подключение к БД
        dbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {


        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.e(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "fname text,"
                    + "lname text,"
                    + "age integer"
                    + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
