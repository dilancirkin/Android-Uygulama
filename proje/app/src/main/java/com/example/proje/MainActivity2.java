package com.example.proje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i=getIntent();
        String s=i.getStringExtra("mesaj");
        TextView tv=findViewById(R.id.txtView);
        String s2=i.getStringExtra("mesaj2");
        tv.setText("Sağlıklı Günler"+" "+s+" "+s2);
        TextView txtSonuc=findViewById(R.id.txtSonuc);
        txtSonuc.setText(i.getStringExtra(MainActivity.DATA));
        ImageView img;
        img=findViewById(R.id.image2);
        img.setImageResource(R.drawable.maskeli);






    }
}