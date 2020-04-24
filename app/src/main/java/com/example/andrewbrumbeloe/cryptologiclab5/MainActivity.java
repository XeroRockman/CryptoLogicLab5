package com.example.andrewbrumbeloe.cryptologiclab5;

import android.os.Build;
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
    private String correctGuessString;
    private String word;
    private TextView youWinTextView;
    private TextView incorrectGuessCounterTextView;
    private TextView correctGuessTextView;
    private int incorrectGuessCounter;
    private int correctGuessCounter;
    
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

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

        //List of words to scramble
        ArrayList<String> words = new ArrayList<>(Arrays.asList("CHOCOLATE", "CABLE", "COMPUTER", "PYTHON", "WATER", "GREEN", "ORANGE", "BLUE", "YELLOW"));
        int randIndex = (int) (Math.random() * words.size());  // this line picks a random number that will correspond to the array list

        word = words.get(randIndex); //Set our word equal to one of the words selected randomly
        correctGuessString = "";
        incorrectGuessCounter = 0;
        correctGuessCounter = 0;

        ArrayList<String> wordlist = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(wordlist);


        //String shuffledword = String.join(", ", wordlist);
        //I decided to use this for loop below instead of using the code on the line above
        //IDE was telling me this didnt meet API requirements that i set when i created the project
        String shuffledword = "";
        for(String s: wordlist) { shuffledword += s; }

        TextView shuffledwordView = (TextView) findViewById(R.id.wordToGuess);
        shuffledwordView.setText(shuffledword);

        //Connecting our TextViews to the correct IDs from content_main.xml and initializing their text
        correctGuessTextView = (TextView) findViewById(R.id.correctGuessTextView);
        incorrectGuessCounterTextView = (TextView) findViewById(R.id.incorrectGuessCounter);
        youWinTextView = (TextView) findViewById(R.id.congratulationsDisplay);
        incorrectGuessCounterTextView.setText("Incorrect Guesses: 0");
        correctGuessTextView.setText("");
        youWinTextView.setText("");

        //

        //Guess Letter Button - - - Guess Letter Button - - - Guess Letter Button - - - Guess Letter Button
        Button guessLetterButton = (Button) findViewById(R.id.button);
        guessLetterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //convert all user input to uppercase
                EditText userInput = (EditText) findViewById(R.id.userInput);
                String userInputString = userInput.getText().toString();
                userInputString = userInputString.toUpperCase();
                //
                //if input is less than our word then keep taking in letters
                if ((correctGuessCounter + 1) < word.length() + 1) {
                    String guessedLetter = word.substring(correctGuessCounter, correctGuessCounter+1);
                    if (userInputString.equals(guessedLetter)) {
                        //if input is correct, then add input to correct answer
                        correctGuessCounter++;
                        correctGuessString = correctGuessString + userInputString;
                        correctGuessTextView.setText(correctGuessString);
                    }else {
                        //if input is not correct, then add 1 to incorrect guesses
                        incorrectGuessCounter++;
                        incorrectGuessCounterTextView.setText("Incorrect Guesses: " + incorrectGuessCounter);
                    }
                }
                //
                if(correctGuessString.equals(word)) {
                    youWinTextView.setText("Congratulations, you have won!!!");
                }
                userInput.setText(""); //reset the text field and make it blank again
            }
        });
        //Guess Letter Button - - - Guess Letter Button - - - Guess Letter Button - - - Guess Letter Button

        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -



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
