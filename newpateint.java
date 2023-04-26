import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.text.html.HTMLDocument.BlockElement;
import java.io.File;
import java.io.FileNotFoundException;

class pateint {
    String name;

    public String getName() {
        return name;
    }

    String gender;

    public String getGender() {
        return gender;
    }

    String problem;

    public String getProblem() {
        return problem;
    }

    String allergy;

    public String getAllergy() {
        return allergy;
    }

    int age;

    public int getAge() {
        return age;
    }

    String username;

    public String getUsername() {
        return username;
    }

    String password;

    public String getPassword() {
        return password;
    }

    public pateint(String name, String gender, String problem, String allery, int age, String username,
            String password) {
        this.name = name;
        this.gender = gender;
        this.problem = problem;
        this.allergy = allery;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    option options = new option();
    bookappointment appointment = new bookappointment();
    Doctorsentry dr = new Doctorsentry();

    public void registerPateint() {
        try {
            File file = new File("pateintinfo.txt");
            Scanner reader = new Scanner(file);
            boolean userNameExists = false;
            Scanner scan = new Scanner(System.in);

            System.out.print("Enter Pateint Name - ");
            String name = scan.nextLine();

            System.out.print("Enter Gender / (MALE / FEMALE) : ");
            String gender = scan.nextLine();

            System.out.print("Enter Problem Pateint is Facing - ");
            String problem = scan.nextLine();

            System.out.print("Does Pateint has any allery? pls Specify -- ");
            String allergy = scan.nextLine();

            System.out.print("Pls Enter Pateint Age - ");
            int age = scan.nextInt();
            scan.nextLine();

            System.out.print("Pls Enter Username (Username Must be Unique) -- ");
            String username = scan.nextLine();

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] details = data.split(",");
                String sname = details[5];

                if (sname.equalsIgnoreCase(username)) {
                    userNameExists = true;
                    System.out.println("Username Already Exists ! Try with Different Username");
                    System.out.print("Pls Enter Username (Username Must be Unique) -- ");
                    username = scan.nextLine();
                }

                if (!userNameExists) {
                    break;
                }
            }

            System.out.print("Pls Enter Password -- ");
            String password = scan.nextLine();

            pateint pateint = new pateint(name, gender, problem, allergy, age, username, password);

            FileWriter writer = new FileWriter("pateintinfo.txt", true);
            writer.write(pateint.getName() + "," + pateint.getGender() + "," + pateint.getProblem() + ","
                    + pateint.getAllergy()
                    + "," + pateint.getAge() + "," + pateint.getUsername() + "," + pateint.getPassword() + "\n");
            writer.close();
            System.out.println("Pateint Successfully Registered");
            System.out.println("**********************");
            options.main(null);
        } catch (Exception e) {
            System.out.println("something Went Wrong");
        }
    }

    public void readPateint() {
        System.out.println("Enter Your username");
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        try {

            boolean found = false;
            File file = new File("pateintinfo.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] details = data.split(",");
                String sname = details[5];
                String pass = details[6];
                if (sname.equalsIgnoreCase(username)) {
                    System.out.println("Pls Enter Your Password");
                    String password = scan.nextLine();
                    System.out.println("***********************");
                    if (password.equals(pass)) {
                        System.out.println("Hello " + details[5] + ", ");
                        System.out.println("1. Book Appointment");
                        System.out.println("2. Appointment Status");
                        System.out.println("3. Check Your Profile");
                        System.out.println("4. Lab Reports");
                        System.out.println("5. Search Doctors");
                        System.out.println("6. Back to Main");
                        int input = scan.nextInt();
                        switch (input) {
                            case 1:
                                bookappointment.main(null);
                                System.out.println("Press 1 to Return");
                                input = scan.nextInt();
                                if (input == 1) {
                                    readPateint();
                                }
                                break;

                            case 2:
                                bookappointment.appointmentStatus(sname);
                                System.out.println("Press 1 to Return");
                                input = scan.nextInt();
                                System.out.println("***********************");
                                if (input == 1) {
                                    readPateint();
                                }
                                break;

                            case 3:
                                System.out.println("Name = " + details[0]);
                                System.out.println("Gender = " + details[1]);
                                System.out.println("Problem = " + details[2]);
                                System.out.println("Allergy = " + details[3]);
                                System.out.println("Age = " + details[4]);
                                System.out.println("Username = " + details[5]);
                                System.out.println("Password = " + details[6]);
                                System.out.println("Press 1 to Return");
                                input = scan.nextInt();
                                if (input == 1) {
                                    readPateint();
                                }
                                break;

                            case 4:
                                System.out.println(
                                        details[5] + " - You will get your lab reports on your registered Mail-ID");
                                readPateint();
                                break;

                            case 5:
                                System.out.println("Search By Name Press - 1 / To Get All Doctors List Press - 2");
                                input = scan.nextInt();
                                if (input == 1) {
                                    dr.main(null);
                                } else {
                                    doctorlist list = new doctorlist();
                                    list.main(null);
                                }
                                readPateint();
                                break;

                            case 6:
                                options.main(null);
                                break;

                            default:
                                System.out.println("Pls Choose From Above Options Only");
                        }

                    } else {
                        System.out.println("Wrong Password !!!!");
                        System.out.println("In Case you forgot your Password ! Pls Register Again");
                        registerPateint();
                    }

                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Username not found ! Pls Register before");
                registerPateint();
            }
        } catch (Exception e) {
            System.out.println("Something went Wrong");
        }
    }
}

public class newpateint {
    public static void main(String[] args) {
        pateint pateint = new pateint(null, null, null, null, 0, null, null);
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you Returning Pateint ? TO Login PRESS-1 / TO Register PRESS-2");
        int input = scan.nextInt();
        if (input == 1) {
            pateint.readPateint();
        } else {
            pateint.registerPateint();
        }
    }
}
