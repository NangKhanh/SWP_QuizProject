/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sonha
 */
public class QuizResultInformation {
    private QuizResult quizResult;
    private List<QuizAnswer> quizAnswers;
    private Lesson lesson;
    private Quiz quiz;
    private List<QuizQuestion> quizQuestion; 
    private List<QuizResultAnswer> quizResultAnswers;
    private Subject subject;

    public QuizResultInformation() {
    }

    public QuizResultInformation(QuizResult quizResult, List<QuizAnswer> quizAnswers, Quiz quiz, List<QuizResultAnswer> quizResultAnswers, Subject subject) {
        this.quizResult = quizResult;
        this.quizAnswers = quizAnswers;
        this.quiz = quiz;
        this.quizResultAnswers = quizResultAnswers;
        this.subject = subject;
    }

    public QuizResultInformation(QuizResult quizResult, List<QuizAnswer> quizAnswers, Lesson lesson, Quiz quiz, List<QuizQuestion> quizQuestion, List<QuizResultAnswer> quizResultAnswers, Subject subject) {
        this.quizResult = quizResult;
        this.quizAnswers = quizAnswers;
        this.lesson = lesson;
        this.quiz = quiz;
        this.quizQuestion = quizQuestion;
        this.quizResultAnswers = quizResultAnswers;
        this.subject = subject;
    }
   
    public QuizResultInformation(QuizResult quizResult, List<QuizAnswer> quizAnswers, Lesson lesson, Quiz quiz, List<QuizResultAnswer> quizResultAnswers, Subject subject) {
        this.quizResult = quizResult;
        this.quizAnswers = quizAnswers;
        this.lesson = lesson;
        this.quiz = quiz;
        this.quizResultAnswers = quizResultAnswers;
        this.subject = subject;
    }
    
    public QuizResult getQuizResult() {
        return quizResult;
    }

    public void setQuizResult(QuizResult quizResult) {
        this.quizResult = quizResult;
    }

    public List<QuizAnswer> getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(List<QuizAnswer> quizAnswers) {
        this.quizAnswers = quizAnswers;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<QuizResultAnswer> getQuizResultAnswers() {
        return quizResultAnswers;
    }

    public void setQuizResultAnswers(List<QuizResultAnswer> quizResultAnswers) {
        this.quizResultAnswers = quizResultAnswers;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public List<QuizQuestion> getQuizQuestion() {
        return quizQuestion;
    }

    public void setQuizQuestion(List<QuizQuestion> quizQuestion) {
        this.quizQuestion = quizQuestion;
    }
    
    public double getCorrectPercentage() {
        double correct = getCorrectAnswer();
        double allQuestion = getQuizQuestion().size();
        return (correct/allQuestion) * 100;
    }
    
    public int getCorrectAnswer() {
        int count = 0;
        List<QuizAnswer> listRightAnswer = getRightAnswers();
        for (QuizResultAnswer resultAnswer: this.getQuizResultAnswers()) {
            for (QuizAnswer q: listRightAnswer) {
                if (q.getId_answer() == resultAnswer.getId_answer()) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
    private List<QuizAnswer> getRightAnswers() {
        List<QuizAnswer> list = new ArrayList<>();
        for (QuizAnswer ans : this.getQuizAnswers() ) {
            if (ans.getStatus()) {
                list.add(ans);
            }
        }
        return list;
    }
}
