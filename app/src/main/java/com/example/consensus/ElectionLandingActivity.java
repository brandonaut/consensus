package com.example.consensus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class ElectionLandingActivity extends AppCompatActivity {
    private int mBallotsCast = 0;

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
        mBallotsCast++;

        UpdateActivity();
    }

    private void UpdateActivity()
    {
        TextView descriptionTextView = (TextView) findViewById(R.id.electionLandingText);
        Button showResultsButton = (Button) findViewById(R.id.showResultsButton);

        switch (mBallotsCast)
        {
            case 0:
                showResultsButton.setEnabled(false);
                descriptionTextView.setText("No ballots have been cast yet.");
                break;
            case 1:
                showResultsButton.setEnabled(true);
                descriptionTextView.setText("1 ballot has been cast so far. Anyone else voting?");
                break;
            default:
                showResultsButton.setEnabled(true);
                descriptionTextView.setText( Integer.toString(mBallotsCast) + " ballots have been cast so far. Anyone else voting?");
                break;
        }
    }
}
