package com.example.week3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

// Based on https://www.geeksforgeeks.org/how-to-add-a-pie-chart-into-an-android-application/
public class PieActivity extends AppCompatActivity {
    TextView tvHipHop, tvRnR, tvSamba;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvHipHop = findViewById(R.id.tvHipHop);
        tvRnR = findViewById(R.id.tvRnR);
        tvSamba = findViewById(R.id.tvSamba);
        pieChart = findViewById(R.id.piechart);

        setData();
    }

    private void setData() {
        // Set the percentage of language used
        tvHipHop.setText(Integer.toString(48));
        tvRnR.setText(Integer.toString(14));
        tvSamba.setText(Integer.toString(38));

        // Set the data and color to the pie chart
        pieChart.addPieSlice(new PieModel("Hip Hop",Integer.parseInt(tvHipHop.getText().toString()),
                Color.parseColor("#66BB6A")));

        pieChart.addPieSlice(new PieModel("Rock 'n' Roll",Integer.parseInt(tvRnR.getText().toString()),
                Color.parseColor("#EF5350")));

        pieChart.addPieSlice(new PieModel("Samba",Integer.parseInt(tvSamba.getText().toString()),
                Color.parseColor("#29B6F6")));

        // To animate the pie chart
        pieChart.startAnimation();
    }

    public void returnBtn(View view) {
        finish();
    }
}