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
                Toast.makeText(MainActivity.this, spMeslekGrubu.getSelectedItem().toString()+" "+"Seçildi",Toast.LENGTH_SHORT).show();


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });



        spYasGrubu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this,spYasGrubu.getSelectedItem().toString()+" "+"Seçildi",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(MainActivity.this,"Kronik Hasta Değil",Toast.LENGTH_SHORT).show();
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

                 if(sp1.equals("Sağlık Çalışanı")||sp1.equals("Tıp Öğrencisi")||sp1.equals("Eczacı")||sp1.equals("Diş Hekimi")||sp1.equals("Diş Hekimliği Öğrencisi"))
                 {
                         i.putExtra(DATA,"1. Aşı Grubunda A Sırasındasınız.");
                 }
                else if(sp1.equals("Bakım Evi Çalışanı"))
                {
                    i.putExtra(DATA,"1. Aşı Grubunda B Sırasındasınız.");
                }
                else if(sp2.equals("85 Yaş Üzeri"))
                {
                    i.putExtra(DATA,"1. Aşı Grubunda C1 Sırasındasınız.");
                }
                else if(sp1.equals("80-84 Yaş Arası"))
                {
                    i.putExtra(DATA,"1. Aşı Grubunda C2 Sırasındasınız.");
                }
                else if(sp2.equals("75-79 Yaş Arası"))
                {
                    i.putExtra(DATA,"1. Aşı Grubunda C3 Sırasındasınız.");
                }
                else if(sp2.equals("70-74 Yaş Arasıı"))
                {
                    i.putExtra(DATA,"1. Aşı Grubunda C4 Sırasındasınız.");
                }
                else if(sp2.equals("65-69 Yaş Arası"))
                {
                    i.putExtra(DATA,"1. Aşı Grubunda C5 Sırasındasınız.");
                }
                else if(sp1.equals("Milli Savunma Bakanlığı"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A1 Sırasındasınız.");
                }
                else if(sp1.equals("İçişleri Bakanlığı"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A2 Sırasındasınız.");
                }
                else if(sp1.equals("Kritik Görevlerde Çalışan"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A3 Sırasındasınız.");
                }
                else if(sp1.equals("Zabıta,Özel Güvenlik"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A4 Sırasındasınız.");
                }
                else if(sp1.equals("Adalet Bakanlığı"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A5 Sırasındasınız.");
                }
                else if(sp1.equals("Ceza Evleri"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A6 Sırasındasınız.");
                }
                else if(sp1.equals("Eğitim Sektörü"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A7 Sırasındasınız.");
                }
                else if(sp1.equals("Gıda Sektörü"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A8 Sırasındasınız.");
                }
                else if(sp1.equals("Taşımacılık Sektörü"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda A9 Sırasındasınız.");
                }
                else if(sp2.equals("60-64 Yaş Arası"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda B1 Sırasındasınız.");
                }
                else if(sp2.equals("55-59 Yaş Arası"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda B2 Sırasındasınız.");
                }
                else if(sp2.equals("50-54 Yaş Arası"))
                {
                    i.putExtra(DATA,"2. Aşı Grubunda B3 Sırasındasınız.");
                }
                else if(sp2.equals("40-49 Yaş Arası")&&chcKronik.isChecked())
                {
                    i.putExtra(DATA,"3. Aşı Grubunda A1a Sırasındasınız.");
                }
                else if(sp2.equals("30-39 Yaş Arası")&&chcKronik.isChecked())
                {
                    i.putExtra(DATA,"3. Aşı Grubunda A1b Sırasındasınız.");
                }
                else if(sp2.equals("18-29 Yaş Arası")&&chcKronik.isChecked())
                {
                    i.putExtra(DATA,"3. Aşı Grubunda A1c Sırasındasınız.");
                }
                else if(sp2.equals("40-49 Yaş Arası"))
                {
                    i.putExtra(DATA,"3. Aşı Grubunda B1 Sırasındasınız.");
                }
                else if(sp2.equals("30-39 Yaş Arası"))
                {
                    i.putExtra(DATA,"3. Aşı Grubunda B2 Sırasındasınız.");
                }
                else if(sp2.equals("18-29 Yaş Arası"))
                {
                    i.putExtra(DATA,"3. Aşı Grubunda B3 Sırasındasınız.");
                }
                else
                {
                     i.putExtra(DATA,"4. Aşı Grubundasınız");
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