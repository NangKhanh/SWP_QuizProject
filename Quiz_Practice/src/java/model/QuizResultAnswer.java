/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author AD
 */
public class QuizResultAnswer {
    private int id_resans ;
    private int id_result;
    private int id_question;
    private int id_answer;

    public QuizResultAnswer() {
    }

    public QuizResultAnswer(int id_resans, int id_result, int id_question, int id_answer) {
        this.id_resans = id_resans;
        this.id_result = id_result;
        this.id_question = id_question;
        this.id_answer = id_answer;
    }

//    public QuizResultAnswer(int id_result, int id_question, int id_answer) {
//        this.id_result = id_result;
//        this.id_question = id_question;
//        this.id_answer = id_answer;
//    }
//
//    public QuizResultAnswer(int id_result, int id_question) {
//        this.id_result = id_result;
//        this.id_question = id_question;
//    }
    
    

    public int getId_resans() {
        return id_resans;
    }

    public void setId_resans(int id_resans) {
        this.id_resans = id_resans;
    }

    public int getId_result() {
        return id_result;
    }

    public void setId_result(int id_result) {
        this.id_result = id_result;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }
    
    
}
