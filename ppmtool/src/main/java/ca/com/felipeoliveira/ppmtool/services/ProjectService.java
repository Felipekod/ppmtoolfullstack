package ca.com.felipeoliveira.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.com.felipeoliveira.ppmtool.domain.Project;
import ca.com.felipeoliveira.ppmtool.exceptions.ProjectIdException;
import ca.com.felipeoliveira.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		
		//Logic
		
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);
		}
		catch(Exception ex) {
			throw new ProjectIdException("Project ID " + project.getProjectIdentifier().toUpperCase() + " already exists");
		}
	}
	
	public Project findProjectByIdentify(String projectId) {
		
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) {
			throw new ProjectIdException("Project ID"+ projectId +" does not exists");
		}
		
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		
		if(project == null) 
			throw new ProjectIdException("Cannot Project with ID " + projectId + ". This project does not exists.");
	
		projectRepository.delete(project);
	}

}
 