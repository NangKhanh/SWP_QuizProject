/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Set;

/**
 *
 * @author Admin
 */
public class QuizQuestion {
    int id_question;
    int id_quiz;
    String content_question;
    int questionOrderNumber;
    boolean markedStatus;
    Set<Integer> listAnswer;
    
    public QuizQuestion() {
    }

    public QuizQuestion(int id_question, int id_quiz, String content_question) {
        this.id_question = id_question;
        this.id_quiz = id_quiz;
        this.content_question = content_question;
    }

    public QuizQuestion(String content_question) {
        this.content_question = content_question;
    }
    

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public String getContent_question() {
        return content_question;
    }

    public void setContent_question(String content_question) {
        this.content_question = content_question;
    }

    public int getQuestionOrderNumber() {
        return questionOrderNumber;
    }

    public void setQuestionOrderNumber(int questionOrderNumber) {
        this.questionOrderNumber = questionOrderNumber;
    }

    public boolean isMarkedStatus() {
        return markedStatus;
    }

    public void setMarkedStatus(boolean markedStatus) {
        this.markedStatus = markedStatus;
    }

    public Set<Integer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(Set<Integer> listAnswer) {
        this.listAnswer = listAnswer;
    }
}
