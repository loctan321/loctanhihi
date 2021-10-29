/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;


/**
 *
 * @author ADMIN
 */
public class RegistrationDTO implements Serializable, Comparable<RegistrationDTO> {

    String registrationID, fullName, occupation, phone, idCardNumber, healthInsuranceNumber, address, workplace, objectGroup;
    int age;

    boolean gender, permanentResidence, consentToVaccination;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String registrationID, String fullName, String occupation, String phone, String idCardNumber, String healthInsuranceNumber, String address, String workplace, String objectGroup, int age, boolean gender, boolean permanentResidence, boolean consentToVaccination) {
        this.registrationID = registrationID;
        this.fullName = fullName;
        this.occupation = occupation;
        this.phone = phone;
        this.idCardNumber = idCardNumber;
        this.healthInsuranceNumber = healthInsuranceNumber;
        this.address = address;
        this.workplace = workplace;
        this.objectGroup = objectGroup;
        this.age = age;
        this.gender = gender;
        this.permanentResidence = permanentResidence;
        this.consentToVaccination = consentToVaccination;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getHealthInsuranceNumber() {
        return healthInsuranceNumber;
    }

    public void setHealthInsuranceNumber(String healthInsuranceNumber) {
        this.healthInsuranceNumber = healthInsuranceNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getObjectGroup() {
        return objectGroup;
    }

    public void setObjectGroup(String objectGroup) {
        this.objectGroup = objectGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isPermanentResidence() {
        return permanentResidence;
    }

    public void setPermanentResidence(boolean permanentResidence) {
        this.permanentResidence = permanentResidence;
    }

    public boolean isConsentToVaccination() {
        return consentToVaccination;
    }

    public void setConsentToVaccination(boolean consentToVaccination) {
        this.consentToVaccination = consentToVaccination;
    }

    

    

    @Override
    public int compareTo(RegistrationDTO o) {
        return o.getFullName().compareTo(this.getFullName());
    }

}
