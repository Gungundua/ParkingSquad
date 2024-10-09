package ParkingSquad;

import java.util.Scanner;
import static java.util.Objects.isNull;

public interface User {
    Scanner userInput = new Scanner(System.in);
    Constant constant = new Constant();
    default boolean authentication(String[][] detail, int userId) {
        String id = Integer.toString(userId);
        for (int i = 1; i < detail.length; i++) {
            if (detail[i][0].equals(id)) {
                return true;
            }
        }
        return false;
    }
    default void push(String[][] details, String role) {
        for (int row = 1; row < details.length; row++){
            if (isNull(details[row][0])){
                System.out.println(constant.ENTER_NAME);
                details[row][1] = userInput.nextLine();
                System.out.println(constant.ENTER_CONTACT_NUMBER);
                details[row][2] = userInput.nextLine();
                switch (role) {
                    case "1", "2":
                        details[row][3] = "Student";
                        System.out.println(constant.NEW_PASSWORD);
                        details[row][4] = userInput.nextLine();
                        break;
                    case "3":
                        System.out.println(constant.NEW_PASSWORD);
                        details[row][4] = userInput.nextLine();
                        break;
                }
                System.out.println(constant.MEMBER_SUCCESSFULLY_ADDED);
            }
        }
    }
    default void pop(String[][] detail, int index) {
        for (int i = 0; i < detail[0].length; i++) {
            detail[index][i] = null;
        }
        System.out.println(constant.MEMBER_REMOVED_SUCCESSFULLY);
    }
    default void edit(String[][] detail, int index) {
        String choice;
        do {
            int i;
            System.out.println(constant.EDIT_DETAIL);
            System.out.println(constant.CHOICE);
            choice = userInput.nextLine();
            switch (choice) {
                case "1":
                    i = 1;
                    System.out.println(constant.NEW_NAME);
                    detail[index][i] = userInput.nextLine();
                    break;
                case "2":
                    i = 2;
                    System.out.println(constant.NEW_CONTACT_NUMBER);
                    detail[index][i] = userInput.nextLine();
                    break;
                case "3":
                    i = 3;
                    System.out.println(constant.NEW_PASSWORD);
                    detail[index][i] = userInput.nextLine();
                    break;
                default:
                    System.out.println(constant.INCORRECT_CHOICE);
                    break;
            }
        } while (!choice.equals("7"));
        for (int i = 0; i < detail[0].length; i++) {
            System.out.println(detail[index][i]);
        }
    }
}
class Student implements User {
    Student(int size) {
        ParkingSystem.Main.userDetails = new String[size][4];
        ParkingSystem.Main.userDetails[0][0] = constant.UNIQUE_ID;
        ParkingSystem.Main.userDetails[0][1] = constant.NAME;
        ParkingSystem.Main.userDetails[0][2] = constant.CONTACT_NUMBER;
        ParkingSystem.Main.userDetails[0][3] = constant.ROLE;
        ParkingSystem.Main.userDetails[0][4] = constant.ENTER_PASSWORD;
    }
}
class Staff implements User {

}
class Visitor implements User {
    Visitor(int size) {
        ParkingSystem.Main.visitorDetails = new String[size][3];
        ParkingSystem.Main.visitorDetails[0][0] = constant.UNIQUE_ID;
        ParkingSystem.Main.visitorDetails[0][1] = constant.NAME;
        Main.visitorDetails[0][2] = constant.CONTACT_NUMBER;
    }
}