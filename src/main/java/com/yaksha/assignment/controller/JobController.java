package com.yaksha.assignment.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.yaksha.assignment.models.Job;

@Controller
public class JobController {

	private List<Job> jobs = Arrays.asList(new Job(1, "Software Engineer", "IT", 60000),
			new Job(2, "Data Analyst", "Analytics", 50000), new Job(3, "HR Manager", "HR", 45000),
			new Job(4, "Marketing Specialist", "Marketing", 40000));

	// Display all jobs
	@GetMapping("/jobs")
	public String getAllJobs(Model model) {
		model.addAttribute("jobs", jobs);
		return "jobs";
	}

	// Fetch a job by ID using PathVariable
	@GetMapping("/jobs/{id}")
	public String getJobById(@PathVariable int id, Model model) {
		Job job = jobs.stream().filter(j -> j.getId() == id).findFirst().orElse(null);
		model.addAttribute("job", job);
		return "job-details";
	}

	// Filter jobs using request parameters (e.g., /jobs/search?department=IT)
	@GetMapping("/jobs/search")
	public String searchJobs(@RequestParam(required = false) String department, Model model) {
		List<Job> filteredJobs = jobs;

		if (department != null) {
			filteredJobs = jobs.stream().filter(j -> j.getDepartment().equalsIgnoreCase(department))
					.collect(Collectors.toList());
		}

		model.addAttribute("jobs", filteredJobs);
		return "jobs";
	}
}
