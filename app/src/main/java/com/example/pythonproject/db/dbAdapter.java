package com.example.pythonproject.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.pythonproject.model.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

public class dbAdapter extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "C++Quiz";

    // Table name
    private static final String TABLE_QUESTION = "question";

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUESION = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd"; //option d

    private SQLiteDatabase myDatabase;


    public dbAdapter(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        myDatabase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUESTION + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUESION
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD+" TEXT)";

        db.execSQL(sql);

        addQuestions();

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION);

        // Create tables again
        onCreate(db);
    }
    public int rowCount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
    public List<QuizQuestion> getAllQuestions() {

        List<QuizQuestion> quesList = new ArrayList<QuizQuestion>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTION;
        myDatabase=this.getReadableDatabase();

        Cursor cursor = myDatabase.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuizQuestion quest = new QuizQuestion();
                quest.setId(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOptionA(cursor.getString(3));
                quest.setOptionB(cursor.getString(4));
                quest.setOptionC(cursor.getString(5));
                quest.setOptionD(cursor.getString(6));


                quesList.add(quest);

            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }


    private void addQuestions() {

        QuizQuestion q1=new QuizQuestion("The keyword Used to transfer control from a function back to the calling function is","switch", "goto", "go back", "return","return");
        this.addQuestion(q1);

        QuizQuestion q2=new QuizQuestion("Which of the  function sets first n characters of a string to a given character?","strinit()", "strnset()", "strset()", "strcset()","strnset()");
        this.addQuestion(q2);

        QuizQuestion q3=new QuizQuestion("The library function used to find the last occurrence of a character in a string is","strnstr()", "laststr()", "strrchr()", "strstr()","strrchr()");
        this.addQuestion(q3);


        QuizQuestion q4=new QuizQuestion("In which numbering system can the binary number 1011011111000101 be easily converted to?","Decimal system", "Hexadecimal system", "Octal system", "No need to convert","Hexadecimal system");
        this.addQuestion(q4);

        QuizQuestion q5=new QuizQuestion("Which bitwise operator is suitable for checking whether a particular bit is on or off?","&& operator", "& operator", "|| operator", "! operator","& operator");
        this.addQuestion(q5);

        QuizQuestion q6=new QuizQuestion("Which of the following is not logical operator?","&", "&&", "||", "!","&");
        this.addQuestion(q6);

        QuizQuestion q7=new QuizQuestion("Who is the Developer of this App?","Taiwo Tomiwa", "Ilori Tobiloba", "Prince Adetoyese Matthew", "Usman Oluseyi","Prince Adetoyese Matthew");
        this.addQuestion(q7);




    }

    private void addQuestion(QuizQuestion quest) {
        ContentValues values = new ContentValues();
        values.put(KEY_QUESION, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOptionA());
        values.put(KEY_OPTB, quest.getOptionB());
        values.put(KEY_OPTC, quest.getOptionC());
        values.put(KEY_OPTD, quest.getOptionD());

        // Inserting Row
        myDatabase.insert(TABLE_QUESTION, null, values);

    }
}
