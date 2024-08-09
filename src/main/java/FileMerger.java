import java.io.*;
import java.util.*;

public class FileMerger {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Step 2: Read integers from input1.txt
        try (BufferedReader reader1 = new BufferedReader(new FileReader("input1.txt"))) {
            String line;
            while ((line = reader1.readLine()) != null) {
                try {
                    list1.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in input1.txt: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File input1.txt not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 2: Read integers from input2.txt
        try (BufferedReader reader2 = new BufferedReader(new FileReader("input2.txt"))) {
            String line;
            while ((line = reader2.readLine()) != null) {
                try {
                    list2.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in input2.txt: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File input2.txt not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Step 3: Merge the contents of both lists
        List<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);

        // Step 4: Identify common integers
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> commonIntegers = new HashSet<>();
        for (Integer number : list2) {
            if (set1.contains(number)) {
                commonIntegers.add(number);
            }
        }

        // Step 5: Write merged list to merged.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("merged.txt"))) {
            for (Integer number : mergedList) {
                writer.write(number.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to merged.txt.");
            e.printStackTrace();
        }

        // Step 5: Write common integers to common.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("common.txt"))) {
            for (Integer number : commonIntegers) {
                writer.write(number.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to common.txt.");
            e.printStackTrace();
        }

        System.out.println("Processing complete.");
    }
}
