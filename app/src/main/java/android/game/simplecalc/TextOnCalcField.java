package android.game.simplecalc;

import java.io.Serializable;

public class TextOnCalcField implements Serializable {

    private String textOnCalcField = "";

    public String getTextOnCalcField() {
        return textOnCalcField;
    }

    public void setTextOnCalcField(String textOnCalcField) {
        this.textOnCalcField = textOnCalcField;
    }
}
