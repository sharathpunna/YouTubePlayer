package com.example.punna.youtubeplayr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnn1=(Button) findViewById(R.id.button1);
        Button btnn2=(Button) findViewById(R.id.button2);

        btnn1.setOnClickListener(this);
        btnn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()){
            case R.id.button1:{
                intent=new Intent(this,YoutubeActivity.class);
                break;
            }
            case R.id.button2:{
                intent=new Intent(this,StandaloneActivity.class);
                break;
            }
            default:

        }
        if (intent!=null)
            startActivity(intent);

    }
}
