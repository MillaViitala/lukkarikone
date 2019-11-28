package com.example.lukkarikone.domain;

import java.util.List;

public class MultichoiceQuestion extends Question {

    List<String> choicesList;

    public MultichoiceQuestion(String qTitle, List<String> choicesList) {
        super(qTitle);
        this.choicesList = choicesList;
    }

    public void addChoice(final String choice) {
        choicesList.add(choice);
    }

    public void removeChoiceById(final int choiceId) {
        choicesList.remove(choiceId);
    }
    
    public void removeChoiceByTitle(String choice) {
        choicesList.removeIf(value -> value.equals(choice));
    }

}
