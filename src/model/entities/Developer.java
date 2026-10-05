package model.entities;

public class Developer {
	
	private Integer id;
	private String name;
	private Double hourlyRate;
	
	public Developer() {
	}

	public Developer(Integer id, String name, Double hourlyRate) throws DomainException {
		changeId(id);
		changeName(name);
		changeHourlyRate(hourlyRate);
	}

	public Integer getId() {
		return id;
	}

	public void changeId(Integer id) throws DomainException {
		if (id == null || id <= 0) {
			throw new DomainException(
					"Invalid developer ID");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void changeName(String name) throws DomainException {
		if (name == null || name.trim().isEmpty()) {
			throw new DomainException(
					"Developer name is empty");
		}		
		this.name = name.trim();
	}

	public Double getHourlyRate() {
		return hourlyRate;
	}

	public void changeHourlyRate(Double hourlyRate) throws DomainException {
		if (hourlyRate == null) {
			throw new DomainException(
					"Hourly rate of developer is null");
		}
		if (hourlyRate <= 0.0) {
			throw new DomainException(
					"Hourly rate of developer must be greater than zero");
		}		
		this.hourlyRate = hourlyRate;
	}	
	
}
