package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterSelectActivity extends AppCompatActivity {

    class selectListener implements View.OnClickListener { //나누미&나누머 색상 변경 리스너
        TextView nextTv = (TextView) findViewById(R.id.register_select_next_tv);
        Button nanumi_icon = (Button) findViewById(R.id.register_select_nanumi_icon);
        Button nanumer_icon = (Button) findViewById(R.id.register_select_nanumer_icon);
        private String userValue = ""; //서버에 넘길값
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.register_select_nanumi_icon:
                    nanumer_icon.setSelected(false);
                    nanumi_icon.setSelected(!nanumi_icon.isSelected());
                    nextTv.setVisibility(View.VISIBLE); //다음 버튼 클릭 가능
                    userValue = "nanumi";
                    Log.d("userValue", userValue);
                    break;

                case R.id.register_select_nanumer_icon:
                    nanumi_icon.setSelected(false);
                    nanumer_icon.setSelected(!nanumer_icon.isSelected());
                    nextTv.setVisibility(View.VISIBLE); //다음 버튼 클릭 가능
                    userValue = "nanumer";
                    Log.d("userValue", userValue);
                    break;

                case R.id.register_select_next_tv:
                    if(userValue.equals("nanumi")) { //나누미 버튼을 눌렀을 경우
                        Intent intent = new Intent(RegisterSelectActivity.this, RegisterNanumiCertifyActivity.class);
                        startActivity(intent);
                    }
                    else if (userValue.equals("nanumer")) {
                        Intent intent = new Intent(RegisterSelectActivity.this, RegisterNanumiInfoInput1Activity.class);
                        startActivity(intent);
                    }
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_select);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ffffff"));

        selectListener onClickListener = new selectListener();

        Button nanumi_icon = (Button) findViewById(R.id.register_select_nanumi_icon);
        nanumi_icon.setOnClickListener(onClickListener); //나누미-클릭리스터
        Button nanumer_icon = (Button) findViewById(R.id.register_select_nanumer_icon);
        nanumer_icon.setOnClickListener(onClickListener); //나누머-클릭리스너

        TextView nextTv = (TextView) findViewById(R.id.register_select_next_tv);
        nextTv.setOnClickListener(onClickListener); //다음 버튼-클릭리스너

    }
}