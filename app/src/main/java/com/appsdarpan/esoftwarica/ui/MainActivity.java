package com.appsdarpan.esoftwarica.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.appsdarpan.esoftwarica.R;
import com.appsdarpan.esoftwarica.controller.controller;
import com.appsdarpan.esoftwarica.model.UserData;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText username, userpassword;
    ImageView nameImage, passImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btnlogin);
        username = findViewById(R.id.LGname);
        userpassword = findViewById(R.id.LGpassword);
        nameImage = findViewById(R.id.lgnamaeimg);
        passImage = findViewById(R.id.LGpassimg);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    nameImage.setImageResource(R.drawable.ic_check_box);
                } else if(start==0) {
                    nameImage.setImageResource(R.drawable.ic_wrong_access);
                }
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        userpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0) {
                    passImage.setImageResource(R.drawable.ic_check_box);
                } else if(start==0) {
                    passImage.setImageResource(R.drawable.ic_wrong_access);


                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData dataSet = new UserData();
                if (!TextUtils.isEmpty(username.getText().toString())) {
                    dataSet.setName(username.getText().toString());
                    if (!TextUtils.isEmpty(userpassword.getText().toString())) {
                        dataSet.setPassword(userpassword.getText().toString());
                        boolean result = new controller().CheckUser(dataSet);
                        if (result) {
                            Intent intent = new Intent(MainActivity.this,MainWindow.class);
                            startActivity(intent);
                            username.setText("");
                            userpassword.setText("");
                        } else {
                            Toast.makeText(MainActivity.this, "user name or password mistake", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        userpassword.setError("please enter password");
                        passImage.setImageResource(R.drawable.ic_wrong_access);
                    }
                } else {
                    username.setError("please enter user name");
                    nameImage.setImageResource(R.drawable.ic_wrong_access);

                }
            }
        });

    }

}
