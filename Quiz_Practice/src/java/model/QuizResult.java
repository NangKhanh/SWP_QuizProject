/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class QuizResult {

    private int id_result;
    private int id_user;
    private int id_quiz;
    private float score_quiz;
    private Date date_taken;

    public QuizResult() {
    }

    public int getIdResult() {
        return id_result;
    }

    public QuizResult(int id_result, int id_user, int id_quiz) {
        this.id_result = id_result;
        this.id_user = id_user;
        this.id_quiz = id_quiz;
    }

    public QuizResult(int id_result, int id_user, int id_quiz, Date date_taken) {
        this.id_result = id_result;
        this.id_user = id_user;
        this.id_quiz = id_quiz;
        this.date_taken = date_taken;
    }

    public QuizResult(int id_result, int id_user, int id_quiz, float score_quiz) {
        this.id_result = id_result;
        this.id_user = id_user;
        this.id_quiz = id_quiz;
        this.score_quiz = score_quiz;
    }

    public float getScore_quiz() {
        return score_quiz;
    }

    public void setScore_quiz(float score_quiz) {
        this.score_quiz = score_quiz;
    }

    public int getId_result() {
        return id_result;
    }

    public void setId_result(int id_result) {
        this.id_result = id_result;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public Date getDate_taken() {
        return date_taken;
    }

    public void setDate_taken(Date date_taken) {
        this.date_taken = date_taken;
    }
}
