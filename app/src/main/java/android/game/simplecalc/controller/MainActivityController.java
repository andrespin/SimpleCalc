package android.game.simplecalc.controller;

import android.game.simplecalc.model.CalcFieldCount;
import android.game.simplecalc.model.TextOnCalcField;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import android.game.simplecalc.model.Counter;

public class MainActivityController implements MainController {

    List<Button> buttons;
    TextView calcField;
    private String calcText;
    private TextOnCalcField textOnCalcField = new TextOnCalcField();
    private Counter counter = new CalcFieldCount();

    public void setTextOnCalcField(TextOnCalcField textOnCalcField) {
        this.textOnCalcField = textOnCalcField;
    }

    public TextOnCalcField getTextOnCalcField() {
        return textOnCalcField;
    }


    public void calcActionAC(TextView calcField) {
        calcField.setText("");
        textOnCalcField.setTextOnCalcField("");
        System.out.println("After press" + textOnCalcField.getTextOnCalcField());
    }

    public void calcActionClear(TextView calcField) {
        calcText = deleteTheLastChar(calcField.getText().toString());
        calcField.setText(calcText);
        textOnCalcField.setTextOnCalcField(calcText);
        System.out.println("After press" + textOnCalcField.getTextOnCalcField());
    }

    public void calcActionPercent(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + " % ");
        textOnCalcField.setTextOnCalcField(calcText + " % ");
    }

    public void calcActionShare(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + " / ");
        textOnCalcField.setTextOnCalcField(calcText + " / ");
    }

    public void calcActionMultiply(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + " * ");
        textOnCalcField.setTextOnCalcField(calcText + " * ");
    }

    public void calcActionPlus(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + " + ");
        textOnCalcField.setTextOnCalcField(calcText + " + ");
    }

    public void calcActionMinus(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + " − ");
        textOnCalcField.setTextOnCalcField(calcText + " − ");
    }

    public void calcActionEquals(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(counter.countCalcField(calcText));
    }

    public void calcActionPoint(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + ".");
        textOnCalcField.setTextOnCalcField(calcText + ".");
    }

    public void calcActionButton1(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "1");
        textOnCalcField.setTextOnCalcField(calcText + "1");
    }

    public void calcActionButton2(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "2");
        textOnCalcField.setTextOnCalcField(calcText + "2");
    }

    public void calcActionButton3(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "3");
        textOnCalcField.setTextOnCalcField(calcText + "3");
    }

    public void calcActionButton4(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "4");
        textOnCalcField.setTextOnCalcField(calcText + "4");
    }

    public void calcActionButton5(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "5");
        textOnCalcField.setTextOnCalcField(calcText + "5");
    }

    public void calcActionButton6(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "6");
        textOnCalcField.setTextOnCalcField(calcText + "6");
    }

    public void calcActionButton7(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "7");
        textOnCalcField.setTextOnCalcField(calcText + "7");
    }

    public void calcActionButton8(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "8");
        textOnCalcField.setTextOnCalcField(calcText + "8");
    }

    public void calcActionButton9(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "9");
        textOnCalcField.setTextOnCalcField(calcText + "9");
    }

    public void calcActionButton0(TextView calcField) {
        calcText = calcField.getText().toString();
        calcField.setText(calcText + "0");
        textOnCalcField.setTextOnCalcField(calcText + "0");
    }


    private String deleteTheLastChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
