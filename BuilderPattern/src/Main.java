public class Main {

    public static void main(String[] args) {
        Student s=Student.getStudentBuilder()
                .setAge(24)
                .setName("Shubham")
                .setRollNo(1)
                .setScore(99)
                .build();
        System.out.println(s);
    }
}