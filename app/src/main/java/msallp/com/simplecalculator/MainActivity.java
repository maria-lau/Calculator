package mlau.com.arithmeticcalculator;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    public double currentval = 0.0;
    EditText editText;
    TextView infoTextView;
    Button buttonClear, buttonBackspace, buttonZero, buttonOne, buttonTwo, buttonThree,
            buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine,
            buttonDecimal, buttonAdd, buttonSubtract, buttonMultiply, buttonDivide,
            buttonEqual, buttonNegative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView = (TextView) findViewById(R.id.infoTextView);
        editText = (EditText) findViewById(R.id.editText);
        editText.setGravity(Gravity.RIGHT);
        editText.setText("0");

        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentval = 0.0;
                editText.setText("0");
                infoTextView.setText("");
            }
        });

        buttonBackspace = (Button) findViewById(R.id.buttonBackspace);
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (infoTextView.getText().length() <= 1) infoTextView.setText("");
                else if ((infoTextView.getText().charAt(0)) == 'a' &&
                        (infoTextView.getText().length() <= 9)) infoTextView.setText("");
                else
                    infoTextView.setText(infoTextView.getText().subSequence(0, infoTextView.length() - 1));

            }
        });

        buttonZero = (Button) findViewById(R.id.buttonZero);
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "0");
            }
        });

        buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "1");
            }
        });

        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "2");
            }
        });

        buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "3");
            }
        });

        buttonFour = (Button) findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "4");
            }
        });

        buttonFive = (Button) findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "5");
            }
        });

        buttonSix = (Button) findViewById(R.id.buttonSix);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "6");
            }
        });

        buttonSeven = (Button) findViewById(R.id.buttonSeven);
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "7");
            }
        });

        buttonEight = (Button) findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "8");
            }
        });

        buttonNine = (Button) findViewById(R.id.buttonNine);
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoTextView.setText(infoTextView.getText() + "9");
            }
        });

        buttonDecimal = (Button) findViewById(R.id.buttonDecimal);
        buttonDecimal.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonNegative = (Button) findViewById(R.id.buttonNegative);
        buttonNegative.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
