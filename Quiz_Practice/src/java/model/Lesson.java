/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Lesson {
    int id_lesson;
    int id_subject;
    String name_lesson;
    String description_lesson;
    String video_lesson;
    int id_user;
    
     public Lesson() {
    }

    public Lesson(int id_lesson, int id_subject, String name_lesson, String description_lesson) {
        this.id_lesson = id_lesson;
        this.id_subject = id_subject;
        this.name_lesson = name_lesson;
        this.description_lesson = description_lesson;
    }

    public Lesson(int id_lesson, int id_subject, String name_lesson, String description_lesson, String video_lesson) {
        this.id_lesson = id_lesson;
        this.id_subject = id_subject;
        this.name_lesson = name_lesson;
        this.description_lesson = description_lesson;
        this.video_lesson = video_lesson;
    }

    public Lesson(int id_lesson, int id_subject, String name_lesson, String description_lesson, String video_lesson, int id_user) {
        this.id_lesson = id_lesson;
        this.id_subject = id_subject;
        this.name_lesson = name_lesson;
        this.description_lesson = description_lesson;
        this.video_lesson = video_lesson;
        this.id_user = id_user;
    }
    

    
    public int getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(int id_lesson) {
        this.id_lesson = id_lesson;
    }

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public String getName_lesson() {
        return name_lesson;
    }

    public void setName_lesson(String name_lesson) {
        this.name_lesson = name_lesson;
    }

    public String getDescription_lesson() {
        return description_lesson;
    }

    public void setDescription_lesson(String description_lesson) {
        this.description_lesson = description_lesson;
    }

    public String getVideo_lesson() {
        return video_lesson;
    }

    public void setVideo_lesson(String video_lesson) {
        this.video_lesson = video_lesson;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    

}
