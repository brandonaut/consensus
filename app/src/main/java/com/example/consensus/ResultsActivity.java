package com.example.consensus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();

        // Update results list
        TextView resultsTextView = (TextView) findViewById(R.id.resultsTextView);
        String results = intent.getStringExtra("results");
        if (results == null || results.isEmpty()) {
            resultsTextView.setText(R.string.no_results);
        }
        else {
            resultsTextView.setText(results);
        }
    }

    public void newElection(View view) {
        Intent intent = new Intent(this, ElectionSetupActivity.class);
        startActivity(intent);
    }
}
