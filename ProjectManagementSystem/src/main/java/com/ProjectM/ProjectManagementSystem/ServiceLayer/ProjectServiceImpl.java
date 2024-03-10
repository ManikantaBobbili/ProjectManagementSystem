package com.ProjectM.ProjectManagementSystem.ServiceLayer;

import com.ProjectM.ProjectManagementSystem.RepositoryLayer.ProjectRepo;
import com.ProjectM.ProjectManagementSystem.Model.Project;
import com.ProjectM.ProjectManagementSystem.Exception.Exception;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional

public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepo projectRepo;
    @Override
    public Project createProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Project updateProject(Project project){
        Optional<Project> projectDetails = this.projectRepo.findById(project.getId());
        if(projectDetails.isPresent()){
            Project projectData = projectDetails.get();
            projectData.setId(project.getId());
            projectData.setName(project.getName());
            projectData.setDescription(project.getDescription());
            projectData.setStartDate(project.getStartDate());
            projectData.setEndDate(project.getEndDate());
            projectRepo.save(projectData);
            return projectData;
        }
        else{
        throw new Exception("Project not found");}
    }

    @Override
    public List<Project> getAllProject() {
        return projectRepo.findAll();
    }

    @Override
    public Optional<Project> getProjectById(long id) {
        return projectRepo.findById(id);
    }

    @Override
    public void deleteProductById(long id) {
        Optional<Project> projectDetails = this.projectRepo.findById(id);
        if(projectDetails.isPresent())
            this.projectRepo.deleteById(id);
        else {
            throw new Exception("Project not found");
        }

    }
}
