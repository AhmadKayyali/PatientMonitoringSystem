package edu.rmit.vitalsignsservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;


@RestController
@RequestMapping ("/vital-sign")
public class VitalSignController {
    VitalSignServiceLayer vitalSignServiceLayer;

    public VitalSignController () {
        vitalSignServiceLayer = new VitalSignServiceLayer();
    }

    // Delete the vital sign record of a patient
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> deleteVitalSign(@PathVariable int id) {
        boolean deleted = vitalSignServiceLayer.deleteVitalSignByPatientId(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/patients")
    public List<VitalSign> getAllPatientVitals() {
        return vitalSignServiceLayer.getAllVitalSigns();
    }

    // Create a new vital sign record for a patient
    @PostMapping("/patients/{id}")
    public ResponseEntity<VitalSign> createVitalSign(
            @PathVariable int id,
            @RequestBody VitalSign vitalSign) {
        vitalSign.setPatientId(id);
        VitalSign created = vitalSignServiceLayer.addVitalSign(vitalSign);
        return ResponseEntity.ok(created);
    }
}