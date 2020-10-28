package hippogriff.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHelper {

    public static boolean testFile(String path) throws IOException {
        File file = new File(path);
        if (file.exists())
            return true;
        else
            file.createNewFile();
        return false;
    }

    public static String loadFile(String path) throws IOException {
        testFile(path);

        File file = new File(path);
        Scanner sc = new Scanner(file);

        String text = "";
        while (sc.hasNextLine())
            text += sc.nextLine();

        return text;
    }

    public static ArrayList<String> loadLines(String path) throws IOException {
        testFile(path);

        File file = new File(path);
        Scanner sc = new Scanner(file);

        ArrayList<String> text = new ArrayList<>();
        while (sc.hasNextLine())
            text.add(sc.nextLine());

        return text;
    }
    
    public static ArrayList<String> loadConfig(String name) throws IOException {
        ArrayList<String> values = new ArrayList<>();

        for (String line: loadLines(name)) {
            line = line.split(" ")[0];
            if (line.length() < 3 || line.charAt(0) == '#')
                continue;
            values.add(line);
        }

        return values;
    }

}
