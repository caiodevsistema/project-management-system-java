package model.entities;

public class TaskTesting extends Task {

	private String testType;
	
	public TaskTesting() {
		super();
	}	
	
	public TaskTesting(Integer id, String description, Integer estimatedHours, 
			String testType) throws DomainException {
		super(id, description, estimatedHours);
		changeTestType(testType);
	}	

	public void changeTestType(String testType) throws DomainException {
		if (testType == null || testType.trim().isEmpty()) {
			throw new DomainException(
					"Invalid testt type");
		}
		this.testType = testType.trim();
	}

	@Override
	public String getAdditionalInfo() {
		return testType;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Id: %d%n"
				+ "Description: %s%n"
				+ "Type: TestingTask%n"
				+ "Additional Information: %s%n"
				+ "Estimated hours: %d%n"
				+ "Status: %s",
				getId(),
				getDescription(),
				getAdditionalInfo(),
				getEstimatedHours(),
				getCurrentStatus());
	}
}
