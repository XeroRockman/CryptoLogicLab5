package com.example.andrewbrumbeloe.cryptologiclab5;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    String letterGuessString;
    Button submitButton;
    EditText letterInput;
    TextView lettersSolved;


    ArrayList<String> words = new ArrayList<>(Arrays.asList("APPLE", "BANANA", "CHERRY", "CHOCOLATE", "CABLE", "COMPUTER", "PYTHON", "WATER", "GREEN", "ORANGE", "BLUE", "YELLOW"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //
        //
        //

        //letterInput = (EditText) findViewById(R.id.userInput);

        submitButton = (Button) findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letterInput = (EditText) findViewById(R.id.userInput);
                letterGuessString = letterInput.getText().toString();
                lettersSolved = (TextView) findViewById(R.id.textView2);
                lettersSolved.setText(letterGuessString);

            }


        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
