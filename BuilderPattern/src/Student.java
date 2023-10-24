public class Student {
    private int age;
    private String name;
    private int rollNo;
    private int score;
    private  Student(StudentBuilder studentBuilder){
        this.age=studentBuilder.age;
        this.name=studentBuilder.name;
        this.rollNo=studentBuilder.rollNo;
        this.score=studentBuilder.score;
    }
    public static StudentBuilder getStudentBuilder(){
        return new StudentBuilder();
    }
    static class StudentBuilder{
        public int getAge() {
            return age;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getName() {
            return name;
        }

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public int getRollNo() {
            return rollNo;
        }

        public StudentBuilder setRollNo(int rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public int getScore() {
            return score;
        }

        public StudentBuilder setScore(int score) {
            this.score = score;
            return this;
        }

        private int age;
        private String name;
        private int rollNo;
        private int score;

        public Student build(){
            if (this.age>25) {
                throw new IllegalArgumentException();
            }
            //we can add other validations here
            return new Student(this);
        }
    }

}
