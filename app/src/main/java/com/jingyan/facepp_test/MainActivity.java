package com.jingyan.facepp_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.megvii.facepp.api.FacePPApi;
import com.megvii.facepp.api.IFacePPCallBack;
import com.megvii.facepp.api.bean.FaceSetDetailResponse;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Facepp_Test";
    private String API_Key = "jnKErmEcRWpMI1UHB2rNZF10AUxss_8-";
    private String API_Secret = "1wvLR6qXsPrhQHAwmv3ekjM-JbN8b9hH";
    private String FaceSet = "ce5a1743232bd1763f0b15772e9ce0e0";
    FacePPApi faceppApi;

    private Button FaceSetBtn;
    private TextView RetTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        faceppApi = new FacePPApi(API_Key, API_Secret);

        RetTextView = findViewById(R.id.textView_return);

        FaceSetBtn = findViewById(R.id.button_faceset);
        FaceSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, String> params = new HashMap<>();
                params.put("faceset_token", FaceSet);
                faceppApi.facesetDetail(params, new IFacePPCallBack<FaceSetDetailResponse>() {
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
