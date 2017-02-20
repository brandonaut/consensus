package com.example.consensus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ElectionSetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_election_setup);
    }

    public void createCandidateList(View view) {
        Intent intent = new Intent(this, PrepareCandidateListActivity.class);
        startActivity(intent);
    }
}
