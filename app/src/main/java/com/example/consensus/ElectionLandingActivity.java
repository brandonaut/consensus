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
    private static final int NEW_BALLOT_REQUEST = 1;
    private int mBallotsCast = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election_landing);

        // Update title
        Intent intent = getIntent();
        String electionTitle = intent.getStringExtra("electionTitle");
        if (electionTitle != null) {
            setTitle(electionTitle);
        }

    }

    public void showResults(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void newBallot(View view) {
        Intent newBallotIntent = new Intent(this, BallotActivity.class);
        startActivityForResult(newBallotIntent, NEW_BALLOT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_BALLOT_REQUEST) {
            if (resultCode == RESULT_OK) {
                mBallotsCast++;
            }
        }
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
                descriptionTextView.setText(Integer.toString(mBallotsCast) + " ballots have been cast so far. Anyone else voting?");
                break;
        }
    }
}
