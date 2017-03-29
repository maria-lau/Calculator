package msallp.com.arithmeticcalculator;

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
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = (String) infoTextView.getText();
                if (temp.contains(".")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("A value may not have more than 1 decimal point.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    return;
                } else if (temp.equals("")) infoTextView.setText("0.");
                else if (temp.length() == 9 && temp.charAt(0) == 'a')
                    infoTextView.setText(infoTextView.getText() + "0.");
                else infoTextView.setText(infoTextView.getText() + ".");
            }
        });

        buttonNegative = (Button) findViewById(R.id.buttonNegative);
        buttonNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = (String) infoTextView.getText();
                if (temp == "" || (temp.charAt(0) == 'a') && temp.length() == 9) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Please press the '+/-' button after you have finished typing the numerical value.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                    return;
                } else if (temp.charAt(0) == 'a') {
                    if (temp.charAt(9) != '-') {
                        temp = temp.substring(0, 9) + "-" + temp.substring(9, temp.length());
                        infoTextView.setText(temp);
                    } else if (temp.charAt(9) == '-') {
                        temp = temp.substring(0, 9) + temp.substring(10, temp.length());
                        infoTextView.setText(temp);
                    }
                } else {
                    if (temp.charAt(0) != '-') {
                        temp = "-" + temp;
                        infoTextView.setText(temp);
                    } else if (temp.charAt(0) == '-') {
                        temp = temp.substring(1, temp.length());
                        infoTextView.setText(temp);
                    }
                }
            }
        });

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = (String) infoTextView.getText();
                if (temp == "") {
                } else if (temp.charAt(0) == 'a')
                    temp = temp.substring(7, temp.length());
                else if (temp.charAt(0) == '-') {
                    if (Double.parseDouble(temp) == 0.0) {
                        editText.setText("0");
                        currentval = 0.0;
                        infoTextView.setText("answer + ");
                        return;
                    } else {
                        editText.setText(temp);
                        currentval = Double.parseDouble(temp);
                        infoTextView.setText("answer + ");
                        return;
                    }
                }

                if (temp.equals("+ ") || temp.equals("- ") || temp.equals("* ") || temp.equals("/ ")) {
                    infoTextView.setText("answer + ");
                    return;
                }


                Double newval;
                if (temp == "") {
                } else if (temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '*'
                        || temp.charAt(0) == '/') {
                    newval = Double.parseDouble(temp.substring(2, temp.length()));
                    if (temp.charAt(0) == '+') currentval = currentval + newval;
                    else if (temp.charAt(0) == '-') currentval = currentval - newval;
                    else if (temp.charAt(0) == '*') currentval = currentval * newval;
                    else if (temp.charAt(0) == '/') {
                        if (newval == 0) {
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("No Solution. Cannot divide by 0.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                            return;
                        } else currentval = currentval / newval;
                    }

                    if (Double.toString(currentval).length() > 12) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Error. Number may not equal or exceed 1,000,000,000,000." +
                                "\nPlease start over.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        currentval = 0.0;
                        editText.setText("0");
                        infoTextView.setText("");
                        return;
                    }

                    temp = (String) String.format("%.12f", currentval);
                    temp = temp.substring(0, 12);
                    if (temp.contains(".")) {
                        for (int i = temp.length() - 1; (temp.charAt(i) == '0' || temp.charAt(i) == '.'); i--) {
                            if (temp.charAt(i) == '.') {
                                temp = temp.substring(0, temp.length() - 1);
                                break;
                            } else temp = temp.substring(0, temp.length() - 1);
                        }
                    }
                    editText.setText(temp);
                } else {
                    editText.setText(temp);
                    currentval = Double.parseDouble(temp);
                }
                infoTextView.setText("answer + ");
            }
        });

        buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = (String) infoTextView.getText();
                if (temp == "") {
                } else if (temp.charAt(0) == 'a')
                    temp = temp.substring(7, temp.length());
                else if (temp.charAt(0) == '-') {
                    if (Double.parseDouble(temp) == 0.0) {
                        editText.setText("0");
                        currentval = 0.0;
                        infoTextView.setText("answer - ");
                        return;
                    } else {
                        editText.setText(temp);
                        currentval = Double.parseDouble(temp);
                        infoTextView.setText("answer - ");
                        return;
                    }
                }

                if (temp.equals("+ ") || temp.equals("- ") || temp.equals("* ") || temp.equals("/ ")) {
                    infoTextView.setText("answer - ");
                    return;
                }

                Double newval;
                if (temp == "") {
                } else if (temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '*'
                        || temp.charAt(0) == '/') {
                    newval = Double.parseDouble(temp.substring(2, temp.length()));
                    if (temp.charAt(0) == '+') currentval = currentval + newval;
                    else if (temp.charAt(0) == '-') currentval = currentval - newval;
                    else if (temp.charAt(0) == '*') currentval = currentval * newval;
                    else if (temp.charAt(0) == '/') {
                        if (newval == 0) {
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("No Solution. Cannot divide by 0.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                            return;
                        } else currentval = currentval / newval;
                    }

                    if (Double.toString(currentval).length() > 12) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Error. Number may not equal or exceed 1,000,000,000,000." +
                                "\nPlease start over.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        currentval = 0.0;
                        editText.setText("0");
                        infoTextView.setText("");
                        return;
                    }

                    temp = (String) String.format("%.12f", currentval);
                    temp = temp.substring(0, 12);
                    if (temp.contains(".")) {
                        for (int i = temp.length() - 1; (temp.charAt(i) == '0' || temp.charAt(i) == '.'); i--) {
                            if (temp.charAt(i) == '.') {
                                temp = temp.substring(0, temp.length() - 1);
                                break;
                            } else temp = temp.substring(0, temp.length() - 1);
                        }
                    }
                    editText.setText(temp);
                } else {
                    editText.setText(temp);
                    currentval = Double.parseDouble(temp);
                }
                infoTextView.setText("answer - ");
            }
        });

        buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = (String) infoTextView.getText();
                if (temp == "") {
                } else if (temp.charAt(0) == 'a')
                    temp = temp.substring(7, temp.length());
                else if (temp.charAt(0) == '-') {
                    if (Double.parseDouble(temp) == 0.0) {
                        editText.setText("0");
                        currentval = 0.0;
                        infoTextView.setText("answer * ");
                        return;
                    } else {
                        editText.setText(temp);
                        currentval = Double.parseDouble(temp);
                        infoTextView.setText("answer * ");
                        return;
                    }
                }

                if (temp.equals("+ ") || temp.equals("- ") || temp.equals("* ") || temp.equals("/ ")) {
                    infoTextView.setText("answer * ");
                    return;
                }

                Double newval;
                if (temp == "") {
                } else if (temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '*'
                        || temp.charAt(0) == '/') {
                    newval = Double.parseDouble(temp.substring(2, temp.length()));
                    if (temp.charAt(0) == '+') currentval = currentval + newval;
                    else if (temp.charAt(0) == '-') currentval = currentval - newval;
                    else if (temp.charAt(0) == '*') currentval = currentval * newval;
                    else if (temp.charAt(0) == '/') {
                        if (newval == 0) {
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("No Solution. Cannot divide by 0.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                            return;
                        } else currentval = currentval / newval;
                    }

                    if (Double.toString(currentval).length() > 12) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Error. Number may not equal or exceed 1,000,000,000,000." +
                                "\nPlease start over.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        currentval = 0.0;
                        editText.setText("0");
                        infoTextView.setText("");
                        return;
                    }

                    temp = (String) String.format("%.12f", currentval);
                    temp = temp.substring(0, 12);
                    if (temp.contains(".")) {
                        for (int i = temp.length() - 1; (temp.charAt(i) == '0' || temp.charAt(i) == '.'); i--) {
                            if (temp.charAt(i) == '.') {
                                temp = temp.substring(0, temp.length() - 1);
                                break;
                            } else temp = temp.substring(0, temp.length() - 1);
                        }
                    }
                    editText.setText(temp);
                } else {
                    editText.setText(temp);
                    currentval = Double.parseDouble(temp);
                }
                infoTextView.setText("answer * ");
            }
        });

        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = (String) infoTextView.getText();
                if (temp == "") {
                } else if (temp.charAt(0) == 'a')
                    temp = temp.substring(7, temp.length());
                else if (temp.charAt(0) == '-') {
                    if (Double.parseDouble(temp) == 0.0) {
                        editText.setText("0");
                        currentval = 0.0;
                        infoTextView.setText("answer / ");
                        return;
                    } else {
                        editText.setText(temp);
                        currentval = Double.parseDouble(temp);
                        infoTextView.setText("answer / ");
                        return;
                    }
                }

                if (temp.equals("+ ") || temp.equals("- ") || temp.equals("* ") || temp.equals("/ ")) {
                    infoTextView.setText("answer / ");
                    return;
                }

                Double newval;
                if (temp == "") {
                } else if (temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '*'
                        || temp.charAt(0) == '/') {
                    newval = Double.parseDouble(temp.substring(2, temp.length()));
                    if (temp.charAt(0) == '+') currentval = currentval + newval;
                    else if (temp.charAt(0) == '-') currentval = currentval - newval;
                    else if (temp.charAt(0) == '*') currentval = currentval * newval;
                    else if (temp.charAt(0) == '/') {
                        if (newval == 0) {
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("No Solution. Cannot divide by 0.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                            return;
                        } else currentval = currentval / newval;
                    }

                    if (Double.toString(currentval).length() > 12) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Error. Number may not equal or exceed 1,000,000,000,000." +
                                "\nPlease start over.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        currentval = 0.0;
                        editText.setText("0");
                        infoTextView.setText("");
                        return;
                    }

                    temp = (String) String.format("%.12f", currentval);
                    temp = temp.substring(0, 12);
                    if (temp.contains(".")) {
                        for (int i = temp.length() - 1; (temp.charAt(i) == '0' || temp.charAt(i) == '.'); i--) {
                            if (temp.charAt(i) == '.') {
                                temp = temp.substring(0, temp.length() - 1);
                                break;
                            } else temp = temp.substring(0, temp.length() - 1);
                        }
                    }
                    editText.setText(temp);
                } else

                {
                    editText.setText(temp);
                    currentval = Double.parseDouble(temp);
                }
                infoTextView.setText("answer / ");
            }
        });

        buttonEqual = (Button)

                findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                String temp = (String) infoTextView.getText();
                if (temp == "") {
                } else if (temp.charAt(0) == 'a')
                    temp = temp.substring(7, temp.length());
                else if (temp.charAt(0) == '-') {
                    if (Double.parseDouble(temp) == 0.0) {
                        editText.setText("0");
                        currentval = 0.0;
                        infoTextView.setText("");
                        return;
                    } else {
                        editText.setText(temp);
                        currentval = Double.parseDouble(temp);
                        infoTextView.setText("");
                        return;
                    }
                }

                if (temp.equals("+ ") || temp.equals("- ") || temp.equals("* ") || temp.equals("/ ")) {
                    infoTextView.setText("");
                    return;

                }

                Double newval;
                if (temp == "") {
                } else if (temp.charAt(0) == '+' || temp.charAt(0) == '-' || temp.charAt(0) == '*'
                        || temp.charAt(0) == '/') {
                    newval = Double.parseDouble(temp.substring(2, temp.length()));
                    if (temp.charAt(0) == '+') currentval = currentval + newval;
                    else if (temp.charAt(0) == '-') currentval = currentval - newval;
                    else if (temp.charAt(0) == '*') currentval = currentval * newval;
                    else if (temp.charAt(0) == '/') {
                        if (newval == 0) {
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("No Solution. Cannot divide by 0.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                            return;
                        } else currentval = currentval / newval;
                    }

                    if (Double.toString(currentval).length() > 12 &&
                            (currentval >= 1000000000000.0 || currentval <= -1000000000000.0)) {
                        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Error. Number calculated equals or exceeds ± 1,000,000,000,000." +
                                "\nPlease start over.");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                        currentval = 0.0;
                        editText.setText("0");
                        infoTextView.setText("");
                        return;
                    }

                    temp = (String) String.format("%.12f", currentval);
                    temp = temp.substring(0, 12);
                    if (temp.contains(".")) {
                        for (int i = temp.length() - 1; (temp.charAt(i) == '0' || temp.charAt(i) == '.'); i--) {
                            if (temp.charAt(i) == '.') {
                                temp = temp.substring(0, temp.length() - 1);
                                break;
                            } else temp = temp.substring(0, temp.length() - 1);
                        }
                    }
                    editText.setText(temp);
                } else {
                    editText.setText(temp);
                    currentval = Double.parseDouble(temp);
                }
                infoTextView.setText("");
            }
        });
    }
}
