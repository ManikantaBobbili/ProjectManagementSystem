package com.ProjectM.ProjectManagementSystem.ServiceLayer;

import com.ProjectM.ProjectManagementSystem.Model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project createProject(Project project);
    Project updateProject(Project project) throws Exception;
    List<Project> getAllProject();
    Optional<Project> getProjectById(long id);
    void deleteProductById(long id);
}
