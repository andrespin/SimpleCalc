package android.game.simplecalc;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

class MainActivityController implements View.OnClickListener,
        Serializable {

    List<Button> buttons;
    TextView calcField;
    private String calcText;
    private TextOnCalcField textOnCalcField = new TextOnCalcField();

    public void setTextOnCalcField(TextOnCalcField textOnCalcField) {
        this.textOnCalcField = textOnCalcField;
    }

    public TextOnCalcField getTextOnCalcField() {
        return textOnCalcField;
    }

    public MainActivityController(List<Button> buttons, TextView calcField) {
        this.buttons = buttons;
        this.calcField = calcField;
        if (buttons != null) {
            setButtonsListener();
        }
    }

    public void returnDataAfterScreenReverse() {
        calcField.setText(textOnCalcField.getTextOnCalcField());
    }

    public String getCalcText() {
        return calcText;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAC:
                calcField.setText("");
                textOnCalcField.setTextOnCalcField("");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.buttonClear:
                calcText = deleteTheLastChar(calcField.getText().toString());
                calcField.setText(calcText);
                textOnCalcField.setTextOnCalcField(calcText);
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.buttonPercent:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + " % ");
                textOnCalcField.setTextOnCalcField(calcText + " % ");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.buttonShare:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + " / ");
                textOnCalcField.setTextOnCalcField(calcText + " / ");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.buttonMultiply:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + " * ");
                textOnCalcField.setTextOnCalcField(calcText + " * ");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.buttonMinus:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + " − ");
                textOnCalcField.setTextOnCalcField(calcText + " − ");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.buttonPlus:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + " + ");
                textOnCalcField.setTextOnCalcField(calcText + " + ");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.buttonEquals:
                calcText = calcField.getText().toString();
                calcField.setText(count(calcText));
                break;
            case R.id.buttonPoint:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + ".");
                textOnCalcField.setTextOnCalcField(calcText + ".");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button1:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "1");
                textOnCalcField.setTextOnCalcField(calcText + "1");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button2:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "2");
                textOnCalcField.setTextOnCalcField(calcText + "2");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button3:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "3");
                textOnCalcField.setTextOnCalcField(calcText + "3");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button4:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "4");
                textOnCalcField.setTextOnCalcField(calcText + "4");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button5:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "5");
                textOnCalcField.setTextOnCalcField(calcText + "5");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button6:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "6");
                textOnCalcField.setTextOnCalcField(calcText + "6");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button7:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "7");
                textOnCalcField.setTextOnCalcField(calcText + "7");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button8:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "8");
                textOnCalcField.setTextOnCalcField(calcText + "8");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button9:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "9");
                textOnCalcField.setTextOnCalcField(calcText + "9");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
            case R.id.button0:
                calcText = calcField.getText().toString();
                calcField.setText(calcText + "0");
                textOnCalcField.setTextOnCalcField(calcText + "0");
                System.out.println("After press" + textOnCalcField.getTextOnCalcField());
                break;
        }
    }

    private void setButtonsListener() {
        for (Button btn : buttons) {
            btn.setOnClickListener(this);
        }
    }

    private String deleteTheLastChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    private String count(String str) {
        Character[] characters = toCharacter(str);

        String first = getFirstNumber(characters);
        String second = getSecondNumber(characters);
        String signBetween = getSignBetween(characters);

        String result = countFrmCalcField(first, second, signBetween);
        if (result != null)
            return result;
        else
            return "Ошибка";
    }


    private String countFrmCalcField(String first, String second, String signBetween) {
        String result = null;
        if (signBetween.equals("+")) {
            int f = Integer.valueOf(first);
            int s = Integer.valueOf(second);
            Double sum = (double) f + s;
            result = sum.toString();
        }
        if (signBetween.equals("−")) {
            int f = Integer.valueOf(first);
            int s = Integer.valueOf(second);
            Double dif = (double) f - s;
            result = dif.toString();
        }
        if (signBetween.equals("*")) {
            int f = Integer.valueOf(first);
            int s = Integer.valueOf(second);
            Double summary = (double) f * s;
            result = summary.toString();
        }
        if (signBetween.equals("/")) {
            int f = Integer.valueOf(first);
            int s = Integer.valueOf(second);
            Double quotient = (double) f / s;
            result = quotient.toString();
        }
        if (signBetween.equals("%")) {
            int f = Integer.valueOf(first);
            int s = Integer.valueOf(second);
            Double remainder = (double) f % s;
            result = remainder.toString();
        }

        return result;
    }

    private static Character[] toCharacter(String s) {
        Character[] characters = new Character[s.length()];
        for (int j = 0; j < s.length(); j++) {
            characters[j] = s.charAt(j);
        }
        return characters;
    }

    private static String getSignBetween(Character[] characters) {
        String s = "";
        for (Character c : characters) {
            if (c.equals('+')) {
                s = c.toString();
            }
            if (c.equals('−')) {
                s = c.toString();
            }
            if (c.equals('/')) {
                s = c.toString();
            }
            if (c.equals('*')) {
                s = c.toString();
            }
            if (c.equals('%')) {
                s = c.toString();
            }
        }
        return s;
    }

    
    private static String getSecondNumber(Character[] characters) {
        int count = 0;
        boolean isStartedToAppend = false;
        StringBuilder secondNumber = new StringBuilder();
        for (Character c : characters) {
            if (isStartedToAppend) {
                secondNumber.append(c.toString());
            }
            if (c.equals(' ')) {
                count++;
                if (count > 1) {
                    isStartedToAppend = true;
                }
            }
        }
        return secondNumber.toString().replaceAll("\\s+", "");
    }

    private static String getFirstNumber(Character[] characters) {
        StringBuilder calcText = new StringBuilder();
        for (Character c : characters) {
            calcText.append(c.toString());
            if (c.equals(' ')) {
                return calcText.toString().replaceAll("\\s+", "");
            }
        }
        return "";
    }
}
