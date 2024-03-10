package com.ProjectM.ProjectManagementSystem.RepositoryLayer;

import com.ProjectM.ProjectManagementSystem.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Long> {

}
