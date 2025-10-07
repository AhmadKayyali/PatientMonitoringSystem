package edu.rmit.vitalsignsservice;

public class VitalSign {
    
    private  int idVitalSign;
    private int patientId;
    private String timestamp;
    private int heartRate; // Beats per minute
    private int bloodPressureSystolic; // e.g., "80"
    private int bloodPressureDiastolic; // e.g., "100"
    private double temperature; // Body temperature in °C 

    public int getIdVitalSign() {
        return idVitalSign;
    }

    public void setIdVitalSign(int idVitalSign) {
        this.idVitalSign = idVitalSign;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(int bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public int getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(int bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    @Override
    public String toString() {
        return "VitalSign {" +
            "idVitalSign=" + idVitalSign +
            ", patientId=" + patientId +
            ", timestamp=" + timestamp +
            ", heartRate=" + heartRate + " bpm" +
            ", bloodPressure=" + bloodPressureSystolic + "/" + bloodPressureDiastolic + " mmHg" +
            ", temperature=" + temperature + " °C" +
            '}';
}
}
