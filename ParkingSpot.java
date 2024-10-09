/***
 * Statement- This file works for assigning the slot id from the parking area to the user
 * Owner Name- Gungun Dua
 * Date of Creation- 09/10/24
 */

import java.util.*;
// Abstract class ParkingLot representing the base for parking operations
abstract class ParkingLot {
    boolean[] availableSpots;
    abstract public void setSpot();
    abstract public void assignSpot();
    abstract public boolean isAvailableSpot();
}
class TwoWheeler extends ParkingLot {
    String[][] spotTable;
    public TwoWheeler(int totalSpot) {
        availableSpots = new boolean[totalSpot];
        spotTable = new String[totalSpot][2];
        spotTable[0][0] = "ID";
        spotTable[0][1] = "Spot ID";
        Arrays.fill(availableSpots, true);
    }
    @Override
    public boolean isAvailableSpot() {
        for (int i = 0; i < spotTable.length; i++) {
            if (!availableSpots[i]) {
                System.out.println("No available spot for two-wheelers.");
                return false;
            }

        }
        return true;
    }
    @Override
    public void setSpot() {
        for (int i = 0; i < spotTable.length; i++) {
            spotTable[i][1] = Integer.toString(i + 1);
        }
    }
    @Override
    public void assignSpot() {
        for (int i = 0; i < spotTable.length; i++) {
            if (availableSpots[i]) {
                availableSpots[i] = false;
                spotTable[i][1] = Integer.toString(i + 1);
                return;
            }
        }
        System.out.println("No available spot for two-wheelers.");
    }
}
class FourWheeler extends ParkingLot {
    String[][] spotTable;

    public FourWheeler(int totalSpot) {
        availableSpots = new boolean[totalSpot];
        spotTable = new String[totalSpot][2];
        spotTable[0][0] = "ID";
        spotTable[0][1] = "Spot ID";
        Arrays.fill(availableSpots, true);
    }

    @Override
    public boolean isAvailableSpot() {
        for (int i = 0; i < spotTable.length; i++) {
            if (!availableSpots[i]) {
                System.out.println("No available spot for four-wheelers.");
                return false;
            }
        }
        return true;
    }

    @Override
    public void setSpot() {
        for (int i = 0; i < spotTable.length; i++) {
            spotTable[i][1] = "Four-Wheeler Spot " + (i + 1);
        }
    }

    @Override
    public void assignSpot() {
        for (int i = 0; i < spotTable.length; i++) {
            if (availableSpots[i]) {
                availableSpots[i] = false;
                spotTable[i][1] = Integer.toString(i + 1);
                System.out.println(spotTable[i][1]);
                return;
            }
        }
    }
}
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the number of two-wheeler spots: ");
//        int twoWheelerSpots = scanner.nextInt();
//        System.out.println("Enter the number of four-wheeler spots: ");
//        int fourWheelerSpots = scanner.nextInt();
//        TwoWheeler twoWheelerParking = new TwoWheeler(twoWheelerSpots);
//        FourWheeler fourWheelerParking = new FourWheeler(fourWheelerSpots);
//        while (true) {
//            System.out.println("\nEnter the vehicle type (bike/bicycle for two-wheeler, car for four-wheeler): ");
//            String vehicleType = scanner.next().toLowerCase();
//            if (vehicleType.equals("bike") || vehicleType.equals("bicycle")) {
//                twoWheelerParking.assignSpot();
//            } else if (vehicleType.equals("car")) {
//                fourWheelerParking.assignSpot();
//            } else {
//                System.out.println("Invalid vehicle type! Please enter 'bike', 'bicycle', or 'car'.");
//                continue;
//            }
//            System.out.println("\nDo you want to assign more spots? (yes/no): ");
//            String continueOption = scanner.next().toLowerCase();
//            if (!continueOption.equals("yes")) {
//                break;
//            }
//        }
//        System.out.println("Parking allocation complete. Exiting...");
//    }
//  }
