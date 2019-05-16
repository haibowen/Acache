package com.example.myacache;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import utils.ACache;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ACache aCache;
    private TextView mTextVie;
    private EditText mEditText;
    private Button mButtonSave;//存储的按钮
    private Button mButtonShow;//展示的按钮
    private Button mButtonNext;//跳转下一页

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        aCache = ACache.get(this);
        mTextVie = findViewById(R.id.tv_show);
        mEditText = findViewById(R.id.et_test);
        mButtonSave = findViewById(R.id.bt_test);
        mButtonShow = findViewById(R.id.bt_show);
        mButtonNext = findViewById(R.id.bt_next);
        mButtonShow.setOnClickListener(this);
        mButtonSave.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_test:
                aCache.put("ceshi", mEditText.getText().toString(), 2 * ACache.TIME_DAY);
                Toast.makeText(this, "存储成功", Toast.LENGTH_SHORT).show();
                break;

            case R.id.bt_show:
                getCach();
                Toast.makeText(this, "" + aCache.getAsString("ceshi"), Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_next:
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
        }

    }

    /**
     * 获取缓存中的数据
     */
    public void getCach() {
        mTextVie.setText(aCache.getAsString("ceshi"));

    }
}
