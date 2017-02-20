package com.example.consensus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrepareCandidateListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_candidate_list);
    }

    public void beginElection(View view) {
        Intent intent = new Intent(this, ElectionLandingActivity.class);
        startActivity(intent);
    }
}
