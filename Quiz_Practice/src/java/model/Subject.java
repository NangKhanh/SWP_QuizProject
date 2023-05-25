/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author sonha
 */
public class Subject {
    int id_subject;
    int id_user;
    String name_subject;
    String description_subject;
    String icon;
    int id_subcate;
    int grade;

    public Subject() {
    }

    public Subject(int id_subject, int id_user, String name_subject, String description_subject, String icon, int id_subcate) {
        this.id_subject = id_subject;
        this.id_user = id_user;
        this.name_subject = name_subject;
        this.description_subject = description_subject;
        this.icon = icon;
        this.id_subcate = id_subcate;
    }

    public Subject(int id_subject, int id_user, String name_subject, String description_subject, String icon, int id_subcate, int grade) {
        this.id_subject = id_subject;
        this.id_user = id_user;
        this.name_subject = name_subject;
        this.description_subject = description_subject;
        this.icon = icon;
        this.id_subcate = id_subcate;
        this.grade = grade;
    }
    

    public int getId_subject() {
        return id_subject;
    }

    public void setId_subject(int id_subject) {
        this.id_subject = id_subject;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public String getDescription_subject() {
        return description_subject;
    }

    public void setDescription_subject(String description_subject) {
        this.description_subject = description_subject;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId_subcate() {
        return id_subcate;
    }

    public void setId_subcate(int id_subcate) {
        this.id_subcate = id_subcate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
        final Subject other = (Subject) obj;
        if (this.id_subject != other.id_subject) {
            return false;
        }
        if (this.id_user != other.id_user) {
            return false;
        }
        if (this.id_subcate != other.id_subcate) {
            return false;
        }
        if (!Objects.equals(this.name_subject, other.name_subject)) {
            return false;
        }
        if (!Objects.equals(this.description_subject, other.description_subject)) {
            return false;
        }
        return Objects.equals(this.icon, other.icon);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id_subject;
        hash = 89 * hash + this.id_user;
        hash = 89 * hash + Objects.hashCode(this.name_subject);
        hash = 89 * hash + Objects.hashCode(this.description_subject);
        hash = 89 * hash + Objects.hashCode(this.icon);
        hash = 89 * hash + this.id_subcate;
        return hash;
    }
}