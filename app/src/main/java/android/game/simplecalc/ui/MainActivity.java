package android.game.simplecalc.ui;

import android.app.Activity;
import android.content.Intent;
import android.game.simplecalc.controller.MainActivityController;
import android.game.simplecalc.R;
import android.game.simplecalc.model.TextOnCalcField;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.game.simplecalc.controller.MainController;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

public class MainActivity extends BaseActivity implements View.OnClickListener {


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

    ImageView imageView;
    ImageView imageSettings;

    TextView calcField;


    protected static final int themeSimpleCalc = 0;
    protected static final int themeSimpleCalcNight = 1;

    private boolean isInMain;


    private List<Button> buttons;

    MainController mainController;
    int orientation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initProcess();
        isInMain = true;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        System.out.println("Work1");
        if (isInMain) {
            mainController.setTextOnCalcField(calcField.getText().toString());
            instanceState.putSerializable(KEY_TextOnCalcField, mainController);
        }
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        System.out.println("Work2");
        if (isInMain) {
            mainController = (MainController) instanceState.getSerializable(KEY_TextOnCalcField);
            calcField.setText(mainController.getTextOnCalcField());
        }
    }

    private void initProcess() {
        mainController = new MainActivityController();
        init();
        addbuttonsToList();
        setButtonsListener();
        initSettingsImageButton();
        setTextFromIntent();
    }

    private void setTextFromIntent() {
        try {
            mainController.setTextOnCalcField((String) getIntent().getSerializableExtra(KEY_TextOnCalcField));
            calcField.setText(mainController.getTextOnCalcField());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
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
        imageView = findViewById(R.id.imageView);
    }


    private void setButtonsListener() {
        for (Button btn : buttons) {
            btn.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAC:
                mainController.calcActionAC(calcField);
                break;
            case R.id.buttonClear:
                mainController.calcActionClear(calcField);
                break;
            case R.id.buttonPercent:
                mainController.calcActionPercent(calcField);
                break;
            case R.id.buttonShare:
                mainController.calcActionShare(calcField);
                break;
            case R.id.buttonMultiply:
                mainController.calcActionMultiply(calcField);
                break;
            case R.id.buttonMinus:
                mainController.calcActionMinus(calcField);
                break;
            case R.id.buttonPlus:
                mainController.calcActionPlus(calcField);
                break;
            case R.id.buttonEquals:
                mainController.calcActionEquals(calcField);
                break;
            case R.id.buttonPoint:
                mainController.calcActionPoint(calcField);
                break;
            case R.id.button1:
                mainController.calcActionButton1(calcField);
                break;
            case R.id.button2:
                mainController.calcActionButton2(calcField);
                break;
            case R.id.button3:
                mainController.calcActionButton3(calcField);
                break;
            case R.id.button4:
                mainController.calcActionButton4(calcField);
                break;
            case R.id.button5:
                mainController.calcActionButton5(calcField);
                break;
            case R.id.button6:
                mainController.calcActionButton6(calcField);
                break;
            case R.id.button7:
                mainController.calcActionButton7(calcField);
                break;
            case R.id.button8:
                mainController.calcActionButton8(calcField);
                break;
            case R.id.button9:
                mainController.calcActionButton9(calcField);
                break;
            case R.id.button0:
                mainController.calcActionButton0(calcField);
                break;
        }
    }

    private void initSettingsImageButton() {
        imageSettings = findViewById(R.id.imageSettings);
        imageSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isInMain = false;
                mainController.setTextOnCalcField(calcField.getText().toString());
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                intent.putExtra(KEY_TextOnCalcField, mainController.getTextOnCalcField());
                startActivity(intent);
            }
        });

    }

}