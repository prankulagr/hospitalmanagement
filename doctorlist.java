import java.io.File;
import java.util.Scanner;

public class doctorlist {
    public static void main(String[] args) {
        try {
            File file = new File("doctorsinfo.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] details = data.split(",");

                int i = 1;
                System.out.println("Name - Dr." + details[0].toUpperCase() + " | Qualifications - "
                        + details[1].toUpperCase() + " | Age - "
                        + details[2].toUpperCase() + " | Gender - " + details[3].toUpperCase() + " | Room No. - "
                        + details[4].toUpperCase() + " | Speciality - "
                        + details[5].toUpperCase() + " | Experience - " + details[6].toUpperCase());
                i++;
            }
        } catch (Exception e) {
            System.out.println("Something Went Wrong");
        }
    }
}
