package com.example.user.skasc_coe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by user on 1/10/2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper{
    public  static  final  String DATABASE_NAME="COE.db";
    public static final String TABLE_ACADEMIC = "Academic";
    public static final String TABLE_ODD = "OddSem";
    public static final String TABLE_EVEN = "EvenSem";
    public static final String TABLE_CIRCULAR = "Circular";
    public static final String TABLE_USER = "User";

    public static final String ACADEMIC_ID = "Academic_id";
    public static final String COMMITTEE_NAME = "Committee";
    public static final String COMMITTEE_DATE = "Committee_date";

    public static final String ODD_ID = "Odd_id";
    public static final String ODD_NAME = "Committee";
    public static final String ODD_DATE = "Committee_date";

    public static final String EVEN_ID = "Even_id";
    public static final String EVEN_NAME = "Committee";
    public static final String EVEN_DATE = "committee_date";


    public static final String CIRCULAR_ID = "Circular_id";
    public static final String CIRCULAR_NAME = "Circular";
    public static final String CIRCULAR_DATE = "Circular_date";
    public static final String CIRCULAR_DUE_DATE = "Circular_due_date";

    public static final String ID = "User_id";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";

    public static final String ACADEMIC = "CREATE TABLE "
            + TABLE_ACADEMIC + "(" +ACADEMIC_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," + COMMITTEE_NAME
            + " TEXT," + COMMITTEE_DATE + " TEXT" + ")";

    public static final String ODD = "CREATE TABLE "
            + TABLE_ODD + "(" +ODD_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," + ODD_NAME
            + " TEXT," + ODD_DATE + " TEXT" + ")";

    public static final String EVEN = "CREATE TABLE "
            + TABLE_EVEN + "(" +EVEN_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," + EVEN_NAME
            + " TEXT," + EVEN_DATE + " TEXT" + ")";

    public static final String CIRCULAR = "CREATE TABLE "
            + TABLE_CIRCULAR + "(" +CIRCULAR_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," + CIRCULAR_NAME
            + " TEXT," + CIRCULAR_DATE + " TEXT" + CIRCULAR_DUE_DATE + " TEXT" + ")";

    public static final String USER = "CREATE TABLE "
            + TABLE_USER + "(" +ID  + " INTEGER PRIMARY KEY AUTOINCREMENT," + USERNAME
            + " TEXT," + PASSWORD + " TEXT" + ")";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ACADEMIC);
        db.execSQL(ODD);
        db.execSQL(EVEN);
        db.execSQL(CIRCULAR);
        db.execSQL(USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACADEMIC);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ODD);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVEN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CIRCULAR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

    }

    // inserting datas to academic table
    public boolean insertacademic(String committee,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(COMMITTEE_NAME,committee);
        contentvalues.put(COMMITTEE_DATE,date);
        long result= db.insert(TABLE_ACADEMIC,null,contentvalues);
        if(result== -1)
            return false;
        else
            return true;

    }

    // retrieving all datas from academic table
    public Cursor getalldata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_ACADEMIC,null);
        return resultdata;
    }

    // updating datas to academic table
    public  boolean updateAcademic(String id,String date,String committee)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(ACADEMIC_ID,id);
        contentvalues.put(COMMITTEE_NAME,committee);
        contentvalues.put(COMMITTEE_DATE,date);
        db.update(TABLE_ACADEMIC,contentvalues, "Academic_id = ?" ,new String[]{ id });
        return true;
    }

    // inserting datas to odd sem table
    public boolean insertOddSchedule(String schedule,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(ODD_NAME,schedule);
        contentvalues.put(ODD_DATE,date);
        long result= db.insert(TABLE_ODD,null,contentvalues);
        if(result== -1)
            return false;
        else
            return true;

    }

    // retrieving all datas from odd sem table
    public Cursor getallOdddata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_ODD,null);
        return resultdata;
    }

    // updating datas to odd sem table
    public  boolean updateOddsem(String id,String date,String committee)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(ODD_ID,id);
        contentvalues.put(ODD_NAME,committee);
        contentvalues.put(ODD_DATE,date);
        db.update(TABLE_ODD,contentvalues, "Odd_id = ?" ,new String[]{ id });
        return true;
    }
    // inserting datas to even sem table
    public boolean insertEvenSchedule(String schedule,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(EVEN_NAME,schedule);
        contentvalues.put(EVEN_DATE,date);
        long result= db.insert(TABLE_EVEN,null,contentvalues);
        if(result== -1)
            return false;
        else
            return true;

    }

    // retrieving all datas from even sem table
    public Cursor getallEvendata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_EVEN,null);
        return resultdata;
    }
    // updating datas to even sem table
    public  boolean updateEvensem(String id,String date,String committee)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(EVEN_ID,id);
        contentvalues.put(EVEN_NAME,committee);
        contentvalues.put(EVEN_DATE,date);
        db.update(TABLE_EVEN,contentvalues, "Even_id = ?" ,new String[]{ id });
        return true;
    }

    // inserting datas to circular table
    public boolean insertCircularSchedule(String schedule,String date)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(CIRCULAR_NAME,schedule);
        contentvalues.put(CIRCULAR_DATE,date);
        long result= db.insert(TABLE_CIRCULAR,null,contentvalues);
        if(result== -1)
            return false;
        else
            return true;

    }
    // retrieving all datas from circular table
    public Cursor getallCirculardata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_CIRCULAR,null);
        return resultdata;
    }

    // retrieving particular datas from circular table
    public Cursor getallCirculardatamain(String date){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_CIRCULAR+ " where Circular_date ="+date,null);
        return resultdata;
    }
    // retrieving particular datas from circular table
    public Cursor getallAcademicdatamain(String date){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_ACADEMIC+ " where Committee_date ="+date,null);
        return resultdata;
    }
    // retrieving particular datas from circular table
    public Cursor getallEvendatamain(String date){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_EVEN+ " where Committee_date ="+date,null);
        return resultdata;
    }
    // retrieving particular datas from circular table
    public Cursor getallOdddatamain(String date){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_ODD+ " where Committee_date ="+date,null);
        return resultdata;
    }
       // updating datas to circular table
    public  boolean updateCircular(String id,String date,String committee)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(CIRCULAR_ID,id);
        contentvalues.put(CIRCULAR_NAME,committee);
        contentvalues.put(CIRCULAR_DATE,date);
        db.update(TABLE_CIRCULAR,contentvalues, "Circular_id = ?" ,new String[]{ id });
        return true;
    }
    // deleting datas from academic table
    public Integer deleteAcademic(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_ACADEMIC, "Academic_id = ?" ,new String[]{ id });
    }

    // deleting datas from academic table
    public Integer deleteOdd(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_ODD, "Odd_id = ?" ,new String[]{ id });
    }
    // deleting datas from academic table
    public Integer deleteEven(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_EVEN, "Even_id = ?" ,new String[]{ id });
    }
    // deleting datas from academic table
    public Integer deleteCircular(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_CIRCULAR, "Circular_id = ?" ,new String[]{ id });
    }
    // Returning id for operations like deletion and updation
    public int getallAcademinIdCount(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select " + ACADEMIC_ID + " from "+TABLE_ACADEMIC,null);
        int count=resultdata.getCount();
        return count;
    }
    public ArrayList<String> getallAcademicId(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + ACADEMIC_ID + " from "+TABLE_ACADEMIC,null);

        ArrayList<String> acadid = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    acadid.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return acadid;
    }

    public ArrayList<String> getallAEvenId(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + EVEN_ID + " from "+TABLE_EVEN,null);

        ArrayList<String> evenid = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    evenid.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return evenid;
    }
    public ArrayList<String> getallODDId(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + ODD_ID + " from "+TABLE_ODD,null);

        ArrayList<String> oddid = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    oddid.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return oddid;
    }
    public ArrayList<String> getallCircularId(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + CIRCULAR_ID + " from "+TABLE_CIRCULAR,null);

        ArrayList<String> circularid = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    circularid.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return circularid;
    }
    public ArrayList<String> getallCirculardue(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + CIRCULAR_DUE_DATE + " from "+TABLE_CIRCULAR,null);

        ArrayList<String> circulardue = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    circulardue.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return circulardue;
    }
    public ArrayList<String> getallAcademiccommittee(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + COMMITTEE_NAME + " from "+TABLE_ACADEMIC,null);

        ArrayList<String> acadcommittee = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    acadcommittee.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return acadcommittee;
    }
    public ArrayList<String> getallAcademicdate(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + COMMITTEE_DATE + " from "+TABLE_ACADEMIC,null);

        ArrayList<String> acaddate = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    acaddate.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return acaddate;
    }
    public ArrayList<String> getallOddSchedule(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + ODD_NAME + " from "+TABLE_ODD,null);

        ArrayList<String> oddname = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    oddname.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return oddname;
    }
    public ArrayList<String> getallOdddate(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + ODD_DATE + " from "+TABLE_ODD,null);

        ArrayList<String> odddate = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    odddate.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return odddate;
    }
    public ArrayList<String> getallEvenSchedule(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + EVEN_NAME + " from "+TABLE_EVEN,null);

        ArrayList<String> evenname = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    evenname.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return evenname;
    }
    public ArrayList<String> getallEvendate(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + EVEN_DATE + " from "+TABLE_EVEN,null);

        ArrayList<String> evendate = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    evendate.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return evendate;
    }
    public ArrayList<String> getallCircularschedule(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + CIRCULAR_NAME + " from "+TABLE_CIRCULAR,null);

        ArrayList<String> circulr = new ArrayList<String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    circulr.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return circulr;
    }
    public ArrayList<String> getallCirulardate(){

        Cursor cursor = getReadableDatabase().rawQuery("select " + CIRCULAR_DATE + " from "+TABLE_CIRCULAR,null);

        ArrayList<String> cdate = new ArrayList <String>();
        if (cursor != null)
        {
            if (cursor.moveToFirst()) {
                for(int i = 0; i < cursor.getCount(); i ++){
                    cdate.add(cursor.getString(0));
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return cdate;
    }

    public boolean signup(String username,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(USERNAME,username);
        contentvalues.put(PASSWORD,password);
        long result= db.insert(TABLE_USER,null,contentvalues);
        if(result== -1)
            return false;
        else
            return true;

    }
    public String Searchpass(String uname)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select Username,Password from "+TABLE_USER;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst())
        {
            do
            {
                a = cursor.getString(0);
                if(a.equals(uname))
                {
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

    public Cursor getalldatamain(String date){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_ACADEMIC+ " where Committee_date = "+ date + " union all select * from "+TABLE_ODD+ " where Committee_date = "+ date + " union all select * from "+TABLE_CIRCULAR+ " where Circular_date = "+ date + " union all select * from "+TABLE_EVEN+ " where Committee_date = "+ date  ,null);
        return resultdata;
    }
    public Cursor getalldatamainn(String date){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor resultdata=db.rawQuery("select * from "+TABLE_ACADEMIC+ " where Committee_date like '%"+ date + "%' union all select * from "+TABLE_ODD+ " where Committee_date like '%"+ date + "%' union all select * from "+TABLE_CIRCULAR+ " where Circular_date like '%"+ date + "%' union all select * from "+TABLE_EVEN+ " where Committee_date like '%"+ date +"%' " ,null);
        return resultdata;
    }

}
