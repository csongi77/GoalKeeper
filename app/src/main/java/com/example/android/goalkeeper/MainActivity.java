package com.example.android.goalkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // declaring variables & TextView variable names
    private static final String A_RESULT="a_result";
    private static final String B_RESULT="b_result";
    private static final String A_YELLOW="a_yellow";
    private static final String B_YELLOW="b_yellow";
    private static final String A_RED="a_red";
    private static final String B_RED="b_red";

    private int teamA_goal;
    private int teamB_goal;
    private int teamA_yellowCard;
    private int teamB_yellowCard;
    private int teamA_redCard;
    private int teamB_redCard;
    private TextView team_a_result,
            team_b_result,
            team_a_red_number,
            team_b_red_number,
            team_a_yellow_number,
            team_b_yellow_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing
        teamA_goal = 0;
        teamB_goal = 0;
        teamA_yellowCard = 0;
        teamB_yellowCard = 0;
        teamA_redCard = 0;
        teamB_redCard = 0;
        team_a_result = (TextView) findViewById(R.id.team_a_result);
        team_b_result = (TextView) findViewById(R.id.team_b_result);
        team_a_red_number = (TextView) findViewById(R.id.team_a_red_number);
        team_b_red_number = (TextView) findViewById(R.id.team_b_red_number);
        team_a_yellow_number = (TextView) findViewById(R.id.team_a_yellow_number);
        team_b_yellow_number = (TextView) findViewById(R.id.team_b_yellow_number);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //saving current results state
        outState.putInt(A_RESULT,teamA_goal);
        outState.putInt(B_RESULT,teamB_goal);
        outState.putInt(A_YELLOW,teamA_yellowCard);
        outState.putInt(B_YELLOW,teamB_yellowCard);
        outState.putInt(A_RED,teamA_redCard);
        outState.putInt(B_RED,teamB_redCard);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      //  super.onRestoreInstanceState(savedInstanceState);
        // restoring state
        teamA_goal=savedInstanceState.getInt(A_RESULT);
        teamB_goal=savedInstanceState.getInt(B_RESULT);
        teamA_yellowCard=savedInstanceState.getInt(A_YELLOW);
        teamB_yellowCard=savedInstanceState.getInt(B_YELLOW);
        teamA_redCard=savedInstanceState.getInt(A_RED);
        teamB_redCard=savedInstanceState.getInt(B_RED);

        // displaying current gameState
        dislplayResult(team_a_result, teamA_goal);
        dislplayResult(team_a_red_number, teamA_redCard);
        dislplayResult(team_a_yellow_number, teamA_yellowCard);
        dislplayResult(team_b_result, teamB_goal);
        dislplayResult(team_b_red_number, teamB_redCard);
        dislplayResult(team_b_yellow_number, teamB_yellowCard);
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
        dislplayResult(team_a_result, ++teamA_goal);
    }

    public void team_a_redcard(View view) {
        dislplayResult(team_a_red_number, ++teamA_redCard);
    }

    public void team_a_yellowcard(View view) {
        dislplayResult(team_a_yellow_number, ++teamA_yellowCard);
    }

    public void team_b_goal(View view) {
        dislplayResult(team_b_result, ++teamB_goal);
    }

    public void team_b_redcard(View view) {
        dislplayResult(team_b_red_number, ++teamB_redCard);
    }

    public void team_b_yellowcard(View view) {
        dislplayResult(team_b_yellow_number, ++teamB_yellowCard);
    }

    /**
     * resetting values
     */

    public void reset(View view) {
        teamA_goal = 0;
        teamB_goal = 0;
        teamA_yellowCard = 0;
        teamB_yellowCard = 0;
        teamA_redCard = 0;
        teamB_redCard = 0;
        dislplayResult(team_a_result, teamA_goal);
        dislplayResult(team_a_red_number, teamA_redCard);
        dislplayResult(team_a_yellow_number, teamA_yellowCard);
        dislplayResult(team_b_result, teamB_goal);
        dislplayResult(team_b_red_number, teamB_redCard);
        dislplayResult(team_b_yellow_number, teamB_yellowCard);
    }
}
