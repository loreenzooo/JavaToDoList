import java.util.Scanner;
import java.util.ArrayList;

public class ToDoList {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> toDoList = new ArrayList<>(10);
    ArrayList<String> completedToDo = new ArrayList<>();
    int toDoInp;

    // Option 1
    public void inputNotes() {
        try {

            System.out.print("\nEnter to do notes you want to input (1-10):");
            toDoInp = sc.nextInt();
            sc.nextLine();
            if (toDoInp > 0 && toDoInp <= 10) {
                for (int i = 0; i < toDoInp; i++) {
                    System.out.print("\nEnter your to do notes:");
                    String input = sc.nextLine();
                    toDoList.add(input);
                    toDoList.sort(null);
                    System.out.println(input + " is Added!");
                }

            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Invalid! Out of bounds! (1-10) only!");
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    // Option 2
    public void displayNotes() {
        int i = 1;
        for (String notes : toDoList) {
            System.out.print("\n");
            System.out.print(i + ". " + notes);
            i++;
        }
        System.out.print("\n");
        if (completedToDo.isEmpty()) {
            System.out.println("\nCompleted List:");
            System.out.println("-----NO COMPLETED TO DO'S-----\n");
        } else {
            System.out.println("\nCompleted List:");
            for (String task : completedToDo) {
                System.out.print("\n");
                System.out.println(i + " " + task);
                i++;
            }

        }
    }

    // Option 3
    public void deleteToDos() {
        int toDoDelete;
        int j = 1;
        int i = 1;
        System.out.println("CURRENT LIST:");
        for (String task : toDoList) {

            System.out.println(j + ". " + task);
            j++;
        }

        System.out.println("\nEnter a number you want to delete:");
        toDoDelete = sc.nextInt();
        toDoDelete = toDoDelete - 1;
        try {
            if ((toDoDelete < toDoList.size())) {
                toDoList.remove(toDoDelete);
                System.out.println("Updated list:\n");
                for (String task : toDoList) {

                    System.out.println(i + ". " + task);
                    i++;
                }

            } else {
                System.out.println("Invalid input!");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("Invalid input! out of bounds!");
        } catch (Exception e) {
            System.out.println("Unexpected error!" + e.getMessage());
        }

    }

    // Option 4
    public void completeToDos() {
        displayNotes();
        int i = 1;
        try {

            System.out.println("Enter notes you want to complete:");
            int completedList = sc.nextInt();
            completedList = completedList - 1; // Since the index starts from 0

            completedToDo.sort(null);
            if (completedList < toDoList.size()) {
                String completedTask = toDoList.remove(completedList);
                completedToDo.add(completedTask);
            } else {
                System.out.println("INVALID!");
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        System.out.println("\nUpdated to do list:");
        if (!toDoList.isEmpty()) {
            toDoList.sort(null);
            for (String task : toDoList) {
                System.out.println(i + ". " + task);
                i++;
            }
        } else {
            System.out.println("----- NO TO DO'S -----\n");
        }

        System.out.println("\nCompleted List:");
        for (String task : completedToDo) {

            System.out.println(i + ". " + task);
            i++;
        }
    }

    public static void main(String[] args) {
        ToDoList obj = new ToDoList();
        int choice;
        do {
            System.out.print("\nWELCOME TO TODO LIST!\n");
            System.out.println("1.Input to do's");
            System.out.println("2.Display to do's");
            System.out.println("3.Delete to do's");
            System.out.println("4.Complete to do's");
            System.out.println("5.Exit");
            System.out.print("Enter your choice:");
            choice = obj.sc.nextInt();

            switch (choice) {
                case 1:
                    obj.inputNotes();
                    break;
                case 2:
                    obj.displayNotes();
                    break;
                case 3:
                    obj.deleteToDos();
                    break;
                case 4:
                    obj.completeToDos();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid input! (1-5) only!");
                    break; 
            }
        } while (choice != 5);
    }
}
