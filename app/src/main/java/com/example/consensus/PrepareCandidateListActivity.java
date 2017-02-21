package com.example.consensus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PrepareCandidateListActivity extends AppCompatActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_candidate_list);

        ListView candidateListView = (ListView) findViewById(R.id.CandidateListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        candidateListView.setAdapter(adapter);

        Button addCandidateButton = (Button) findViewById(R.id.AddCandidateButton);
        Button beginElectionButton = (Button) findViewById(R.id.beginElectionButton);

        addCandidateButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        EditText candidateTextBox = (EditText) findViewById(R.id.CandidateTextBox);
                        if(candidateTextBox.getText().toString() != "")
                        {
                            listItems.add(0, candidateTextBox.getText().toString());
                            candidateTextBox.setText("");
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
        );
    }

    public void beginElection(View view) {
        Intent intent = new Intent(this, ElectionLandingActivity.class);
        Bundle b = new Bundle();
        b.putStringArrayList("Candidates", listItems);
        startActivity(intent, b);
    }
}
