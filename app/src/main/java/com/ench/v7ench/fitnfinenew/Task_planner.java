package com.ench.v7ench.fitnfinenew;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Task_planner extends AppCompatActivity {
TextView Ttask_title;
ImageView Itask_image;
String Stask_title,Simga_task;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_planner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context=Task_planner.this;
        Ttask_title=(TextView) findViewById(R.id.textView2);
        Itask_image=(ImageView) findViewById(R.id.imageView2);
        Stask_title=getIntent().getStringExtra("mytask");
        Simga_task=getIntent().getStringExtra("task_image");
        Ttask_title.setText(Stask_title);
        Glide.with(context).load(Simga_task).into(Itask_image);

    }

}
