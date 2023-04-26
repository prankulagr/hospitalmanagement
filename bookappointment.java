import java.io.FileWriter;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

public class bookappointment {
    public static void main(String[] args) {
        Doctor doctor = new Doctor(null, null, 0, 0, null, 0, null);
        doctor.readDoctor();
        System.out.println("************************");
        System.out.println("To Book Appointment Press - 1 OR Press - 2 to EXIT ");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        if (input == 1) {
            try {
                System.out.print("Enter the Date Here -  ");
                String date = scan.next();
                scan.nextLine();
                System.out.print("Enter the time Between 10:00 am to 1:00 pm - ");
                String time = scan.next();
                System.out.print("Enter username to Confirm the Appointment - ");
                String username = scan.next();
                FileWriter writer = new FileWriter("appointmentlist.txt", true);
                writer.write(username + "," + date + "," + time + "\n");
                writer.close();
                System.out.println("************************");
                System.out.println("Thanks!! Your Appointment Booked Successfully");
            } catch (Exception e) {
                System.out.println("Something Went Wrong");
            }

        } else {
            System.exit(1);
        }
    }

    public static void appointmentStatus(String data1) {
        try {
            pateint pateint = new pateint(null, null, null, null, 0, null, null);
            Scanner scan = new Scanner(System.in);
            File file = new File("appointmentlist.txt");
            Scanner reader1 = new Scanner(file);
            while (reader1.hasNextLine()) {
                String data = reader1.nextLine();
                String details[] = data.split(",");
                String sname = details[0];
                if(sname.equalsIgnoreCase(data1)){
                    System.out.println("Your Appointment Details are as Follows - ");
                    System.out.println("***********************************");
                    System.out.println("username - " + sname);
                    System.out.println("Appointment Date - " + details[1]);
                    System.out.println("Appointment Timing - " + details[2]);
                    break;

                }

            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }

    }
}