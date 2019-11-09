package com.jingyan.facepp_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.megvii.facepp.api.FacePPApi;

public class MainActivity extends AppCompatActivity {
    public static String API_Key = "jnKErmEcRWpMI1UHB2rNZF10AUxss_8-";
    public static String API_Secret = "1wvLR6qXsPrhQHAwmv3ekjM-JbN8b9hH";
    public static String FaceSet = "ce5a1743232bd1763f0b15772e9ce0e0";
    public static FacePPApi faceppApi;

    private String TAG = "Facepp_Test";
    private ImageButton SearchImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "----onCreate----");

        faceppApi = new FacePPApi(API_Key, API_Secret);

        SearchImageBtn = findViewById(R.id.imageButton_search);
        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        SearchImageBtn.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId())
            {
                case R.id.imageButton_search:
                    //goto FaceSetActivity
                    intent = new Intent(MainActivity.this, FaceSetActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
