package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Enterprise {
	
	private String name;
	
	private List<Project> projects = new ArrayList<>();

	public Enterprise() {
	}	

	public Enterprise(String name) throws DomainException {
		changeName(name);
	}	

	public String getName() {
		return name;
	}

	public void changeName(String name) throws DomainException {
		if (name == null || name.trim().isEmpty()) {
			throw new DomainException(
					"Enterprise name is empty");
		}		
		this.name = name.trim();
	}	

	public List<Project> getProjects() {
		return new ArrayList<>(projects);
	}
	
	public void addProject(Project project) throws DomainException {
		if (project == null) {
			throw new DomainException(
					"Project is null");
		}
		if (searchProject(project.getId()) != null) {
	        throw new DomainException(
	                "Project ID already registered!");
	    }
		projects.add(project);
	}
	
	public void removeProject(Integer id) throws DomainException {
		if (id == null || id <= 0) {
			throw new DomainException(
					"Invalid Project");
		}
		Project project = searchProject(id);
		if (project == null) {
			throw new DomainException(
					"Project is not found");
		}
		projects.remove(project);
	}
	
	public Project searchProject(Integer id) {
		return projects
				.stream()
					.filter(
							projects -> projects.getId().equals(id))
					.findFirst()
					.orElse(null);
	}	
}
