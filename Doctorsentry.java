import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.colorchooser.ColorChooserComponentFactory;

import java.io.File;
import java.io.FileNotFoundException;

class Doctor{
        String name;
        String degree;
        int age;
        int roomno;
        String speciality;
        int experience;
        String gender;

        public Doctor(String name, String degree, int age, int roomno, String speciality, int experience,
                String gender) {
            this.name = name;
            this.degree = degree;
            this.age = age;
            this.roomno = roomno;
            this.speciality = speciality;
            this.experience = experience;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public String getdegree() {
            return degree;
        }

        public int getage() {
            return age;
        }

        public int getroomno() {
            return roomno;
        }

        public int getexperience() {
            return experience;
        }

        public String getgender() {
            return gender;
        }

        public String getSpeciality(){
            return speciality;
        }

        public void registerDoctor(){
            System.out.println("Please fill up Doctor's information below:");
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Doctor Name: ");
        String name = scan.nextLine();

        System.out.print("Enter Doctor Age: ");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Doctor Degree: ");
        String degree = scan.nextLine();

        System.out.print("Enter Doctor Gender (Male/Female): ");
        String gender = scan.nextLine();

        System.out.print("Enter Doctor Room Number: ");
        int roomno = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Doctor Experience (in Years): ");
        int experience = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter Doctor Speciality: ");
        String speciality = scan.nextLine();

        Doctor doctor = new Doctor(name, degree, age, roomno, speciality, experience, gender);

        try {
            FileWriter writer = new FileWriter("doctorsinfo.txt", true);
            writer.write(doctor.getName() + "," + doctor.getdegree() + "," + doctor.getage() + "," + doctor.getgender() +
                    "," + doctor.getroomno() + "," + doctor.getexperience() + "," + doctor.getSpeciality() + "\n");
            writer.close();
            System.out.println("Doctor details Saved Successfully");
        } catch (IOException e) {
            System.out.println("An error occurred while Adding Information");
            e.printStackTrace();
        }
        }

        public void readDoctor(){
            Scanner scan = new Scanner(System.in);
        try {
            File file = new File("doctorsinfo.txt");
            Scanner reader = new Scanner(file);

            System.out.println("Enter doctor name here :");
            String searchName = scan.nextLine();

            boolean found = false;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] details = data.split(",");
                String name = details[0];

                if (name.equalsIgnoreCase(searchName)) {
                    String degree = details[1];
                    int age = Integer.parseInt(details[2]);
                    String gender = details[3];
                    int roomno = Integer.parseInt(details[4]);
                    int experience = Integer.parseInt(details[5]);
                    String speciality = details[6];

                    Doctor dr = new Doctor(name, degree, age, roomno, speciality, experience, gender);
                    System.out.println("Doctor info is : " + System.lineSeparator() + "Name - DR." +
                            dr.getName().toUpperCase() + System.lineSeparator() + "Degree - "
                            + dr.getdegree().toUpperCase()
                            + System.lineSeparator() + "Age is - " + dr.getage() + System.lineSeparator()
                            + "Gender is - " + dr.getgender().toUpperCase() + System.lineSeparator() + "Room No. - " + dr.getroomno()
                            + System.lineSeparator() + "Speciality - " + dr.getSpeciality().toUpperCase() + System.lineSeparator()
                            + "Expereince - " + dr.getexperience());
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Doctor not found ! Try Again");
                readDoctor();
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        }

}

public class Doctorsentry {
    public static void main(String[] args) {
        Doctor dr = new Doctor(null, null, 0, 0, null, 0, null);
        dr.readDoctor();
    }
}
