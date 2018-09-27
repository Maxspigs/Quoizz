package com.quoizz.max.quoizz;


public class Question {

    int id;
    String question;
    boolean reponse;

    public Question(int id, String question, boolean reponse) {
        this.id = id;
        this.question = question;
        this.reponse = reponse;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isReponse() {
        return reponse;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }



}
