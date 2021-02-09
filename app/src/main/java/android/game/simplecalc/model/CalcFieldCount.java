package android.game.simplecalc.model;

public class CalcFieldCount implements Counter {

    private String counted;
    private String s;

    public String countCalcField(String str) {
        String[] strMas = str.split(" ");

        for (int i = 0; i < strMas.length; i++) {
            if (strMas[i].equals("*") || strMas[i].equals("/")) {
                counted = (count(strMas[i - 1], strMas[i + 1], strMas[i]));
                s = strMas[i - 1] + " " + strMas[i] + " " + strMas[i + 1];
                str = str.replace(s, counted);
            }
        }
        while (str.split(" ").length != 1) {
            strMas = str.split(" ");
            for (int i = 0; i < strMas.length; i++) {
                if (strMas[i].equals("+") || strMas[i].equals("−")) {
                    counted = (count(strMas[i - 1], strMas[i + 1], strMas[i]));
                    s = strMas[i - 1] + " " + strMas[i] + " " + strMas[i + 1];
                    str = str.replace(s, counted);
                }
            }
        }
        return str;
    }

    private String count(String first, String second, String signBetween) {
        String result = "";
        if (signBetween.equals("+")) {
            Double f = Double.valueOf(first);
            Double s = Double.valueOf(second);
            Double sum = (double) f + s;
            result = sum.toString();
        }
        if (signBetween.equals("−")) {
            Double f = Double.valueOf(first);
            Double s = Double.valueOf(second);
            Double dif = (double) f - s;
            result = dif.toString();
        }
        if (signBetween.equals("*")) {
            Double f = Double.valueOf(first);
            Double s = Double.valueOf(second);
            Double summary = (double) f * s;
            result = summary.toString();
        }
        if (signBetween.equals("/")) {
            Double f = Double.valueOf(first);
            Double s = Double.valueOf(second);
            Double quotient = (double) f / s;
            result = quotient.toString();
        }
        if (signBetween.equals("%")) {
            Double f = Double.valueOf(first);
            Double s = Double.valueOf(second);
            Double remainder = (double) f % s;
            result = remainder.toString();
        }
        return result;
    }
}

