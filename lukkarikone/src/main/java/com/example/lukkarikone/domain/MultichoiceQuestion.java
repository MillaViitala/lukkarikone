package com.example.lukkarikone.domain;

import java.util.Map;

public class MultichoiceQuestion extends Question {

    Map<Integer, String> choicesList;

    public MultichoiceQuestion(String qTitle, Map<Integer, String> choicesList) {
        super(qTitle);
        this.choicesList = choicesList;
    }

    public void addChoice(final String choice) {
        choicesList.put(choicesList.size(), choice);
    }

    public void removeChoiceById(final int choiceId) {
        choicesList.remove(choiceId);
    }
    
    public void removeChoiceByTitle(String choice) {
        choicesList.values().removeIf(value -> value.equals(choice));
    }

}
