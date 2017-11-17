package com.example.android.goalkeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int teamA_goal=0;
    private int teamB_goal=0;
    private int teamA_yellowCard=0;
    private int teamB_yellowCard=0;
    private int teamA_redCard=0;
    private int teamB_redCard=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * displaying result
     */
    public void dislplayResult(TextView textView, int result){
        textView.setText(Integer.toString(result));
    }

    /**
     *
     * adding values in case of onClick event
     */

    public void team_a_goal(View view) {
        dislplayResult((TextView)findViewById(R.id.team_a_result),++teamA_goal);
    }

    public void team_a_redcard(View view) {
        dislplayResult((TextView)findViewById(R.id.team_a_red_number),++teamA_redCard);
    }

    public void team_a_yellowcard(View view) {
        dislplayResult((TextView)findViewById(R.id.team_a_yellow_number),++teamA_yellowCard);
    }

    public void team_b_goal(View view) {
        dislplayResult((TextView)findViewById(R.id.team_b_result),++teamB_goal);
    }

    public void team_b_redcard(View view) {
        dislplayResult((TextView)findViewById(R.id.team_b_red_number),++teamB_redCard);
    }

    public void team_b_yellowcard(View view) {
        dislplayResult((TextView)findViewById(R.id.team_b_yellow_number),++teamB_yellowCard);
    }

    /**
     *
     * reseting values
     */

    public void reset (View view){
        teamA_goal=0;
        teamB_goal=0;
        teamA_yellowCard=0;
        teamB_yellowCard=0;
        teamA_redCard=0;
        teamB_redCard=0;
        dislplayResult((TextView)findViewById(R.id.team_a_result),teamA_goal);
        dislplayResult((TextView)findViewById(R.id.team_a_red_number),teamA_redCard);
        dislplayResult((TextView)findViewById(R.id.team_a_yellow_number),teamA_yellowCard);
        dislplayResult((TextView)findViewById(R.id.team_b_result),teamB_goal);
        dislplayResult((TextView)findViewById(R.id.team_b_red_number),teamB_redCard);
        dislplayResult((TextView)findViewById(R.id.team_b_yellow_number),teamB_yellowCard);
    }
}
