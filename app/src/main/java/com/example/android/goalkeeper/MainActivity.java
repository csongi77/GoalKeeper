package com.example.android.goalkeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // declaring variables & TextView variable names
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
        outState.putInt("a_result",teamA_goal);
        outState.putInt("b_result",teamB_goal);
        outState.putInt("a_yellow",teamA_yellowCard);
        outState.putInt("b_yellow",teamB_yellowCard);
        outState.putInt("a_red",teamA_redCard);
        outState.putInt("b_red",teamB_redCard);
        Log.e("saveInstanceState", "A goal: "+teamA_goal);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      //  super.onRestoreInstanceState(savedInstanceState);
        // restoring state
        teamA_goal=savedInstanceState.getInt("a_result");
        teamB_goal=savedInstanceState.getInt("b_result");
        teamA_yellowCard=savedInstanceState.getInt("a_yellow");
        teamB_yellowCard=savedInstanceState.getInt("b_yellow");
        teamA_redCard=savedInstanceState.getInt("a_red");
        teamB_redCard=savedInstanceState.getInt("b_red");
        Log.e("restoreInstanceState", "A goal: "+teamA_goal);

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
