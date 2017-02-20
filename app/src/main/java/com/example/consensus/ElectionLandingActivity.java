package com.example.consensus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class ElectionLandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election_landing);
    }

    public void showResults(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void newBallot(View view) {
        //TODO: Create new ballot activity
        Toast.makeText(this, "Ballot successfully cast", LENGTH_SHORT).show();
    }
}
