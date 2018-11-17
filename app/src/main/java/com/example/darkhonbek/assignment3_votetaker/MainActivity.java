package com.example.darkhonbek.assignment3_votetaker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static Context context;

    private Result result = null;
    private String[] drinksArray;
    private String[] foodArray;

    private LinearLayout mainLinearLayout;
    private LinearLayout nameLinearLayout;
    private LinearLayout choiceLinearLayout;
    private LinearLayout drinksLinearLayout;
    private LinearLayout foodLinearLayout;

    private TextView questionTextView;
    private EditText nameEditText;
    private EditText lastNameEditText;
    private RadioButton agreeRadioButton;
    private RadioButton disagreeRadioButton;
    private TextView drinksTextView;
    private Spinner drinksSpinner;
    private TextView foodTextView;
    private Spinner foodSpinner;
    private Button voteButton;
    private Button resultsButton;

    // MARK: -

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = this;
        initData();
        initUI();

        setContentView(mainLinearLayout);
    }

    private void initData() {
        drinksArray = new String[] { "Vodka", "Cola", "Fanta" };
        foodArray = new String[] { "Shashlik", "Mashlik", "Kabob" };
    }

    private void initUI() {
        initMainLinearLayout();
        initInnerLayouts();
        initQuestionTextView();
        initNameEditText();
        initLastnameEditText();
        initAgreeRadioButton();
        initDisagreeRadioButton();
        initDrinksTextView();
        initDrinksSpinner();
        initFoodTextView();
        initFoodSpinner();
        initVoteButton();
        initResultsButton();

        mainLinearLayout.addView(questionTextView);
        mainLinearLayout.addView(nameLinearLayout);
        mainLinearLayout.addView(choiceLinearLayout);
        mainLinearLayout.addView(drinksLinearLayout);
        mainLinearLayout.addView(foodLinearLayout);
        mainLinearLayout.addView(voteButton);
        mainLinearLayout.addView(resultsButton);

        nameLinearLayout.addView(nameEditText);
        nameLinearLayout.addView(lastNameEditText);

        choiceLinearLayout.addView(agreeRadioButton);
        choiceLinearLayout.addView(disagreeRadioButton);

        drinksLinearLayout.addView(drinksTextView);
        drinksLinearLayout.addView(drinksSpinner);

        foodLinearLayout.addView(foodTextView);
        foodLinearLayout.addView(foodSpinner);

        agreeRadioButton.setChecked(true);
    }

    private void initMainLinearLayout() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(pixelsToDp(20), pixelsToDp(20), pixelsToDp(20), pixelsToDp(20));

        mainLinearLayout = new LinearLayout(this);
        mainLinearLayout.setLayoutParams(layoutParams);
        mainLinearLayout.setOrientation(LinearLayout.VERTICAL);
        mainLinearLayout.setClickable(true);
        mainLinearLayout.setFocusableInTouchMode(true);
        mainLinearLayout.setFocusable(true);
    }

    private void initInnerLayouts() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, pixelsToDp(20), 0, 0);

        nameLinearLayout = new LinearLayout(this);
        nameLinearLayout.setLayoutParams(layoutParams);
        nameLinearLayout.setWeightSum(2);

        choiceLinearLayout = new LinearLayout(this);
        choiceLinearLayout.setLayoutParams(layoutParams);
        choiceLinearLayout.setWeightSum(2);

        drinksLinearLayout = new LinearLayout(this);
        drinksLinearLayout.setLayoutParams(layoutParams);
        drinksLinearLayout.setWeightSum(2);
        drinksLinearLayout.setOrientation(LinearLayout.VERTICAL);

        foodLinearLayout = new LinearLayout(this);
        foodLinearLayout.setLayoutParams(layoutParams);
        foodLinearLayout.setWeightSum(2);
        foodLinearLayout.setOrientation(LinearLayout.VERTICAL);
    }

    private void initQuestionTextView() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        String text = "Will you come to the party?\nIf yes, what type of food and drink do you want?";

        questionTextView = new TextView(this);
        questionTextView.setText(text);
    }

    private void initNameEditText() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, pixelsToDp(40));
        layoutParams.setMargins(0, 0, pixelsToDp(20), 0);
        layoutParams.weight = 1;

        nameEditText = new EditText(this);
        nameEditText.setGravity(Gravity.LEFT);
        nameEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        nameEditText.setBackgroundResource(android.R.drawable.edit_text);
        nameEditText.setHint("First Name");
    }

    private void initLastnameEditText() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, pixelsToDp(40));
        layoutParams.weight = 1;

        lastNameEditText = new EditText(this);
        lastNameEditText.setGravity(Gravity.RIGHT);
        lastNameEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
        lastNameEditText.setBackgroundResource(android.R.drawable.edit_text);
        lastNameEditText.setHint("Last Name");
    }

    private void initAgreeRadioButton() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(0, 0, pixelsToDp(20), 0);
        layoutParams.weight = 1;

        agreeRadioButton = new RadioButton(this);
        agreeRadioButton.setLayoutParams(layoutParams);
        agreeRadioButton.setText("Agree");

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                disagreeRadioButton.setChecked(false);
            }
        };
        agreeRadioButton.setOnClickListener(listener);
    }

    private void initDisagreeRadioButton() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.weight = 1;

        disagreeRadioButton = new RadioButton(this);
        disagreeRadioButton.setLayoutParams(layoutParams);
        disagreeRadioButton.setText("Disagree");

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View v) {
                agreeRadioButton.setChecked(false);
            }
        };
        disagreeRadioButton.setOnClickListener(listener);
    }

    private void initDrinksTextView() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, pixelsToDp(10));
        layoutParams.weight = 1;

        drinksTextView = new TextView(this);
        drinksTextView.setText("Drinks");
    }

    private void initDrinksSpinner() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, pixelsToDp(50));
        layoutParams.weight = 1;

        drinksSpinner = new Spinner(this);
        drinksSpinner.setLayoutParams(layoutParams);
        drinksSpinner.setBackgroundResource(android.R.drawable.spinner_background);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, drinksArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        drinksSpinner.setAdapter(adapter);
    }

    private void initFoodTextView() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 0, 0, pixelsToDp(10));
        layoutParams.weight = 1;

        foodTextView = new TextView(this);
        foodTextView.setText("Food");
    }

    private void initFoodSpinner() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, pixelsToDp(50));
        layoutParams.weight = 1;

        foodSpinner = new Spinner(this);
        foodSpinner.setLayoutParams(layoutParams);
        foodSpinner.setBackgroundResource(android.R.drawable.spinner_background);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, foodArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        foodSpinner.setAdapter(adapter);
    }

    private void initVoteButton() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,pixelsToDp(20),0,0);

        voteButton = new Button(this);
        voteButton.setGravity(Gravity.CENTER);
        voteButton.setAllCaps(false);
        voteButton.setText("Vote");

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {
                voteButtonClicked(view);
            }
        };
        voteButton.setOnClickListener(listener);
    }

    private void initResultsButton() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0,pixelsToDp(20),0,0);

        resultsButton = new Button(this);
        resultsButton.setGravity(Gravity.CENTER);
        resultsButton.setAllCaps(false);
        resultsButton.setText("Results");

        View.OnClickListener listener = new View.OnClickListener() {
            public void onClick(View view) {
                resultsButtonClicked(view);
            }
        };
        resultsButton.setOnClickListener(listener);
    }

    // MARK: - Actions

    public void voteButtonClicked(View view) {
        String name = nameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        Boolean isComing = agreeRadioButton.isChecked();
        String drink = drinksSpinner.getSelectedItem().toString();
        String food = foodSpinner.getSelectedItem().toString();

        if (!name.isEmpty() && !lastName.isEmpty() && !drink.isEmpty() && !food.isEmpty()) {
            result = new Result(name, lastName, isComing, drink, food);
            Toast.makeText(this, "Vote submitted!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error.\nPlease, fill all the fields.", Toast.LENGTH_SHORT).show();
        }
    }

    public void resultsButtonClicked(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);

        if(result != null) {
            intent.putExtra("hasResult", true);
            intent.putExtra("result", result.toString());
        } else {
            intent.putExtra("hasResult", false);
        }

        startActivity(intent);
    }

    public static int pixelsToDp(int pixels) {
        final float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) pixels * density);
    }
}
