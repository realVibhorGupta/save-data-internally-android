package com.example.vibhor.internalstoragedemo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AnotherActivity extends AppCompatActivity {

    public static final String DEFAULT = "N/A";
    TextView usernameTextView, passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        usernameTextView = (TextView) findViewById(R.id.textView2);
        passwordTextView = (TextView) findViewById(R.id.textView4);
    }

    public void onLoad(View view) {
        FileInputStream fileInputStream = null;
        int readInputData = -1;
        try {
            fileInputStream = openFileInput("vibhor.txt");
            StringBuffer stringBuffer = new StringBuffer();
            while ((readInputData = fileInputStream.read()) != -1) {
                stringBuffer.append((char) readInputData);


            }

            String text1 = stringBuffer.substring(0, stringBuffer.indexOf(" "));
            String text2 = stringBuffer.substring(stringBuffer.indexOf(" ") + 1);
            usernameTextView.setText(text1);
            passwordTextView.setText(text2);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    public void onPrevious(View view) {
        Toast.makeText(this, "previous", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
