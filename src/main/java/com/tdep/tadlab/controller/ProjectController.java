package com.tdep.tadlab.controller;


//TODO: Change cross origins

import com.tdep.tadlab.entity.projectDb.Link;
import com.tdep.tadlab.entity.projectDb.Project;
import com.tdep.tadlab.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "PostmanRuntime/7.37.0", "https://tdep-tadlab-client-3831fae30b93.herokuapp.com", "https://www.trevordepew.com"})
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private ProjectWriteService projectWriteService;

    @Autowired
    private ProjectReadService projectReadService;


//    Project

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return projectReadService.findAllProjects();
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") int id) {
        return projectReadService.findProjectById(id);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return projectWriteService.createNewProject(project);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") int id, @RequestBody Project project) {
        return projectWriteService.updateExistingProject(id, project);
    }

    @PutMapping("/projects/add_link/{id}")
    public ResponseEntity<Project> addLinkToProject(@PathVariable("id") int id, @RequestBody Link link) {
        return projectWriteService.addLinkToProject(id, link);
    }

    @PatchMapping("/projects/remove_link/{project_id}")
    public ResponseEntity<Project> removeLinkFromProject(@PathVariable("project_id") int projectId, @RequestBody Link link) {
        return projectWriteService.removeLinkFromProject(projectId, link);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable("id") int id) {
        return projectWriteService.deleteProjectById(id);
    }

    @DeleteMapping("/projects")
    public ResponseEntity<HttpStatus> deleteAllProjects() {
        return projectWriteService.deleteAllProjects();
    }


//    Links

    @GetMapping("/projects/links")
    public ResponseEntity<List<Link>> getAllLinks() { return projectReadService.findAllLinks(); }

    @GetMapping("/projects/links/{link_id}")
    public ResponseEntity<Link> getLinkById(@PathVariable("link_id") int linkId) {
        return projectReadService.findLinkById(linkId);
    }

}
