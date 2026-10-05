package model.entities;

import model.entities.enums.TaskStatus;

public abstract class Task {

	private Integer id;
	private String description;
	private Integer estimatedHours;
	private TaskStatus currentStatus;

	public Task() {
	}

	public Task(Integer id, String description, Integer estimatedHours) throws DomainException {
		changeId(id);
		changeDescription(description);
		changeEstimatedHours(estimatedHours);
		this.currentStatus = TaskStatus.PENDING;
	}

	public Integer getId() {
		return id;
	}

	public void changeId(Integer id) throws DomainException {
		if (id == null || id <= 0) {
			throw new DomainException("Invalid task ID");
		}
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void changeDescription(String description) throws DomainException {
		if (description == null || description.trim().isEmpty()) {
			throw new DomainException("Task description is empty");
		}
		this.description = description.trim();
	}

	public Integer getEstimatedHours() {
		return estimatedHours;
	}

	public void changeEstimatedHours(Integer estimatedHours) throws DomainException {
		if (estimatedHours == null) {
			throw new DomainException("Estimated hours is null.");
		}
		if (estimatedHours <= 0) {
			throw new DomainException("The estimated number of hours task must be greater than zero.");
		}
		this.estimatedHours = estimatedHours;
	}

	public TaskStatus getCurrentStatus() {
		return currentStatus;
	}

	public void changeCurrentStatus(TaskStatus newStatus) throws DomainException {
		if (newStatus == null) {
			throw new DomainException(
					"current status of task is null");
		}
		if (this.currentStatus == TaskStatus.PENDING && newStatus != TaskStatus.IN_PROGRESS) {
			throw new DomainException(
					"Error: Invalid task status transition!");
		} else if (this.currentStatus == TaskStatus.IN_PROGRESS && newStatus != TaskStatus.COMPLETED) {
			throw new DomainException(
					"Error: Invalid task status transition!");
		} else if (this.currentStatus == TaskStatus.COMPLETED && newStatus != TaskStatus.COMPLETED) {
			throw new DomainException(
					"Error: Invalid task status transition!");
		} else if (this.currentStatus == TaskStatus.COMPLETED && newStatus == TaskStatus.COMPLETED) {
			throw new DomainException(
					"Error: Completed task cannot change status!");
		}		
		this.currentStatus = newStatus;
	}			

	public abstract String getAdditionalInfo();

}
