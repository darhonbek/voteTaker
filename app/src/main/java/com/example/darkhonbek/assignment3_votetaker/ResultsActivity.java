package com.example.darkhonbek.assignment3_votetaker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {
    static String results = "";

    private static Context context;

    private List<Vote> votes;

    private LinearLayout mainLinearLayout;
    private TextView titleTextView;
    private TextView resultsTextView;
    private Button clearVotesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        initData();
        initUI();
        updateResults();

        setContentView(mainLinearLayout);
    }

    private void initData() {
        votes = new ArrayList<>();

    }

    private void initUI() {
        initMainLinearLayout();
        initTitleTextView();
        initResultsTextView();
        initClearVotesButton();

        mainLinearLayout.addView(titleTextView);
        mainLinearLayout.addView(resultsTextView);
        mainLinearLayout.addView(clearVotesButton);
    }

    private void initMainLinearLayout() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(pixelsToDp(20), pixelsToDp(20), pixelsToDp(20), pixelsToDp(20));

        mainLinearLayout = new LinearLayout(this);
        mainLinearLayout.setLayoutParams(layoutParams);
        mainLinearLayout.setOrientation(LinearLayout.VERTICAL);
    }

    private void initTitleTextView() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, pixelsToDp(40));

        titleTextView = new TextView(this);
        titleTextView.setLayoutParams(layoutParams);
        titleTextView.setTextSize(30);
        titleTextView.setTypeface(titleTextView.getTypeface(), Typeface.BOLD);
        titleTextView.setText("Voting Results");
    }

    private void initResultsTextView() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.weight = 1;

        resultsTextView = new TextView(this);
        resultsTextView.setLayoutParams(layoutParams);
        resultsTextView.setBackgroundResource(android.R.drawable.divider_horizontal_textfield);
        resultsTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    private void initClearVotesButton() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, pixelsToDp(10), 0, 0);
        layoutParams.gravity = Gravity.CENTER;

        clearVotesButton = new Button(this);
        clearVotesButton.setLayoutParams(layoutParams);
        clearVotesButton.setAllCaps(false);
        clearVotesButton.setText("Clear Votes");

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {
                clearResults();
            }
        };
        clearVotesButton.setOnClickListener(listener);
    }

    // MARK: - Actions

    private void updateResults() {
        Intent intent = getIntent();
        Boolean hasResult = intent.getBooleanExtra("hasResult", false);

        if(hasResult) {
            String vote = intent.getStringExtra("result");
            votes.add(Vote.getVoteFromString(vote));
        }

        String votesText = "";

        for (Vote vote: votes) {
            votesText += vote.toString() + "\n";
        }

        resultsTextView.setText(votesText);
    }

    private void clearResults() {
        // FIXME - Clear Results
        resultsTextView.setText("");
        votes.clear();
    }

    public static int pixelsToDp(int pixels) {
        final float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) pixels * density);
    }
}
