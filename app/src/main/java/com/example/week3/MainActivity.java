package com.example.week3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Intent pieActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        pieActivity = new Intent(this, PieActivity.class);
    }

    public void button1(View view) {
        Toast.makeText(this, btn1.getText().toString(),
                Toast.LENGTH_LONG).show();
        startActivity(pieActivity);
    }

    public void button2(View view) {
        Toast.makeText(this, btn2.getText().toString(),
                Toast.LENGTH_LONG).show();
        startActivity(pieActivity);
    }

    public void button3(View view) {
        Toast.makeText(this, btn3.getText().toString(),
                Toast.LENGTH_LONG).show();
        startActivity(pieActivity);
    }
}