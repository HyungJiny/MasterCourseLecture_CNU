import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainClass {
    public static void main(String[] args) throws IOException {
        // read input file
        String inputFile = "./input.txt";
        Scanner scanner = new Scanner(new FileInputStream(inputFile));

        String studentId;
        Boolean studentPassed;
        Boolean studentProposed;

        List<Student> students = new ArrayList<Student>();

        // Make student's notification thread and start
        Runnable runnable = new Notification(students);
        Thread thread = new Thread(runnable);
        thread.start();

        while(scanner.hasNext()){
            StringTokenizer tokenizer = new StringTokenizer(scanner.nextLine(), ",");
            while(tokenizer.hasMoreTokens()){
                studentId = tokenizer.nextToken();
                studentPassed = Boolean.valueOf(tokenizer.nextToken());
                studentProposed = Boolean.valueOf(tokenizer.nextToken());
                // Make student object and Add
                students.add(new Student(studentId, studentPassed, studentProposed));
            }
        }
    }
}
