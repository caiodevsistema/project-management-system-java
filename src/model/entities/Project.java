package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Project {
	
	private Integer id;
	private String name;	
	private Developer developer;
	private List<Task> tasks = new ArrayList<>();
	
	public Project() {
	}

	public Project(Integer id, String name, Developer developer) throws DomainException {
		changeId(id);
		changeName(name);
		changeDeveloper(developer);
	}

	public Integer getId() {
		return id;
	}

	public void changeId(Integer id) throws DomainException {
		if (id == null || id <= 0) {
			throw new DomainException(
					"Invalid project ID"); 
		}
		this.id = id;
	}

	public String getName() {		
		return name;
	}

	public void changeName(String name) throws DomainException {
		if (name == null || name.trim().isEmpty()) {
			throw new DomainException(
					"Project name is empty");
		}		
		this.name = name.trim();
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void changeDeveloper(Developer developer) throws DomainException {
		if (developer == null) {
			throw new DomainException(
					"Developer is null"); 
		}
		this.developer = developer;
	}

	public List<Task> getTasks() {
		return new ArrayList<>(tasks);
	}
	
	public void addTask(Task task) throws DomainException {		
		if (task == null) {
			throw new DomainException (
					"Task is null");
		}		
		if (isRegisteredId(task.getId())) {
			throw new DomainException(
					"ID already registered!");
		}		
		tasks.add(task);
	}
	
	private boolean isRegisteredId(Integer id) {
		for (Task task : tasks) {
			if (task.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}	
	
	public Task searchForTaskById(Integer id) {
		return tasks.stream()
				.filter(task -> task.getId().equals(id))
				.findFirst()
				.orElse(null);
	}	
	
	public void taskRemove(Task task) throws DomainException {
		if (task == null) {
			throw new DomainException(
					"Invalid project ID!");
		}		
		tasks.remove(task);
	}
	
	public Double estimatedCostOfATask(Integer id) throws DomainException {
		Task task = searchForTaskById(id);
		if (task == null) {
			throw new DomainException(
					"Task not found!");
		}
		return task.getEstimatedHours() * developer.getHourlyRate();
	}

	public Double totalCost() {
		double total = 0.0;
		for (Task task : tasks) {
			total += task.getEstimatedHours() * developer.getHourlyRate();
		}
		return total;
	}
	
	public Integer numberOfTasks() {
		return tasks.size();
	}
	
	@Override
	public String toString() {
		return String.format(
				"ID: %d%n"
				+ "Project: %s%n"
				+ "Developer: %s%n"
				+ "Hourly rate: R$ %.2f%n"
				+ "Number of tasks: %d%n"
				+ "Total Estimated Cost: R$ %.2f%n",
				getId(),
				getName(),
				getDeveloper().getName(),
				getDeveloper().getHourlyRate(),
				numberOfTasks(),
				totalCost());				
	}	
}
