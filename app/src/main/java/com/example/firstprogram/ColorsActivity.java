package com.example.firstprogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

public class ColorsActivity extends Activity implements View.OnClickListener {

    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        setColor();
        backButton = findViewById(R.id.back);
        backButton.setOnClickListener(this);
    }

    private void setColor() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }

        String selectedColor = intent.getStringExtra("color");
        if (selectedColor == null) {
            return;
        }

        View view = getWindow().getDecorView();
        int backgroundColor = ContextCompat.getColor(this, R.color.black);
        switch (selectedColor) {
            case "red":
                backgroundColor = ContextCompat.getColor(this, R.color.red);
                break;
            case "green":
                backgroundColor = ContextCompat.getColor(this, R.color.green);
                break;
            case "blue":
                backgroundColor = ContextCompat.getColor(this, R.color.blue);
                break;
        }
        view.setBackgroundColor(backgroundColor);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}

