package com.example.tp3.web;

import com.example.tp3.entities.Patient;
import com.example.tp3.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository patientRepository;


    @GetMapping
    public String listPatients(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "3") int size) {
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(page, size));
        model.addAttribute("patients", patients);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", patients.getTotalPages());
        return "patients";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/add")
    public String savePatient(@ModelAttribute Patient patient) {
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
            model.addAttribute("patient", patient.get());
            return "edit-patient";
        }
        return "redirect:/patients";
    }

    @PostMapping("/update/{id}")
    public String updatePatient(@PathVariable Long id, @ModelAttribute Patient patient) {
        patient.setId(id);
        patientRepository.save(patient);
        return "redirect:/patients";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
        return "redirect:/patients";
    }
}
