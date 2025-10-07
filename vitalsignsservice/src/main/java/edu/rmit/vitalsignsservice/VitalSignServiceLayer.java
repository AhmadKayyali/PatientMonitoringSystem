
package edu.rmit.vitalsignsservice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VitalSignServiceLayer {
    private List <VitalSign> vitalSigns= new ArrayList<>();
    public VitalSignServiceLayer () {
        createDummyRecordVitalSigns();
    }
    //create dummy data for 10 patients
    public final void createDummyRecordVitalSigns () {
        if (vitalSigns.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                VitalSign vitalSign = new VitalSign();
                vitalSign.setIdVitalSign(new Random().nextInt(100,1000));
                vitalSign.setPatientId(new Random().nextInt(1,100));
                LocalDateTime localDateTime = LocalDateTime.now().minusMinutes(new Random().nextInt(500));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
                vitalSign.setTimestamp(localDateTime.format(formatter));
                vitalSign.setHeartRate(new Random().nextInt(30, 220));//min:30 max:220
                vitalSign.setBloodPressureSystolic(new Random().nextInt(70, 250)); //min:70 max:250
                vitalSign.setBloodPressureDiastolic(new Random().nextInt(40,150));  //min:40 max:150
                vitalSign.setTemperature(Math.round(new Random().nextDouble(30,45)*10)/10.0);  //min:30 max:34
                vitalSigns.add(vitalSign);
            }
        }
    }

    public List<VitalSign> getAllVitalSigns() {
        return vitalSigns;
    }

    // Add a new vital sign record for a patient
    public VitalSign addVitalSign(VitalSign vitalSign) {
        // Assign a new id if not set
        if (vitalSign.getIdVitalSign() == 0) {
            vitalSign.setIdVitalSign(new Random().nextInt(100, 1000));
        }
        // Set timestamp if not set
        if (vitalSign.getTimestamp() == null || vitalSign.getTimestamp().isEmpty()) {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
            vitalSign.setTimestamp(localDateTime.format(formatter));
        }
        vitalSigns.add(vitalSign);
        return vitalSign;
    }


    // Delete a vital sign record by patientId
    public boolean deleteVitalSignByPatientId(int patientId) {
        return vitalSigns.removeIf(v -> v.getPatientId() == patientId);
    }
}

