public class Main {

    public static void fillRegistry(ChildrenRegistry childrenRegistry){
        Children apr21=new Children();
        apr21.setAge(25);
        apr21.setName("Shubham");
        childrenRegistry.register("apr21", apr21);
    }
    public static void main(String[] args) {
        ChildrenRegistry childrenRegistry=new ChildrenRegistry();
        fillRegistry(childrenRegistry);
        Children apr22=childrenRegistry.get("apr21").clone();
        System.out.println(apr22);
    }
}