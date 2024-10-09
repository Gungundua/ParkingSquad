import java.util.Scanner;
public class Main {

    public static int userId = 0;
    public static Scanner userInput = new Scanner(System.in);
    public static Constant constant = new Constant();
    public static User user = new User();
    public static ParkingSpot parkingSpot = new ParkingSpot();
    public static Student student = new Student();
    public static TwoWheeler twoWheelerParking = new TwoWheeler(twoWheelerSpots());
    public static FourWheeler fourWheelerParking = new FourWheeler(fourWheelerSpots());
    public static Vehicle vehicle = new Vehicle();
    public static Pass pass = new Pass();

    public static int twoWheelerSpots(){
        System.out.print(constant.TWO_WHEELER_SPOTS);
        int spots = 0;
        try {
            spots = userInput.nextInt();
        } catch (Exception e) {
            clear();
            System.out.println(constant.WRONG_INPUT);
        }
        return spots;
    }

    public static int fourWheelerSpots(){
        System.out.print(constant.FOUR_WHEELER_SPOTS);
        int spots = 0;
        try {
            spots = userInput.nextInt();
        } catch (Exception e) {
            clear();
            System.out.println(constant.WRONG_INPUT);
        }
        return spots;
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static boolean SelectVehicleType(){
        System.out.println(constant.YOUR_VEHICLE_TYPE);
        String choice = userInput.nextLine();
        switch (choice){
            case "1":
                return twoWheelerParking.isAvailableSpot();
            case "2":
                return fourWheelerParking.isAvailableSpot();
            case "3":
                break;
            default:
                clear();
                System.out.println(constant.WRONG_INPUT);
                SelectVehicleType();
        }
        clear();
        return false;
    }

    public static boolean authenticateUser(){
        System.out.print(constant.USER_ID_INPUT);
        try {
            userId = userInput.nextInt();
        } catch (Exception e) {
            clear();
            System.out.println(constant.WRONG_INPUT);
            authenticateUser();
        }
        return user.authentication(student.details, userId);
    }

    public static void ViewMemberOptions(){
        System.out.println(constant.VIEW_MEMBER_OPTIONS);
        System.out.print(constant.YOUR_CHOICE);
        String choice = userInput.nextLine();
        switch (choice){
            case "1":
                user.edit(student.details, userId);
                break;
            case "2":
                pass.renewPass(student.details, userId);
                break;
            case "3":
                pass.getPass(userId);
                break;
            case "4":
                return;
            default:
                System.out.println(constant.WRONG_INPUT);
                break;
        }
    }

    public static void main(String[] args){
         boolean continueLoop = true;
         do{
             System.out.println(constant.SECURITY_OPTIONS);
             System.out.print(constant.YOUR_CHOICE);
             String choice = userInput.nextLine();
             switch (choice){
                 case "1":
                     clear();
                     if(SelectVehicleType()) user.push();
                     else System.out.println(constant.SPOT_FILLED);
                     break;
                 case "2":
                     clear();
                     if(authenticateUser()){
                         ViewMemberOptions();
                     }
                     else System.out.println(constant.NOT_VALID_USER);
                     break;
                 case "3":
                     if(authenticateUser()) vehicle.entryTime(userId);
                     else System.out.println(constant.NOT_VALID_USER);
                     break;
                 case "4":
                     if(authenticateUser()) vehicle.exitTime(userId);
                     else System.out.println(constant.NOT_VALID_USER);
                     break;
                 case "5":
                     continueLoop = false;
                     break;
                 default:
                     System.out.println(constant.WRONG_INPUT);
             }
         }
         while(continueLoop);
    }
}