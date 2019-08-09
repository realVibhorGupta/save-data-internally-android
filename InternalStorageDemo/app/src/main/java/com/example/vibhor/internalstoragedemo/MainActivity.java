package com.example.vibhor.internalstoragedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= (EditText) findViewById(R.id.user_name);
        password= (EditText) findViewById(R.id.password);

    }

    public void onSave(View view)
    {

        String text1 = username.getText().toString();
        String text2 = password.getText().toString();
        File file = null;
        text1= text1 + " ";
        FileOutputStream fileOutputStream = null;
        try {
            file=getFilesDir();
             fileOutputStream= openFileOutput("vibhor.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        Toast.makeText(MainActivity.this,"Your  Data has been Saved" + file, Toast.LENGTH_LONG).show();
    }


    public void onNext(View  view)
    {
        Toast.makeText(MainActivity.this,"Next"  , Toast.LENGTH_LONG).show();
        Intent intent=new Intent(MainActivity.this,AnotherActivity.class);
        startActivity(intent);
    }
}
