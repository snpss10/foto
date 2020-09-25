package com.desarrollo.foto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        t1=findViewById(R.id.nombre);
        t2=findViewById(R.id.apellido);
        t3=findViewById(R.id.sexo);
        t4=findViewById(R.id.edad);
        t5=findViewById(R.id.direccion);
        imageView=findViewById(R.id.foto);
        button=findViewById(R.id.boton2);

        String dato1 = getIntent().getStringExtra("dato1");
        String dato2 = getIntent().getStringExtra("dato2");
        String dato3 = getIntent().getStringExtra("dato3");
        String dato4 = getIntent().getStringExtra("dato4");
        String dato5 = getIntent().getStringExtra("dato5");
        Bitmap bitmap = getIntent().getParcelableExtra("BitmapImage");

        t1.setText(dato1);
        t2.setText(dato2);
        t3.setText(dato3);
        t4.setText(dato4);
        t5.setText(dato5);
        imageView.setImageBitmap(bitmap);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }

}