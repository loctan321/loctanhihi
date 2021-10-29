/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.PantientDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import validation.checkValue;

/**
 *
 * @author ADMIN
 */
public class PatientDAO {

    private final ArrayList<PantientDTO> listPatient = new ArrayList<>();
    checkValue ck = new checkValue();

    public ArrayList<PantientDTO> getPantientDTOs() {
        return listPatient;
    }
    
    public int findID(String id) {
        int pos = -1;
        for (int i = 0; i < listPatient.size(); i++) {
            if (listPatient.get(i).getPatientID().equals(id)) {
                pos = i;
            }
        }
        return pos;
    }
 public int findByName(String name) {
        int pos = -1;
        for (int i = 0; i < listPatient.size(); i++) {
            if (listPatient.get(i).getPatientName().contains(name)) {
                pos = i;
            }
        }
        return pos;
    }
 
 
 
 
}
