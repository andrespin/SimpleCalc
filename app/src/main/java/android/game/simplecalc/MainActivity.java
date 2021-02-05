package android.game.simplecalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{


    private final static String KEY_TextOnCalcField = "key_MainActivityController";

    Button buttonAC;
    Button buttonPlusMinus;
    Button buttonPercent;
    Button buttonshare;
    Button buttonMultiply;
    Button buttonMinus;
    Button buttonPlus;
    Button buttonEquals;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonPoint;

    TextView calcField;



    private MainActivityController mainActivityController;
    private TextOnCalcField textOnCalcFieldInActivity = new TextOnCalcField();

    private List<Button> buttons;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProcess();
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        textOnCalcFieldInActivity.setTextOnCalcField(mainActivityController.getTextOnCalcField().getTextOnCalcField());
        System.out.println(textOnCalcFieldInActivity.getTextOnCalcField());
        System.out.println("Work");
        Log.d("Before :" , textOnCalcFieldInActivity.getTextOnCalcField());
        instanceState.putSerializable(KEY_TextOnCalcField, textOnCalcFieldInActivity);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        textOnCalcFieldInActivity = (TextOnCalcField) instanceState.getSerializable(KEY_TextOnCalcField);
      //  mainActivityController.returnDataAfterScreenReverse();
        System.out.println(textOnCalcFieldInActivity.getTextOnCalcField());
        System.out.println("Work");
        Log.d("After :" , textOnCalcFieldInActivity.getTextOnCalcField());
        if (textOnCalcFieldInActivity.getTextOnCalcField() != null){
            calcField.setText(textOnCalcFieldInActivity.getTextOnCalcField());
        }

    }

    private void initProcess() {
        init();
        mainActivityController = new MainActivityController(addbuttonsToList(), calcField);
    }

    private List<Button> addbuttonsToList() {
        buttons = new ArrayList<>();

        buttons.add(buttonAC);
        buttons.add(buttonPlusMinus);
        buttons.add(buttonPercent);
        buttons.add(buttonshare);
        buttons.add(buttonMultiply);
        buttons.add(buttonMinus);
        buttons.add(buttonPlus);
        buttons.add(buttonEquals);
        buttons.add(buttonPoint);

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button0);
        return buttons;
    }

    private void init() {
        calcField = findViewById(R.id.calcField);
        buttonAC = findViewById(R.id.buttonAC);
        buttonPlusMinus = findViewById(R.id.buttonClear);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonshare = findViewById(R.id.buttonShare);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonPoint = findViewById(R.id.buttonPoint);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button0 = findViewById(R.id.button0);
    }
}