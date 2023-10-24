public class Children implements Prototype{
    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    Children (){}
    Children(Children children){
        this.age=children.age;
        this.name= children.name;
    }
    @Override
    public Children clone() {
        return new Children(this);
    }
}
