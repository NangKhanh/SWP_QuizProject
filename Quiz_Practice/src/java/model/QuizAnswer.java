/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Admin
 */
public class QuizAnswer {
    int id_answer;
    int id_question;
    String content_answer;
    boolean status;
    String explaination;
    
    boolean isChoose;
    
    
    public QuizAnswer() {
    }

    public QuizAnswer(int id_answer, int id_question, String content_answer, boolean status) {
        this.id_answer = id_answer;
        this.id_question = id_question;
        this.content_answer = content_answer;
        this.status = status;
    }

    public QuizAnswer(int id_answer, int id_question, String content_answer, boolean status, String explaination, boolean isChoose) {
        this.id_answer = id_answer;
        this.id_question = id_question;
        this.content_answer = content_answer;
        this.status = status;
        this.explaination = explaination;
        this.isChoose = isChoose;
    }

    public QuizAnswer(int id_answer, int id_question, String content_answer, boolean status, String explaination) {
        this.id_answer = id_answer;
        this.id_question = id_question;
        this.content_answer = content_answer;
        this.status = status;
        this.explaination = explaination;
    }

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public String getContent_answer() {
        return content_answer;
    }

    public void setContent_answer(String content_answer) {
        this.content_answer = content_answer;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isIsChoose() {
        return isChoose;
    }

    public void setIsChoose(boolean isChoose) {
        this.isChoose = isChoose;
    }

    public boolean isStatus() {
        return status;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final QuizAnswer other = (QuizAnswer) obj;
        if (this.id_answer != other.id_answer) {
            return false;
        }
        if (this.id_question != other.id_question) {
            return false;
        }
        if (this.isChoose != other.isChoose) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        return Objects.equals(this.content_answer, other.content_answer);
    }
}
