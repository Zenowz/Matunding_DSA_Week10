public class TestLinkedList {
    public static void main(String[] args) {
        Course course1 = new Course("BSCS", "BS Computer Science");
        Course course2 = new Course("BSIT", "BS Information Technology");
        Course course3 = new Course("BSIS", "BS Information System");
        Course course4 = new Course("BSEMC", "BS Entertainment and Multimedia Computing");

        Student1 stud1 = new Student1("S001", "Cory Khong", "Female", 20, course1, 2.5);
        Student1 stud2 = new Student1("S002", "Malou Ngay", "Female", 22, course1, 1.3);
        Student1 stud3 = new Student1("S003", "Tina Kong", "Female", 24, course2, 1.2);
        Student1 stud4 = new Student1("S004", "Sy Bent Thong", "Male", 18, course1, 1.7);
        Student1 stud5 = new Student1("S005", "Phinah Asah", "Female", 15, course2, 2.1);
        Student1 stud6 = new Student1("S006", "Keena Good", "Female", 23, course3, 3.5);
        Student1 stud7 = new Student1("S007", "Pepe Tsugi", "Male", 20, course4, 2.4);
        Student1 stud8 = new Student1("S008", "Malou Wang", "Female", 19, course1, 1.5);

        LNodeObject<Student1> studentList1 = new LNodeObject<Student1>();

        studentList1.addAtLast(stud1);
        studentList1.addAtLast(stud2);
        studentList1.addAtLast(stud3);
        studentList1.addAtLast(stud4);
        studentList1.addAtLast(stud5);
        studentList1.addAtLast(stud6);
        studentList1.addAtLast(stud7);
        studentList1.addAtLast(stud8);

        System.out.println("Empty\t\t: " + studentList1.isEmpty());
        System.out.println("Number of Records\t: " + studentList1.currentSize());
        
        Student1 firstStudent = (Student1) studentList1.getFirst();
        firstStudent.viewStudentInfo();
        
        Student1 lastStudent = (Student1) studentList1.getLast();
        System.out.println(lastStudent.getStudent());

        System.out.println(studentList1.traverse()); 
        
        System.out.println("\n--- Traversing list using getNode() loop ---");
        int i = 0; 
    
        System.out.println(studentList1.traverseNode());
           
        
    } 
} 
