package uk.co.mandilee.horror101;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int numberQuestions;
    private int numberAnswered;
    private int score;
    private String responseMessage;
    private double scorePercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = (Button) findViewById(R.id.submit_button);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberQuestions = 0;
                numberAnswered = 0;
                score = 0;
                responseMessage = "";

                checkAnswers();

                if (responseMessage.equals("")) {
                    if (numberQuestions == numberAnswered) {
                        responseMessage = getScoreMessage() + "Your Score: " + String.format("%.0f", scorePercent) + "%";
                    } else {
                        responseMessage = "You haven't answered all the questions yet!";
                    }
                }

                // make snackbar
                Snackbar mSnackbar = Snackbar.make(view, responseMessage, Snackbar.LENGTH_LONG);
                // get snackbar view
                View mView = mSnackbar.getView();
                // get textview inside snackbar view
                TextView mTextView = (TextView) mView.findViewById(android.support.design.R.id.snackbar_text);
                mTextView.setTextColor(Color.BLACK);
                mTextView.setTextSize(18);
                mTextView.setBackgroundColor(Color.RED);
                // set text to center
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    mTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else {
                    mTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                }
                // show the snackbar
                mSnackbar.show();
            }


        });

    }

    private void checkAnswers() {
        checkQuestion1();
        checkQuestion2();
        checkQuestion3();
        checkQuestion4();
        checkQuestion5();
    }

    private void checkQuestion1() {
        RadioGroup rg_Answer1 = (RadioGroup) findViewById(R.id.answers1);
        int i_Answer1 = rg_Answer1.getCheckedRadioButtonId();
        View v_Answer1 = rg_Answer1.findViewById(i_Answer1);
        int answer1 = rg_Answer1.indexOfChild(v_Answer1);

        numberQuestions += 1;

        switch (answer1) {
            case 0:
                score += 5;
                break;
            case 1:
                score += 0;
                break;
            case 2:
                score += 10;
                break;
            default:
                return;
        }
        numberAnswered += 1;
    }

    private void checkQuestion2() {
        boolean isAnswered = false;
        int maxAnswers = 2;
        int numAnswersGiven = 0;
        numberQuestions += 1;

        CheckBox twoA = (CheckBox) findViewById(R.id.answer_2a);
        if (twoA.isChecked()) {
            isAnswered = true;
            numAnswersGiven += 1;
            score -= 10;
        } else {
            score += 5;
        }

        CheckBox twoB = (CheckBox) findViewById(R.id.answer_2b);
        if (twoB.isChecked()) {
            isAnswered = true;
            numAnswersGiven += 1;
            score += 5;
        } else {
            score -= 5;
        }

        CheckBox twoC = (CheckBox) findViewById(R.id.answer_2c);
        if (twoC.isChecked()) {
            isAnswered = true;
            numAnswersGiven += 1;
            score += 5;
        } else {
            score -= 5;
        }

        if (numAnswersGiven > maxAnswers) {
            responseMessage += "Too many answers selected in Q2\n";
        } else if (isAnswered) {
            numberAnswered += 1;
        }
    }

    private void checkQuestion3() {
        RadioGroup rg_Answer3 = (RadioGroup) findViewById(R.id.answers3);
        int i_Answer3 = rg_Answer3.getCheckedRadioButtonId();
        View v_Answer3 = rg_Answer3.findViewById(i_Answer3);
        int answer3 = rg_Answer3.indexOfChild(v_Answer3);

        numberQuestions += 1;

        switch (answer3) {
            case 0:
                score += 5;
                break;
            case 1:
                score += 0;
                break;
            case 2:
                score += 10;
                break;
            default:
                return;
        }
        numberAnswered += 1;

    }

    private void checkQuestion4() {
        EditText et_answer4 = (EditText) findViewById(R.id.answers4);
        String answer4 = String.valueOf(et_answer4.getText());

        numberQuestions += 1;
        if (answer4.length() > 0) {
            if (answer4.compareToIgnoreCase("me") == 0) {
                score -= 10;
            } else if (answer4.compareToIgnoreCase("i am") == 0) {
                score -= 10;
            } else {
                score += 10;
            }
            numberAnswered += 1;
        }
    }

    private void checkQuestion5() {
        RadioGroup rg_Answer5 = (RadioGroup) findViewById(R.id.answers5);
        int i_Answer5 = rg_Answer5.getCheckedRadioButtonId();
        View v_Answer5 = rg_Answer5.findViewById(i_Answer5);
        int answer5 = rg_Answer5.indexOfChild(v_Answer5);

        numberQuestions += 1;

        switch (answer5) {
            case 0:
                score += 0;
                break;
            case 1:
                score += 5;
                break;
            case 2:
                score += 10;
                break;
            default:
                return;
        }
        numberAnswered += 1;
    }

    private String getScoreMessage() {
        int maxScore = 55;
        scorePercent = ((float) score / (float) maxScore) * 100;

        Log.i("Score", String.valueOf(score));
        Log.i("Score", String.valueOf(maxScore));
        Log.i("scorePercent", String.valueOf((float) score / (float) maxScore));
        Log.i("scorePercent", String.valueOf(scorePercent));

        if (scorePercent < 0) {
            return getResources().getString(R.string.under_0);
        } else if (scorePercent < 25) {
            return getResources().getString(R.string.under_25);
        } else if (scorePercent < 5) {
            return getResources().getString(R.string.under_50);
        } else if (scorePercent < 75) {
            return getResources().getString(R.string.under_75);
        } else if (scorePercent < 100) {
            return getResources().getString(R.string.under_100);
        } else {
            return getResources().getString(R.string.full_marks);
        }
    }
}

//Toast.makeText(getApplicationContext(), String.valueOf(idx), Toast.LENGTH_SHORT).show();
