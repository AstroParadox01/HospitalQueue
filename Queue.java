import java.util.ArrayDeque;
import java.util.Scanner;

public class Queue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		java.util.Queue<String> patients = new ArrayDeque<>();
		int choice = 0;

		while (choice != 5) {
			System.out.println("\n1. Register");
			System.out.println("2. Serve");
			System.out.println("3. Next");
			System.out.println("4. Cancel");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
				case 1:
					System.out.print("Enter patient name: ");
					String name = sc.nextLine().trim();
					if (patients.contains(name)) {
						System.out.println("That patient is already waiting.");
					} else {
						patients.offer(name);
						System.out.println(name + " added to the queue.");
					}
					System.out.println("Waiting line: " + patients);
					break;
				case 2:
					String patient = patients.poll();
					if (patient == null) {
						System.out.println("No patients waiting.");
					} else {
						System.out.println("Serving " + patient);
					}
					System.out.println("Waiting line: " + patients);
					break;
				case 3:
					patient = patients.peek();
					if (patient == null) {
						System.out.println("No patients waiting.");
					} else {
						System.out.println("Next patient: " + patient);
					}
					System.out.println("Number waiting: " + patients.size());
					break;
				case 4:
					System.out.print("Enter patient name to cancel: ");
					name = sc.nextLine().trim();
					if (patients.contains(name)) {
						patients.remove(name);
						System.out.println(name + " removed from the queue.");
					} else {
						System.out.println("Patient not found.");
					}
					System.out.println("Waiting line: " + patients);
					break;
				case 5:
					System.out.println("Program terminated.");
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}

		sc.close();
	}
}
