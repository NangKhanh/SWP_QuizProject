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
public class User {

    private String nameUser;
    private String idUser;
    private String phone;
    private String email;
    private String password;
    private String address;
    private int roleId;
    private Date birthDate;
    private boolean gender;
    private int status;

    public User() {
    }

    public User(String nameUser, String idUser, String phone, String email, String password, String address, int roleId, boolean gender) {
        this.nameUser = nameUser;
        this.idUser = idUser;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.roleId = roleId;
        this.gender = gender;
    }

    public User(String nameUser, String idUser, String phone, String email, String password, String address, int roleId, Date birthDate, boolean gender) {
        this.nameUser = nameUser;
        this.idUser = idUser;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.roleId = roleId;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public User(String nameUser, Date birthDate, String phone, String email, String address, String password, boolean gender,int status) {
        this.nameUser = nameUser;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;
        this.status = status;
    }

    public User(String nameUser, String idUser, String phone, String email, String password, String address, Date birthDate, boolean gender) {
        this.nameUser = nameUser;
        this.idUser = idUser;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public User(String nameUser, String idUser, String phone, String address, Date birthDate) {
        this.nameUser = nameUser;
        this.idUser = idUser;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
    }

    public User(String nameUser, String idUser, String phone, String email, String address, int roleId, Date birthDate, boolean gender, int status) {
        this.nameUser = nameUser;
        this.idUser = idUser;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.roleId = roleId;
        this.birthDate = birthDate;
        this.gender = gender;
        this.status = status;
    }

    public User(String nameUser, String idUser, String phone, String email, String password, String address, int roleId, Date birthDate, boolean gender, int status) {
        this.nameUser = nameUser;
        this.idUser = idUser;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.roleId = roleId;
        this.birthDate = birthDate;
        this.gender = gender;
        this.status = status;
    }

    public User(String idUser, int status) {
        this.idUser = idUser;
        this.status = status;
    }

    public User(String idUser) {
        this.idUser = idUser;
    }
    



    public User(String nameUser, String idUser) {
        this.nameUser = nameUser;
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
