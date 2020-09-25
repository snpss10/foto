package com.desarrollo.foto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button camera,enviar;
    Bitmap bitmap;
    EditText et1,et2,et3,et4,et5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.nombre);
        et2=findViewById(R.id.apellido);
        et3=findViewById(R.id.edad);
        et4=findViewById(R.id.sexo);
        et5=findViewById(R.id.direccion);
        camera=findViewById(R.id.boton);
        img=findViewById(R.id.foto);
        enviar=findViewById(R.id.boton2);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 5);
            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("dato1", et1.getText().toString());
                i.putExtra("dato2", et2.getText().toString());
                i.putExtra("dato3", et3.getText().toString());
                i.putExtra("dato4", et4.getText().toString());
                i.putExtra("dato5", et5.getText().toString());
                i.putExtra("BitmapImage", bitmap);
                //i.putExtra("img", R.drawable.image);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode != 0){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            bitmap=image;
            img.setImageBitmap(image);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}