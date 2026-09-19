package ui;
import service.StudentService;
import util.DBUtil;

public class Main {
    public static void main(String[] args) {
        // Step A: DB Connect karo
        DBUtil.connect();

        // Step B: Service ko bolo student add karne ko
        StudentService service = new StudentService();
        service.registerStudent(101, "Nidhi");
    }
}
