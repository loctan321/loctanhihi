/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.RegistrationDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileDAO {

    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;
    private BufferedWriter bw;
    private static final String DELIMETER = ";";

    private void closeFileStream() {
        try {
            if (br != null) {
                br.close();
            }
            if (bw != null) {
                bw.close();
            }
            if (fr != null) {
                fr.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (Exception e) {
            System.err.println("Error while close file stream at: " + FileDAO.class.getName());
        }
    }

    private String fileName;

    public FileDAO(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<RegistrationDTO> getContent() {
        ArrayList<RegistrationDTO> list = null;
        RegistrationDTO dto = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line;
            list = new ArrayList();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMETER);
                String registrationID = data[0];
                String fullName = data[1];
                int age = Integer.parseInt(data[2]);
                boolean gender = data[3].equals("male") ? true : (data[3].equals("female") ? false : false);
                String occupation = data[4];
                String phone = data[5];
                String idCardNumber = data[6];
                String healthInsuranceNumber = data[7];
                String address = data[8];
                String workplace = data[9];
                boolean permanentResidence = data[10].equals("yes") ? true : (data[10].equals("no") ? false : false);
                String objectGroup = data[11];
                boolean consentToVaccination = data[12].equals("agree") ? true : (data[12].equals("disagree") ? false : false);
                if (dto == null) {
                    dto = new RegistrationDTO();
                }
                if (data.length == 13) {
                    dto = new RegistrationDTO(registrationID, fullName,occupation, phone, idCardNumber, healthInsuranceNumber, address, workplace, objectGroup, age, gender, permanentResidence, consentToVaccination);

                    list.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeFileStream();
        }
        return list;
    }

    public boolean putContent(ArrayList<RegistrationDTO> list) {
        try {
            fw = new FileWriter(fileName, false);
            bw = new BufferedWriter(fw);
            for (RegistrationDTO dto : list) {
                String data = new StringBuilder(dto.getRegistrationID()).append(";")
                        .append(dto.getFullName()).append(";")
                        .append(dto.getAge()).append(";")
                        .append(dto.isGender() ? "male" : "female").append(";")
                        .append(dto.getOccupation()).append(";")
                        .append(dto.getPhone()).append(";")
                        .append(dto.getIdCardNumber()).append(";")
                        .append(dto.getHealthInsuranceNumber()).append(";")
                        .append(dto.getAddress()).append(";")
                        .append(dto.getWorkplace()).append(";")
                        .append(dto.isPermanentResidence() ? "yes" : "no").append(";")
                        .append(dto.getObjectGroup()).append(";")
                        .append(dto.isConsentToVaccination() ? "agree" : "disagree").toString();
                bw.write(data);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeFileStream();
        }
        return true;
    }

}
