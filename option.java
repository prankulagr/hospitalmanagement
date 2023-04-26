import java.util.Scanner;

public class option {
    public static void main(String[] args) {
        newpateint pateint = new newpateint();
        Doctorsentry doctorsentry = new Doctorsentry();
        Doctor doctor = new Doctor(null, null, 0, 0, null, 0, null);
        

        System.out.println("Welcome to Hospital Management Software");
        System.out.println("******************************");
        System.out.println("Choose Options from below : ");
        System.out.println("******************************");
        System.out.println("1. Pateint Register / Login");
        System.out.println("2. Search Doctors");
        System.out.println("3. Register As Doctor");
        System.out.println("******************************");

        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        switch (input){
            case 1 : 
            pateint.main(args);
            option.main(args);
            break;

            case 2 : 
            System.out.println("Search By Name Press - 1 / To Get All Doctors List Press - 2");
            input = scan.nextInt();
            if(input == 1){
                doctorsentry.main(args);
            }else{
                doctorlist list = new doctorlist();
                list.main(null);
            } 
            option.main(args);
            break;

            case 3 : 
            doctor.registerDoctor();
            option.main(args);
            break;

            default :
            System.out.println("Pls Select from Above");
            option.main(args);
        }
    }
}
