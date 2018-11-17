package com.example.darkhonbek.assignment3_votetaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class ResultsActivity extends AppCompatActivity {
    static String results = "";

//    private LinearLayout mainLinearLayout;
//    private TextView titleTextView;
    private TextView resultsTextView;
//    private Button clearVotesButton


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);
        initUI();
        updateResults();
    }

    private void initUI() {
        resultsTextView = findViewById(R.id.resultsTextView);
        resultsTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    private void updateResults() {
        Intent intent = getIntent();
        Boolean hasResult = intent.getBooleanExtra("hasResult", false);

        if(hasResult) {
            String result = intent.getStringExtra("result");
            results += result + "\n\n";
            resultsTextView.setText(results);
        }
    }

    public void clearVotesClicked(View view) {
    }
}
