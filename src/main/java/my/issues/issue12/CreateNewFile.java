package my.issues.issue12;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) {
        File file = new File("MyNumber.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file.getName() + " created successfully.");
        System.out.println(file.getAbsoluteFile());
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);

    }
}
