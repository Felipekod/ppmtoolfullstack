package ca.com.felipeoliveira.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.com.felipeoliveira.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

	
	Project findByProjectIdentifier(String projectId);

	@Override
	Iterable<Project> findAll();
	
	
	
	
}
