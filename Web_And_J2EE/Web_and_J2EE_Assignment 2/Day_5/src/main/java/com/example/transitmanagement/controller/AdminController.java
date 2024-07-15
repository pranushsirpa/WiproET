package com.example.transitmanagement.controller;

import com.example.transitmanagement.entity.*;
import com.example.transitmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/routes")
    public String getRoutes(Model model) {
        model.addAttribute("route", new Route());
        model.addAttribute("routes", routeRepository.findAll());
        return "routes";
    }

    @PostMapping("/routes")
    public String addRoute(@ModelAttribute Route route) {
        routeRepository.save(route);
        return "redirect:/admin/routes";
    }

    @GetMapping("/schedules")
    public String getSchedules(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("schedules", scheduleRepository.findAll());
        model.addAttribute("routes", routeRepository.findAll());
        return "schedules";
    }

    @PostMapping("/schedules")
    public String addSchedule(@ModelAttribute Schedule schedule) {
        scheduleRepository.save(schedule);
        return "redirect:/admin/schedules";
    }

    @GetMapping("/incidents")
    public String getIncidents(Model model) {
        model.addAttribute("incident", new Incident());
        model.addAttribute("incidents", incidentRepository.findAll());
        return "incidents";
    }

    @PostMapping("/incidents")
    public String addIncident(@ModelAttribute Incident incident) {
        incident.setReportedAt(LocalDateTime.now());
        incidentRepository.save(incident);
        return "redirect:/admin/incidents";
    }

    @GetMapping("/feedback")
    public String getFeedback(Model model) {
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("feedbacks", feedbackRepository.findAll());
        return "feedback";
    }

    @PostMapping("/feedback")
    public String addFeedback(@ModelAttribute Feedback feedback) {
        feedback.setSubmittedAt(LocalDateTime.now());
        feedbackRepository.save(feedback);
        return "redirect:/admin/feedback";
    }
}
