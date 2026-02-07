import java.io.*;
import java.util.*;

public class DataManager {
    public static List<String[]> readCSV(String filename) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data/" + filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return data;
    }

    public static void writeCSV(String filename, List<String> lines) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/" + filename))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static void appendCSV(String filename, String line) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/" + filename, true))) {
            bw.write(line);
            bw.newLine();
        } catch (IOException e) { e.printStackTrace(); }
    }
}