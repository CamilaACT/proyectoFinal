package Clases;

import java.util.HashMap;
import java.util.Map;

public class ArbolDecision {
    private String question;
    private Map<String, ArbolDecision> options;
    private int PrecioY,PrecioN;

    public ArbolDecision(String question, int PrecioY, int PrecioN) {
        this.question = question;
        this.options = new HashMap<>();
        this.PrecioN=PrecioN;
        this.PrecioY=PrecioY;
    }

    public int getPrecioY() {
        return PrecioY;
    }

    public int getPrecioN() {
        return PrecioN;
    }

    public String getQuestion() {
        return question;
    }

    public void addOption(String option, ArbolDecision nextArbolDecision) {
        options.put(option, nextArbolDecision);

    }

    public ArbolDecision getNextNode(String option) {
        return options.get(option);
    }

}
