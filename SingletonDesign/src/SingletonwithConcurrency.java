public class SingletonwithConcurrency {
    private static SingletonwithConcurrency obj=null;
    private static Object mutex = new Object();
    private SingletonwithConcurrency(){}

    public static SingletonwithConcurrency getInstance(){
        if(obj==null){
            synchronized (mutex){
                if(obj==null)
                obj = new SingletonwithConcurrency();
            }
        }
        return obj;
    }
}
