package com.jingyan.facepp_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.bean.FaceSetDetailResponse;

import java.util.HashMap;
import java.util.Map;

public class FaceSetActivity extends AppCompatActivity {

    private Button GetDetailBtn;
    private TextView RetTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_set);

        GetDetailBtn = findViewById(R.id.button_faceset);
        RetTextView = findViewById(R.id.textView_return);

        GetDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButtonSearchHandle();
            }
        });
    }


    private void ImageButtonSearchHandle() {
        Map<String, String> params = new HashMap<>();
        params.put("faceset_token", MainActivity.FaceSet);
        MainActivity.faceppApi.facesetDetail(params, new IFacePPCallBack<FaceSetDetailResponse>() {
            @Override
            public void onSuccess(FaceSetDetailResponse faceSetDetailResponse) {
                refreshView(faceSetDetailResponse.toString());
            }

            @Override
            public void onFailed(String s) {
                refreshView(s);
            }
        });
    }

    private void refreshView(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                RetTextView.setText(response);
            }
        });
    }
}
