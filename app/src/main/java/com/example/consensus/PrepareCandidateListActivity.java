package com.example.consensus;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PrepareCandidateListActivity extends AppCompatActivity {

    String mElectionTitle;
    ArrayList<String> listItems = new ArrayList<String>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_candidate_list);

        ListView candidateListView = (ListView) findViewById(R.id.CandidateListView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        candidateListView.setAdapter(adapter);
        registerForContextMenu(candidateListView);

        Intent intent = getIntent();
        mElectionTitle = intent.getStringExtra("electionTitle");

        Button addCandidateButton = (Button) findViewById(R.id.AddCandidateButton);

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.CandidateListView) {
            ListView lv = (ListView) v;
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
            String selectedCandidate = (String) lv.getItemAtPosition(acmi.position);

            menu.add("Edit");
            menu.add("Delete");
        }
    }

    private String new_name = "";
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int index = menuInfo.position;

        if(item.getTitle()=="Edit"){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    new_name = input.getText().toString();
                    listItems.set(index, new_name);
                    adapter.notifyDataSetChanged();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
        else if(item.getTitle()=="Delete"){
            listItems.remove(index);
            adapter.notifyDataSetChanged();
        }else{
            return false;
        }
        return true;
    }

    public void beginElection(View view) {
        Intent intent = new Intent(this, ElectionLandingActivity.class);
        intent.putExtra("electionTitle", mElectionTitle);

        Bundle b = new Bundle();
        b.putStringArrayList("Candidates", listItems);
        startActivity(intent, b);
    }
}
