/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Quiz {
    int id_quiz;
    int id_lesson;
    String name_quiz;
    String description_quiz;
    int time;
    int question_number;
    
    public Quiz() {
    }

    public Quiz(int id_quiz, int id_lesson, String name_quiz, String description_quiz, int time, int question_number) {
        this.id_quiz = id_quiz;
        this.id_lesson = id_lesson;
        this.name_quiz = name_quiz;
        this.description_quiz = description_quiz;
        this.time = time;
        this.question_number = question_number;
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public int getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(int id_lesson) {
        this.id_lesson = id_lesson;
    }

    public String getName_quiz() {
        return name_quiz;
    }

    public void setName_quiz(String name_quiz) {
        this.name_quiz = name_quiz;
    }

    public String getDescription_quiz() {
        return description_quiz;
    }

    public void setDescription_quiz(String description_quiz) {
        this.description_quiz = description_quiz;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getQuestion_number() {
        return question_number;
    }

    public void setQuestion_number(int question_number) {
        this.question_number = question_number;
    }
    
}
