package uk.co.mandilee.horror101;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int numberQuestions;
    private int numberAnswered;
    private int score;
    private String responseMessage;
    private double scorePercent;

    private LinearLayout question1;
    private LinearLayout question2;
    private LinearLayout question3;
    private LinearLayout question4;
    private LinearLayout question5;

    private TextView textQuestion1;
    private TextView textQuestion2;
    private TextView textQuestion3;
    private TextView textQuestion4;
    private TextView textQuestion5;

    private Drawable checkOn;
    private Drawable checkOff;

    private ArrayList<LinearLayout> listOfQuestionLayouts;// = new ArrayList();;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkOn = ContextCompat.getDrawable(this, android.R.drawable.checkbox_on_background);
        checkOff = ContextCompat.getDrawable(this, android.R.drawable.checkbox_off_background);

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

        // QUESTION 1
        textQuestion1 = (TextView) findViewById(R.id.question_1);
        question1 = (LinearLayout) findViewById(R.id.question_1_answers);

        textQuestion1.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleQuestion(question1);
            }
        });

        final RadioButton answer1a = (RadioButton) findViewById(R.id.answer_1a);
        answer1a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion1();
            }
        });

        final RadioButton answer1b = (RadioButton) findViewById(R.id.answer_1b);
        answer1b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion1();
            }
        });

        final RadioButton answer1c = (RadioButton) findViewById(R.id.answer_1c);
        answer1c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion1();
            }
        });

        // QUESTION 2
        textQuestion2 = (TextView) findViewById(R.id.question_2);
        question2 = (LinearLayout) findViewById(R.id.question_2_answers);

        textQuestion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleQuestion(question2);
            }
        });

        final CheckBox answer2a = (CheckBox) findViewById(R.id.answer_2a);
        answer2a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion2();
            }
        });

        final CheckBox answer2b = (CheckBox) findViewById(R.id.answer_2b);
        answer2b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion2();
            }
        });

        final CheckBox answer2c = (CheckBox) findViewById(R.id.answer_2c);
        answer2c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion2();
            }
        });

        // QUESTION 3
        textQuestion3 = (TextView) findViewById(R.id.question_3);
        question3 = (LinearLayout) findViewById(R.id.question_3_answers);

        textQuestion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleQuestion(question3);
            }
        });

        final RadioButton answer3a = (RadioButton) findViewById(R.id.answer_3a);
        answer3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion3();
            }
        });

        final RadioButton answer3b = (RadioButton) findViewById(R.id.answer_3b);
        answer3b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion3();
            }
        });

        final RadioButton answer3c = (RadioButton) findViewById(R.id.answer_3c);
        answer3c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion3();
            }
        });

        // QUESTION 4
        textQuestion4 = (TextView) findViewById(R.id.question_4);
        question4 = (LinearLayout) findViewById(R.id.question_4_answers);

        textQuestion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleQuestion(question4);
            }
        });

        final EditText answers4 = (EditText) findViewById(R.id.answer_4);
        answers4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    checkQuestion4();
            }
        });

        // QUESTION 5
        textQuestion5 = (TextView) findViewById(R.id.question_5);
        question5 = (LinearLayout) findViewById(R.id.question_5_answers);

        textQuestion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleQuestion(question5);
            }
        });

        final RadioButton answer5a = (RadioButton) findViewById(R.id.answer_5a);
        answer5a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion5();
            }
        });

        final RadioButton answer5b = (RadioButton) findViewById(R.id.answer_5b);
        answer5b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion5();
            }
        });

        final RadioButton answer5c = (RadioButton) findViewById(R.id.answer_5c);
        answer5c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkQuestion5();
            }
        });

        listOfQuestionLayouts = new ArrayList();
        listOfQuestionLayouts.add(question1);
        listOfQuestionLayouts.add(question2);
        listOfQuestionLayouts.add(question3);
        listOfQuestionLayouts.add(question4);
        listOfQuestionLayouts.add(question5);

        hideQuestions();

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
                textQuestion1.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOff, null);
                return;
        }
        textQuestion1.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOn, null);
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
            textQuestion2.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOn, null);
            numberAnswered += 1;
            return;
        }
        textQuestion2.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOff, null);
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
                textQuestion3.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOff, null);
                return;
        }
        textQuestion3.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOn, null);
        numberAnswered += 1;

    }

    private void checkQuestion4() {
        EditText et_answer4 = (EditText) findViewById(R.id.answer_4);
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
            textQuestion4.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOn, null);
            numberAnswered += 1;
        } else {
            textQuestion4.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOff, null);
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
                textQuestion5.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOff, null);
                return;
        }
        textQuestion5.setCompoundDrawablesWithIntrinsicBounds(null, null, checkOn, null);
        numberAnswered += 1;
    }

    @NonNull
    private String getScoreMessage() {
        int maxScore = 55;
        scorePercent = ((float) score / (float) maxScore) * 100;

        if (scorePercent < 0) {
            return getResources().getString(R.string.under_0);
        } else if (scorePercent < 25) {
            return getResources().getString(R.string.under_25);
        } else if (scorePercent < 50) {
            return getResources().getString(R.string.under_50);
        } else if (scorePercent < 75) {
            return getResources().getString(R.string.under_75);
        } else if (scorePercent < 100) {
            return getResources().getString(R.string.under_100);
        } else {
            return getResources().getString(R.string.full_marks);
        }
    }

    private void hideQuestions() {
        for (LinearLayout questionLayout : listOfQuestionLayouts) {
            questionLayout.setAlpha(0.0f);
            questionLayout.setVisibility(View.GONE);
        }
    }

    private void toggleQuestion(final LinearLayout question) {
        for (LinearLayout questionLayout : listOfQuestionLayouts) {
            if (questionLayout.equals(question) && !questionLayout.isShown()) {
                // Prepare the View for the animation
                questionLayout.setVisibility(View.VISIBLE);
                //questionLayout.setAlpha(0.0f);

                // Start the animation
                questionLayout.animate().alpha(1.0f);

            } else if (questionLayout.isShown()) {
                questionLayout.animate().alpha(0.0f);
                questionLayout.setVisibility(View.GONE);
            }
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        RadioGroup rg_Answer1 = (RadioGroup) findViewById(R.id.answers1);
        int i_Answer1 = rg_Answer1.getCheckedRadioButtonId();

        RadioGroup rg_Answer3 = (RadioGroup) findViewById(R.id.answers3);
        int i_Answer3 = rg_Answer3.getCheckedRadioButtonId();

        RadioGroup rg_Answer5 = (RadioGroup) findViewById(R.id.answers5);
        int i_Answer5 = rg_Answer5.getCheckedRadioButtonId();

        outState.putInt("answer1", i_Answer1);
        outState.putInt("answer3", i_Answer3);
        outState.putInt("answer5", i_Answer5);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState.getInt("answer1") != -1) {
            RadioButton v_Answer1 = (RadioButton) findViewById(savedInstanceState.getInt("answer1"));
            v_Answer1.setChecked(true);
        }

        if (savedInstanceState.getInt("answer3") != -1) {
            RadioButton v_Answer3 = (RadioButton) findViewById(savedInstanceState.getInt("answer3"));
            v_Answer3.setChecked(true);
        }

        if (savedInstanceState.getInt("answer5") != -1) {
            RadioButton v_Answer5 = (RadioButton) findViewById(savedInstanceState.getInt("answer5"));
            v_Answer5.setChecked(true);
        }

        checkAnswers();
    }

}

//Toast.makeText(getApplicationContext(), String.valueOf(idx), Toast.LENGTH_SHORT).show();
