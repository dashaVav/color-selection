package com.example.firstprogram;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText colorEditText;
    Button changeColorButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        colorEditText = (EditText) findViewById(R.id.inputColor);
        changeColorButton = (Button) findViewById(R.id.changeColorButton);
        changeColorButton.setOnClickListener(this);
        setupTextChangeListener();
    }

    private void setupTextChangeListener() {
        colorEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String selectedColor = charSequence.toString().toLowerCase();
                changeColorButton.setEnabled(selectedColor.equals("red")
                        || selectedColor.equals("green") || selectedColor.equals("blue"));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        String selectedColor = colorEditText.getText().toString().toLowerCase();

        Intent intent = new Intent(MainActivity.this, ColorsActivity.class);
        intent.putExtra("color", selectedColor);
        startActivity(intent);

    }
}
