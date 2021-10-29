/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author ADMIN
 */
public class PantientDTO {

    String patientID;
    String patientName;
    String age;
    String gender;
    String occupation;
    String workplace;
    String phone;
    String address;
    String healthInsuranceNumber;
    String symptom;

    public PantientDTO() {
    }

    public PantientDTO(String patientID, String patientName, String age, String gender, String occupation, String workplace, String phone, String address, String healthInsuranceNumber, String symptom) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.workplace = workplace;
        this.phone = phone;
        this.address = address;
        this.healthInsuranceNumber = healthInsuranceNumber;
        this.symptom = symptom;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(String healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

          
    
    
}
