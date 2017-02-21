package com.example.consensus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BallotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballot);
    }

    public void castBallot(View view) {
        String[] test = {"one", "two", "three"};
        Intent intent = new Intent();
        intent.putExtra("hello", "world");
        setResult(RESULT_OK, intent);
        finish();
    }
}
