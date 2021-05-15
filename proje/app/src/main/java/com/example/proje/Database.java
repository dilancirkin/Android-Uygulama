package com.example.proje;

import android.content.Context;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class Database extends SQLiteOpenHelper {

        public  static final String veritabaniAdi="veriTabani";
        public static final String hesaplanilanKisilerTablosu="tblKullanici";
        public static final String COLUMN_ID = "ID";
        public static final int veritabaniVersiyonu=3;
        public static final String KULLANICI_ADI = "KullaniciAdi";
        public static final String ASI_SIRASI = "AsiSirasi";


        public Database(Context context) {
            super(context,veritabaniAdi,null,veritabaniVersiyonu);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String tabloOlusturma="CREATE TABLE"+" "+hesaplanilanKisilerTablosu+ "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KULLANICI_ADI + " TEXT, " + ASI_SIRASI + " TEXT"+")";
            db.execSQL(tabloOlusturma);


        }


        public boolean ekleKullanici(Kullanici kullanici)
        {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put(KULLANICI_ADI,kullanici.getAdSoyad());
            cv.put(ASI_SIRASI,kullanici.getAsiSirasi());
            long insert=db.insert(hesaplanilanKisilerTablosu,null,cv);

            if(insert==-1)
            {
                return false;
            }
            else{
                return true;
            }

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        }
    }


