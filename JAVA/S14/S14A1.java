import java.io.*;
import java.util.*;
import java.util.concurrent.*;

class FileSearchTask implements Runnable {
    private File file;
    private String searchString;

    public FileSearchTask(File file, String searchString) {
        this.file = file;
        this.searchString = searchString;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchString)) {
                    System.out.println("Found in " + file.getName() + " at line " + lineNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class S14A1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to search: ");
        String searchString = scanner.nextLine();

        File currentFolder = new File(".");
        File[] files = currentFolder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files != null) {
            ExecutorService executor = Executors.newFixedThreadPool(files.length);
            for (File file : files) {
                executor.execute(new FileSearchTask(file, searchString));
            }
            executor.shutdown();
        } else {
            System.out.println("No text files found in the current folder.");
        }

        scanner.close();
    }
}
