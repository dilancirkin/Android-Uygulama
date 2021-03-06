package com.example.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.AdapterView.OnItemSelectedListener;



public class MainActivity extends AppCompatActivity {
    final static String DATA="deger";
    private Spinner spMeslekGrubu,spYasGrubu;
    private Button btnHesapla,btnKaydet,btnBaslat,btnDur;
    private CheckBox chcKronik;
    private EditText edtIsim,edtSoyisim;
    private ArrayAdapter<String>dataAdapterForMeslekler;
    private ArrayAdapter<String>dataAdapterForYaslar;
    MediaPlayer player;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img;
        img=findViewById(R.id.image);
        img.setImageResource(R.drawable.asi);


        spMeslekGrubu=findViewById(R.id.spMeslekGrubu);
        spYasGrubu=findViewById(R.id.spYasGrubu);
        btnHesapla=findViewById(R.id.btnHesapla);
        btnKaydet=findViewById(R.id.btnKaydet);
        btnBaslat=findViewById(R.id.btnBaslat);
        btnDur=findViewById(R.id.btnDur);
        chcKronik=findViewById(R.id.chcKronik);
        edtIsim=findViewById(R.id.edtIsim);
        edtSoyisim=findViewById(R.id.edtSoyisim);
        Database db;
        player=MediaPlayer.create(MainActivity.this, R.raw.music);

        btnBaslat.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v){
                player=MediaPlayer.create(MainActivity.this, R.raw.music);
                player.start();
            }
        });
        btnDur.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v){
                player.stop();
            }
        });
        
        spMeslekGrubu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, spMeslekGrubu.getSelectedItem().toString()+" "+"Se??ildi",Toast.LENGTH_SHORT).show();


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });



        spYasGrubu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,spYasGrubu.getSelectedItem().toString()+" "+"Se??ildi",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){
                
            }
        });

        chcKronik.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    Toast.makeText(MainActivity.this,"Kronik Hasta",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Kronik Hasta De??il",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("mesaj",edtIsim.getText().toString());
                i.putExtra("mesaj2",edtSoyisim.getText().toString());

                String sp1=spMeslekGrubu.getSelectedItem().toString();
                String sp2=spYasGrubu.getSelectedItem().toString();

                 if(sp1.equals("Sa??l??k ??al????an??")||sp1.equals("T??p ????rencisi")||sp1.equals("Eczac??")||sp1.equals("Di?? Hekimi")||sp1.equals("Di?? Hekimli??i ????rencisi"))
                 {
                         i.putExtra(DATA,"1. A???? Grubunda A S??ras??ndas??n??z.");
                 }
                else if(sp1.equals("Bak??m Evi ??al????an??"))
                {
                    i.putExtra(DATA,"1. A???? Grubunda B S??ras??ndas??n??z.");
                }
                else if(sp2.equals("85 Ya?? ??zeri"))
                {
                    i.putExtra(DATA,"1. A???? Grubunda C1 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("80-84 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"1. A???? Grubunda C2 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("75-79 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"1. A???? Grubunda C3 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("70-74 Ya?? Aras????"))
                {
                    i.putExtra(DATA,"1. A???? Grubunda C4 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("65-69 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"1. A???? Grubunda C5 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("Milli Savunma Bakanl??????"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A1 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("????i??leri Bakanl??????"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A2 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("Kritik G??revlerde ??al????an"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A3 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("Zab??ta,??zel G??venlik"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A4 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("Adalet Bakanl??????"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A5 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("Ceza Evleri"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A6 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("E??itim Sekt??r??"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A7 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("G??da Sekt??r??"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A8 S??ras??ndas??n??z.");
                }
                else if(sp1.equals("Ta????mac??l??k Sekt??r??"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda A9 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("60-64 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda B1 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("55-59 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda B2 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("50-54 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"2. A???? Grubunda B3 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("40-49 Ya?? Aras??")&&chcKronik.isChecked())
                {
                    i.putExtra(DATA,"3. A???? Grubunda A1a S??ras??ndas??n??z.");
                }
                else if(sp2.equals("30-39 Ya?? Aras??")&&chcKronik.isChecked())
                {
                    i.putExtra(DATA,"3. A???? Grubunda A1b S??ras??ndas??n??z.");
                }
                else if(sp2.equals("18-29 Ya?? Aras??")&&chcKronik.isChecked())
                {
                    i.putExtra(DATA,"3. A???? Grubunda A1c S??ras??ndas??n??z.");
                }
                else if(sp2.equals("40-49 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"3. A???? Grubunda B1 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("30-39 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"3. A???? Grubunda B2 S??ras??ndas??n??z.");
                }
                else if(sp2.equals("18-29 Ya?? Aras??"))
                {
                    i.putExtra(DATA,"3. A???? Grubunda B3 S??ras??ndas??n??z.");
                }
                else
                {
                     i.putExtra(DATA,"4. A???? Grubundas??n??z");
                }

                startActivity(i);


            }
        });
        btnKaydet.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v){
                Kullanici kullanici;

                try{
                    int id = -1;
                    String adSoyad = (edtIsim.getText().toString() + " " + edtSoyisim.getText().toString());
                    String asiSirasi = (DATA.toString());
                    kullanici=new Kullanici(id,adSoyad,asiSirasi);
                }
                catch(Exception e)
                {
                    Toast.makeText(MainActivity.this,"Nesne Hata",Toast.LENGTH_SHORT).show();
                    kullanici=new Kullanici(-1,"error","error");
                }
                Database db=new Database(MainActivity.this);
                boolean success=db.ekleKullanici(kullanici);
                db.ekleKullanici(kullanici);
                Toast.makeText(MainActivity.this,"Success"+success,Toast.LENGTH_SHORT).show();
            }
        });






    }


}