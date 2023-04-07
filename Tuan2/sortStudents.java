import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private List<Double> scores;

    public Student(String name, List<Double> scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public List<Double> getScores() {
        return scores;
    }

    public double getAverageScore() {
        double sum = 0;
        for (Double score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }

    public int compareTo(Student s) {
        return Double.compare(this.getAverageScore(), s.getAverageScore());
    }

    public String toString() {
        return name + " " + getAverageScore();
    }
}

public class sortStudents {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so sinh vien: ");
        int numStudents = scanner.nextInt();

        //Nhập danh sách sinh viên 
        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Nhap ten sinh vien " + i + ": ");
            String name = scanner.next();
            System.out.print("Nhap diem sinh vien " + i +":");
            List<Double> scores = new ArrayList<>();
            while (scanner.hasNextDouble()) {
                scores.add(scanner.nextDouble());
            }
            students.add(new Student(name, scores));
        }

        scanner.close();

        //ghi danh sách ra file
        PrintWriter writer = new PrintWriter("students.txt");
        for (Student student : students) {
            writer.print(student.getName());
            for (Double score : student.getScores()) {
                writer.print(" " + score);
            }
            writer.println();
        }
        writer.close();

        //đọc danh sách từ file và sắp xếp theo điểm chung bình 
        BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            String name = parts[0];
            List<Double> scores = new ArrayList<>();
            for (int i = 1; i < parts.length; i++) {
                scores.add(Double.parseDouble(parts[i]));
            }
            students.add(new Student(name, scores));
        }
        reader.close();

        Collections.sort(students);

        //ghi danh sách đã sắp xếp từ file
        PrintWriter writer2 = new PrintWriter("sxsv.dat");
        for (Student student : students) {
            writer2.print(student.getName() + " " + student.getAverageScore());
            for (Double score : student.getScores()) {
                writer2.print(" " + score);
            }
            writer2.println();
        }
        writer2.close();
    }
}