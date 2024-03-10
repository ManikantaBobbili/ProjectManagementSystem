package com.ProjectM.ProjectManagementSystem.ControllerLayer;

import com.ProjectM.ProjectManagementSystem.ServiceLayer.ProjectService;
import com.ProjectM.ProjectManagementSystem.Model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class Controller {

    @Autowired
    ProjectService projectService;

    // Endpoint to get All Projects in DataBase H2
    @GetMapping("/")
    public ResponseEntity<List<Project>> getAllProject(){
        return ResponseEntity.ok().body(projectService.getAllProject());
    }

    // Endpoint to Get Project with id
    @GetMapping("/id={id}/")
    public ResponseEntity<Optional<Project>> getProjectById(@PathVariable long id){
        return ResponseEntity.ok().body(projectService.getProjectById(id));
    }

    // Endpoint to Create project
    @PostMapping("/create/")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        return ResponseEntity.ok().body(projectService.createProject(project));
    }

    // Endpoint to Update Project
    @PutMapping("/update/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable long id , @RequestBody Project project) throws Exception {
        project.setId(id);
        return ResponseEntity.ok().body(this.projectService.updateProject(project));
    }

    @DeleteMapping("/delete/{id}")
    public String DeleteProjectById(@PathVariable long id) {
        this.projectService.deleteProductById(id);
        return "Deleted";

    }
}
