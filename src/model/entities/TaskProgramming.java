package model.entities;


public class TaskProgramming extends Task {
	
	private String technologyUsed;
	
	public TaskProgramming() {
		super();
	}	
	
	public TaskProgramming(Integer id, String description, Integer estimatedHours, 
			String technologyUsed) throws DomainException {
		super(id, description, estimatedHours);
		changeTechnologyUsed(technologyUsed);
	}

	public String getTechnologyUsed() {
		return technologyUsed;
	}

	public void changeTechnologyUsed(String technologyUsed) throws DomainException {
		if (technologyUsed == null || technologyUsed.trim().isEmpty()) {
			throw new DomainException(
					"Invalid tecnologyUsed");
		}		
		this.technologyUsed = technologyUsed.trim();
	}

	@Override
	public String getAdditionalInfo() {
		return technologyUsed;
	}

	@Override
	public String toString() {
		return String.format(
				"Id: %d%n"
				+ "Description: %s%n"
				+ "Type: ProgrammingTask%n"
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
