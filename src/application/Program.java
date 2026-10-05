package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Developer;
import model.entities.DomainException;
import model.entities.Enterprise;
import model.entities.Project;
import model.entities.Task;
import model.entities.TaskProgramming;
import model.entities.TaskTesting;
import model.entities.enums.TaskStatus;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {			
			while (true) {
				System.out.println("========== PROJECT MANAGEMENT SYSTEM ==========");
				System.out.println();
				Enterprise enterprise = createdEnterprise();
				System.out.println("Enterprise: " + enterprise.getName());
				System.out.println();
				Developer developer = Program.createDeveloper(sc);
				System.out.println();
				Project project = createdProject(sc, developer, enterprise);
				projectSummary(project);
				statusChanges(sc, project);
				projectSummary(project);
				taskRemove(sc, project);
				projectSummary(project);
				finalTaskStatus(project);
				addProjectInEnterprise(enterprise, project);
				enterpriseSummary(enterprise);
				char answer = wishesToReturn(sc);
				if (answer != 'y') {
					System.out.println("Wrapping up...");
					break;
				}
			}
		} catch (DomainException e) {
			System.out.println();
			System.out.println("System data violation error! " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("Null pointer exception error! " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Input Mismatch Exception error!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index Out Of Bounds Exception " + e.getMessage());
		} catch (Exception e) {
			System.out.println();
			System.out.println(e.getMessage());
		}

		sc.close();
	}

	public static Developer createDeveloper(Scanner sc) throws DomainException {
		System.out.println("Enter Developer data:");
		System.out.print("ID: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Hourly Rate: R$ ");
		Double hourlyRate = sc.nextDouble();

		return new Developer(id, name, hourlyRate);
	}

	public static Project createdProject(Scanner sc, Developer developer, Enterprise enterprise)
			throws DomainException {
		Integer id;
		while (true) {
			System.out.println("Enter Project data:");
			System.out.print("ID: ");
			id = sc.nextInt();
			if (enterprise.searchProject(id) != null) {
				System.out.println();
				System.out.println("ID already registered! Try again!");
				System.out.println();
				continue;
			}
			break;
		}
		sc.nextLine();
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.println("Developer: " + developer.getName());

		Project project = new Project(id, name, developer);

		createdTasks(sc, project);

		return project;
	}

	public static void createdTasks(Scanner sc, Project project) throws DomainException {
		System.out.println();
		int n;
		while (true) {
			System.out.print("How many tasks to add? ");
			n = sc.nextInt();
			System.out.println();
			if (n <= 0) {
				System.out.println("Invalid task quantity! Try again!");
				System.out.println();
				continue;
			}
			break;
		}
		Integer id;
		for (int i = 1; i <= n; i++) {
			while (true) {
				System.out.printf("Enter Task #%d:%n", i);
				System.out.print("ID: ");
				id = sc.nextInt();
				if (project.searchForTaskById(id) != null) {
					System.out.println();
					System.out.println("ID already registered!\nEnter another ID!");
					System.out.println();
					continue;
				}
				break;
			}
			sc.nextLine();
			System.out.print("Description: ");
			String description = sc.nextLine();
			char answer = defineTaskType(sc);
			sc.nextLine();
			System.out.print("Additional information: ");
			if (answer == 'p') {
				String technologyUsed = sc.nextLine();
				System.out.print("Estimated hours: ");
				Integer estimatedHours = sc.nextInt();
				project.addTask(new TaskProgramming(id, description, estimatedHours, technologyUsed));
			} else {
				String testType = sc.nextLine();
				System.out.print("Estimated hours: ");
				Integer estimatedHours = sc.nextInt();
				project.addTask(new TaskTesting(id, description, estimatedHours, testType));
			}
			System.out.println();
			System.out.println("Task added successfully!");
			System.out.println();
		}
	}

	public static char defineTaskType(Scanner sc) {
		char answer;
		while (true) {
			System.out.print("Programming task or testing task (p/t)?: ");
			answer = sc.next().toLowerCase().charAt(0);
			if (answer != 'p' && answer != 't') {
				System.out.println("invalid answer! try again!");
				continue;
			}
			break;
		}

		return answer;
	}

	public static void statusChanges(Scanner sc, Project project) throws DomainException {
		while (true) {
			System.out.println("Edit task status");
			System.out.print("Enter the ID task: ");
			Integer id = sc.nextInt();
			sc.nextLine();
			System.out.println();
			Task task = project.searchForTaskById(id);
			if (task != null) {
				System.out.println(task);
				System.out.println();
				while (true) {
					System.out.print("Enter the new Status: ");
					String newStatus = sc.nextLine().trim().toUpperCase();
					try {
						TaskStatus status = TaskStatus.valueOf(newStatus);
						task.changeCurrentStatus(status);
						break;
					} catch (IllegalArgumentException e) {
						System.out.println();
						System.out.println("Invalid status!\n" 
						+ "Enter PENDING, IN_PROGRESS, or COMPLETED");
						System.out.println();
						continue;
					} catch (DomainException e) {
						System.out.println();
						System.out.println(e.getMessage());
						System.out.println();
						continue;
					}
				}
				System.out.println();
				System.out.println("Task Status edited successfully!");
				System.out.println();
				System.out.println(task);
				System.out.println();
			} else {
				System.out.println("ID not found!");
				System.out.println();
			}
			System.out.print("Do you want to continue editing (y/n)?: ");
			char answer = sc.next().trim().toLowerCase().charAt(0);
			System.out.println();
			if (answer != 'y' && answer != 'n') {
				System.out.println("invalid answer! try again!");
				System.out.println();
				continue;
			}
			if (answer == 'n') {
				break;
			}
		}
	}

	public static void projectSummary(Project project) throws DomainException {
		System.out.println("========== PROJECT SUMMARY ==========");
		System.out.println();
		System.out.println("Project: " + project.getName());
		System.out.println("Developer: " + project.getDeveloper().getName());
		System.out.printf("Hourly rate: R$ %.2f%n", project.getDeveloper().getHourlyRate());
		System.out.println("Number of tasks: " + project.numberOfTasks());
		System.out.println();
		System.out.println("#TASKS:");
		System.out.println();
		for (Task task : project.getTasks()) {
			System.out.println(task);
			System.out.printf("Estimated Cost Of Task: R$ %.2f%n%n", project.estimatedCostOfATask(task.getId()));
		}
		totalTaskStatus(project);
		System.out.println();
		System.out.printf("Total Estimated Cost: R$ %.2f%n", project.totalCost());
		System.out.println();
	}

	public static void totalTaskStatus(Project project) {
		int sumPendingStatus = 0;
		int sumInProgressStatus = 0;
		int sumCompletedStatus = 0;
		for (Task task : project.getTasks()) {
			if (task.getCurrentStatus() == TaskStatus.PENDING) {
				sumPendingStatus++;
			} else if (task.getCurrentStatus() == TaskStatus.IN_PROGRESS) {
				sumInProgressStatus++;
			} else {
				sumCompletedStatus++;
			}
		}
		System.out.println("PENDING: " + sumPendingStatus);
		System.out.println("IN_PROGRESS: " + sumInProgressStatus);
		System.out.println("COMPLETED: " + sumCompletedStatus);
	}

	public static void finalTaskStatus(Project project) {
		System.out.println("#STATUS DETAILS:");
		for (Task task : project.getTasks()) {
			System.out.printf("[%d] %s%nStatus: %s%n", task.getId(), task.getDescription(), task.getCurrentStatus());
		}
	}

	public static void taskRemove(Scanner sc, Project project) throws DomainException {
		System.out.println("Task Remove:");
		System.out.print("Enter the ID: ");
		Integer id = sc.nextInt();
		Task foundFirst = project.searchForTaskById(id);
		if (foundFirst == null) {
			System.out.println();
			System.out.println("ID not found!");
			System.out.println();
			return;
		}
		project.taskRemove(foundFirst);
		System.out.println();
		System.out.println("Task removed successfully!");
		System.out.println();
	}

	public static Enterprise createdEnterprise() throws DomainException {
		return new Enterprise("MO VASCONCELOS");
	}

	public static void addProjectInEnterprise(Enterprise enterprise, Project project) throws DomainException {
		enterprise.addProject(project);
		System.out.println();
	}

	public static void enterpriseSummary(Enterprise enterprise) {
		System.out.println("======== ENTERPRISE SUMMARY =========");
		System.out.println();
		for (Project project : enterprise.getProjects()) {
			System.out.println(project);
		}
	}

	public static char wishesToReturn(Scanner sc) {
		System.out.print("Do you want to continue (y/n)?: ");
		char answer = sc.next().trim().toLowerCase().charAt(0);
		System.out.println();
		return answer;
	}

}
