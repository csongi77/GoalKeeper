package com.example.android.goalkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // declaring constants, variables & TextView variable names
    private static final String BUNDLE_A_RESULT ="BUNDLE_A_RESULT";
    private static final String BUNDLE_B_RESULT ="BUNDLE_B_RESULT";
    private static final String BUNDLE_A_YELLOW ="BUNDLE_A_YELLOW";
    private static final String BUNDLE_B_YELLOW ="BUNDLE_B_YELLOW";
    private static final String BUNDLE_A_RED ="BUNDLE_A_RED";
    private static final String BUNDLE_B_RED ="BUNDLE_B_RED";

    private int mTeamA_goal;
    private int mTeamB_goal;
    private int mTeamA_yellowCard;
    private int mTeamB_yellowCard;
    private int mTeamA_redCard;
    private int mTeamB_redCard;
    private TextView mTextViewTeamAResult,
            mTextViewTeamBResult,
            mTextViewTeamARedNumber,
            mTextViewTeamBRedNumber,
            mTextViewTeamAYellowNumber,
            mTextViewTeamBYellowNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing
        mTeamA_goal = 0;
        mTeamB_goal = 0;
        mTeamA_yellowCard = 0;
        mTeamB_yellowCard = 0;
        mTeamA_redCard = 0;
        mTeamB_redCard = 0;
        mTextViewTeamAResult = findViewById(R.id.text_team_a_result);
        mTextViewTeamBResult = findViewById(R.id.text_team_b_result);
        mTextViewTeamARedNumber = findViewById(R.id.text_team_a_red_number);
        mTextViewTeamBRedNumber = findViewById(R.id.text_team_b_red_number);
        mTextViewTeamAYellowNumber = findViewById(R.id.text_team_a_yellow_number);
        mTextViewTeamBYellowNumber = findViewById(R.id.text_team_b_yellow_number);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //saving current results state
        outState.putInt(BUNDLE_A_RESULT, mTeamA_goal);
        outState.putInt(BUNDLE_B_RESULT, mTeamB_goal);
        outState.putInt(BUNDLE_A_YELLOW, mTeamA_yellowCard);
        outState.putInt(BUNDLE_B_YELLOW, mTeamB_yellowCard);
        outState.putInt(BUNDLE_A_RED, mTeamA_redCard);
        outState.putInt(BUNDLE_B_RED, mTeamB_redCard);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // restoring state
        mTeamA_goal =savedInstanceState.getInt(BUNDLE_A_RESULT);
        mTeamB_goal =savedInstanceState.getInt(BUNDLE_B_RESULT);
        mTeamA_yellowCard =savedInstanceState.getInt(BUNDLE_A_YELLOW);
        mTeamB_yellowCard =savedInstanceState.getInt(BUNDLE_B_YELLOW);
        mTeamA_redCard =savedInstanceState.getInt(BUNDLE_A_RED);
        mTeamB_redCard =savedInstanceState.getInt(BUNDLE_B_RED);

        // displaying current gameState
        dislplayResult(mTextViewTeamAResult, mTeamA_goal);
        dislplayResult(mTextViewTeamARedNumber, mTeamA_redCard);
        dislplayResult(mTextViewTeamAYellowNumber, mTeamA_yellowCard);
        dislplayResult(mTextViewTeamBResult, mTeamB_goal);
        dislplayResult(mTextViewTeamBRedNumber, mTeamB_redCard);
        dislplayResult(mTextViewTeamBYellowNumber, mTeamB_yellowCard);
    }

    /**
     * displaying result
     */
    public void dislplayResult(TextView textView, int result) {
        textView.setText(Integer.toString(result));
    }

    /**
     * adding values in case of onClick event
     */
    public void team_a_goal(View view) {
        dislplayResult(mTextViewTeamAResult, ++mTeamA_goal);
    }

    public void team_a_redcard(View view) {
        dislplayResult(mTextViewTeamARedNumber, ++mTeamA_redCard);
    }

    public void team_a_yellowcard(View view) {
        dislplayResult(mTextViewTeamAYellowNumber, ++mTeamA_yellowCard);
    }

    public void team_b_goal(View view) {
        dislplayResult(mTextViewTeamBResult, ++mTeamB_goal);
    }

    public void team_b_redcard(View view) {
        dislplayResult(mTextViewTeamBRedNumber, ++mTeamB_redCard);
    }

    public void team_b_yellowcard(View view) {
        dislplayResult(mTextViewTeamBYellowNumber, ++mTeamB_yellowCard);
    }

    /**
     * resetting values
     */
    public void reset(View view) {
        mTeamA_goal = 0;
        mTeamB_goal = 0;
        mTeamA_yellowCard = 0;
        mTeamB_yellowCard = 0;
        mTeamA_redCard = 0;
        mTeamB_redCard = 0;
        dislplayResult(mTextViewTeamAResult, mTeamA_goal);
        dislplayResult(mTextViewTeamARedNumber, mTeamA_redCard);
        dislplayResult(mTextViewTeamAYellowNumber, mTeamA_yellowCard);
        dislplayResult(mTextViewTeamBResult, mTeamB_goal);
        dislplayResult(mTextViewTeamBRedNumber, mTeamB_redCard);
        dislplayResult(mTextViewTeamBYellowNumber, mTeamB_yellowCard);
    }
}
