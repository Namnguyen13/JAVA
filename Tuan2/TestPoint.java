import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestPoint {
    public static void main(String[] args) {
        // Tạo danh sách các điểm
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(5, 6));

        // Ghi các điểm vào tệp tin
        try {
            FileOutputStream fileOut = new FileOutputStream("points.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(points);
            out.close();
            fileOut.close();
            System.out.println("da ghi trang thai cua cac diem vao tep tin points.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Point implements Serializable {
    private static final long serialVersionUID = 1L;
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
