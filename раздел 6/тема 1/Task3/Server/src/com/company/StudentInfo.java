package com.company;

import org.w3c.dom.Node;
import java.util.HashMap;

public class StudentInfo {
    private String lastname;
    private String firstname;
    private String patronymic;
    private String faculty;
    private String speciality;
    private String group;
    private String formOfEducation;
    private String basis;
    private String privileges;
    private String maritalStatus;
    private String achievements;
    private HashMap<Integer, String> allParameters = new HashMap<>();
    private HashMap<Integer, String> nameOfParameters = new HashMap<>();

    StudentInfo(){
        this.lastname = "";
        this.firstname = "";
        this.patronymic = "";
        this.faculty = "";
        this.speciality = "";
        this.group = "";
        this.formOfEducation = "";
        this.basis = "";
        this.privileges = "";
        this.maritalStatus = "";
        this.achievements = "";
        initialiseAllParameters();
        initialiseNameOfParametersForXML();
    }

    StudentInfo(Node studentCase) {
        this.lastname = getLastname(studentCase);
        this.firstname = getFirstname(studentCase);
        this.patronymic = getPatronymic(studentCase);
        this.faculty = getFaculty(studentCase);
        this.speciality = getSpeciality(studentCase);
        this.group = getGroup(studentCase);
        this.formOfEducation = getFormOfEducation(studentCase);
        this.basis = getBasis(studentCase);
        this.privileges = getPrivileges(studentCase);
        this.maritalStatus = getMaritalStatus(studentCase);
        this.achievements = getAchievements(studentCase);
        initialiseAllParameters();
        initialiseNameOfParameters();
    }

    public void initialiseAllParameters(){
        allParameters.put(0, lastname);
        allParameters.put(1, firstname);
        allParameters.put(2, patronymic);
        allParameters.put(3, faculty);
        allParameters.put(4, speciality);
        allParameters.put(5, group);
        allParameters.put(6, formOfEducation);
        allParameters.put(7, basis);
        allParameters.put(8, privileges);
        allParameters.put(9, maritalStatus);
        allParameters.put(10, achievements);
    }

    public void initialiseNameOfParameters(){
        nameOfParameters.put(0,"Фамилия: ");
        nameOfParameters.put(1,"Имя: ");
        nameOfParameters.put(2,"Отчество: ");
        nameOfParameters.put(3,"Факультет: ");
        nameOfParameters.put(4,"Специальность: ");
        nameOfParameters.put(5,"Группа: ");
        nameOfParameters.put(6,"Форма обучения: ");
        nameOfParameters.put(7,"Оплата обучения: ");
        nameOfParameters.put(8,"Льготы: ");
        nameOfParameters.put(9,"Семейное положение: ");
        nameOfParameters.put(10,"Достижения: ");
    }

    public void initialiseNameOfParametersForXML(){
        nameOfParameters.put(0,"lastname");
        nameOfParameters.put(1,"firstname");
        nameOfParameters.put(2,"patronymic");
        nameOfParameters.put(3,"faculty");
        nameOfParameters.put(4,"speciality");
        nameOfParameters.put(5,"group");
        nameOfParameters.put(6,"formOfEducation");
        nameOfParameters.put(7,"basis");
        nameOfParameters.put(8,"privileges");
        nameOfParameters.put(9,"maritalStatus");
        nameOfParameters.put(10,"achievements");
    }

    public String getLastname(Node studentCase) {
        return studentCase.getChildNodes().item(1).getChildNodes().item(0).getNodeValue(); //получить фамилию
    }

    public String getFirstname(Node studentCase) {
        return studentCase.getChildNodes().item(3).getChildNodes().item(0).getNodeValue(); //вернуть имя
    }

    public String getPatronymic(Node studentCase) {
        return studentCase.getChildNodes().item(5).getChildNodes().item(0).getNodeValue(); //вернуть отчество
    }

    public String getFaculty(Node studentCase) {
        return studentCase.getChildNodes().item(7).getChildNodes().item(0).getNodeValue(); //вернуть факультет
    }

    public String getSpeciality(Node studentCase) {
        return studentCase.getChildNodes().item(9).getChildNodes().item(0).getNodeValue(); //вернуть специальность
    }

    public String getGroup(Node studentCase) {
        return studentCase.getChildNodes().item(11).getChildNodes().item(0).getNodeValue(); //вернуть группу
    }

    public String getFormOfEducation(Node studentCase) {
        return studentCase.getChildNodes().item(13).getChildNodes().item(0).getNodeValue(); //вернуть форму обучения
    }

    public String getBasis(Node studentCase) {
        return studentCase.getChildNodes().item(15).getChildNodes().item(0).getNodeValue(); //вернуть базу обучения
    }

    public String getPrivileges(Node studentCase) {
        return studentCase.getChildNodes().item(17).getChildNodes().item(0).getNodeValue(); //вернуть льготы
    }

    public String getMaritalStatus(Node studentCase) {
        return studentCase.getChildNodes().item(19).getChildNodes().item(0).getNodeValue(); //вернуть семейное положение
    }

    public String getAchievements(Node studentCase) {
        return studentCase.getChildNodes().item(21).getChildNodes().item(0).getNodeValue(); //вернуть достижения
    }


    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getGroup() {
        return group;
    }

    public String getFormOfEducation() {
        return formOfEducation;
    }

    public String getBasis() {
        return basis;
    }

    public String getPrivileges() {
        return privileges;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getAchievements() {
        return achievements;
    }

    public String messageToListOnClient(){
        return ". " + lastname + " " + firstname + " " + patronymic + ", " + group;
    }

    public int getAllParametersSize(){
        return allParameters.size();
    }

    public String getParameterForMessage(int key){
        return (". " + nameOfParameters.get(key) + allParameters.get(key));
    }

    public String getParameter(int key){
        return allParameters.get(key);
    }

    public String getParameterName(int key){
        return nameOfParameters.get(key);
    }

    public void setParameter(int key, String parameter){
        allParameters.put(key, parameter);
    }

}