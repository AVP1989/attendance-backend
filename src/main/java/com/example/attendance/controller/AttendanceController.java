package com.example.attendance.controller;

import com.example.attendance.model.Attendance;
import com.example.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceRepository repository;

    @PostMapping
    public Attendance submit(@RequestBody Attendance att) {
        att.setDate(LocalDate.now());
        att.setTime(LocalTime.now());
        return repository.save(att);
    }

    @GetMapping
    public List<Attendance> getAll() {
        return repository.findAll();
    }
}