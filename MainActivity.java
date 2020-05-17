package sg.edu.np.week2_whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonMiddle;
    private Button buttonRight;
    private TextView Score;
    int scoreNum = 0;
    private static final String TAG = "Whack-A-Mole";
    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLeft = (Button) findViewById(R.id.Button1);
        buttonMiddle = (Button) findViewById(R.id.Button2);
        buttonRight = (Button) findViewById(R.id.Button3);

        Score = (TextView) findViewById(R.id.Score);
        Score.setText("0");

        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Score.setText("0");
        Log.v(TAG, "Starting GUI!");
        buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Left Clicked");
                if (buttonLeft.getText().toString().equals("*")){
                    Log.v(TAG, "Hit, score added!");
                    scoreNum += 1;
                }
                else{
                    Log.v(TAG, "Missed, score deducted!");
                    scoreNum -= 1;
                }
                setNewMole();
                Score.setText(String.valueOf(scoreNum));
            }
        });
        buttonMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Middle Clicked");
                if (buttonMiddle.getText().toString().equals("*")){
                    Log.v(TAG, "Hit, score added!");
                    scoreNum += 1;
                }
                else{
                    Log.v(TAG, "Missed, score deducted!");
                    scoreNum -= 1;
                }
                setNewMole();
                Score.setText(String.valueOf(scoreNum));
            }
        });
        buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Button Right Clicked");
                if (buttonRight.getText().toString().equals("*")){
                    Log.v(TAG, "Hit, score added!");
                    scoreNum += 1;
                }
                else{
                    Log.v(TAG, "Missed, score deducted!");
                    scoreNum -= 1;
                }
                setNewMole();
                Score.setText(String.valueOf(scoreNum));
            }
        });
    }
    public void setNewMole()
    {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        if (randomLocation == 0){
            buttonLeft.setText("*");
            buttonRight.setText("o");
            buttonMiddle.setText("o");
        }
        else if(randomLocation == 1){
            buttonMiddle.setText("*");
            buttonRight.setText("o");
            buttonLeft.setText("o");
        }
        else if(randomLocation == 2){
            buttonRight.setText("*");
            buttonMiddle.setText("o");
            buttonLeft.setText("o");
        }
    }

}

