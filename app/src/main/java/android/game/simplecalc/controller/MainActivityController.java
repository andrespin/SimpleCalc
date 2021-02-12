package android.game.simplecalc.controller;

import android.game.simplecalc.model.CalcFieldCount;
import android.game.simplecalc.model.TextOnCalcField;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import android.game.simplecalc.model.Counter;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

public class MainActivityController implements MainController {


    private String calcText;
    private TextOnCalcField textOnCalcField = new TextOnCalcField();
    private Counter counter = new CalcFieldCount();

    public void setTextOnCalcField(String text) {
        textOnCalcField.setTextOnCalcField(text);
    }

    public String getTextOnCalcField() {
        return textOnCalcField.getTextOnCalcField();
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
        putInCalcField(calcField, " % ");
    }

    public void calcActionShare(TextView calcField) {
        putInCalcField(calcField, " / ");
    }

    public void calcActionMultiply(TextView calcField) {
        putInCalcField(calcField, " * ");
    }

    public void calcActionPlus(TextView calcField) {
        putInCalcField(calcField, " + ");
    }

    public void calcActionMinus(TextView calcField) {
        putInCalcField(calcField, " − ");
    }

    public void calcActionEquals(TextView calcField) {
        count(calcField);
    }


    public void calcActionPoint(TextView calcField) {
        putInCalcField(calcField, ".");
    }

    public void calcActionButton1(TextView calcField) {
        putInCalcField(calcField, "1");
    }

    public void calcActionButton2(TextView calcField) {
        putInCalcField(calcField, "2");
    }

    public void calcActionButton3(TextView calcField) {
        putInCalcField(calcField, "3");
    }

    public void calcActionButton4(TextView calcField) {
        putInCalcField(calcField, "4");
    }

    public void calcActionButton5(TextView calcField) {
        putInCalcField(calcField, "5");
    }

    public void calcActionButton6(TextView calcField) {
        putInCalcField(calcField, "6");
    }

    public void calcActionButton7(TextView calcField) {
        putInCalcField(calcField, "7");
    }

    public void calcActionButton8(TextView calcField) {
        putInCalcField(calcField, "8");
    }

    public void calcActionButton9(TextView calcField) {
        putInCalcField(calcField, "9");
    }

    public void calcActionButton0(TextView calcField) {
        putInCalcField(calcField, "0");
    }

    private void putInCalcField(TextView calcField, String toPut) {
        calcText = calcField.getText().toString();
        if (calcText.toCharArray().length < 8) {
            calcField.setTextSize(COMPLEX_UNIT_SP, 90);
            calcField.setText(calcText + toPut);
            textOnCalcField.setTextOnCalcField(calcText + "0");
        } else if (calcText.toCharArray().length < 32) {
            calcField.setTextSize(COMPLEX_UNIT_SP, 45);
            calcField.setText(calcText + toPut);
            textOnCalcField.setTextOnCalcField(calcText + "0");
        }
    }


    private String deleteTheLastChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    private void count(TextView calcField) {
        try {
            calcText = calcField.getText().toString();
            String res = counter.countCalcField(calcText);
            if (res.equals("Ошибка в алгоритме")) {
                calcField.setTextSize(COMPLEX_UNIT_SP, 45);
                calcField.setText(res);
            }
            calcField.setText(counter.countCalcField(calcText));
        } catch (Exception e) {
            e.printStackTrace();
            calcField.setTextSize(COMPLEX_UNIT_SP, 45);
            calcField.setText("Ошибка");
        }
    }
}
