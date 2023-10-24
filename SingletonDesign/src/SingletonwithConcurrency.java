public class SingletonwithConcurrency {
    private static SingletonwithConcurrency obj=null;
    private SingletonwithConcurrency(){}

    public static SingletonwithConcurrency getInstance(){
        if(obj==null){
            synchronized (obj){
                if(obj==null)
                obj = new SingletonwithConcurrency();
            }
        }
        return obj;
    }
}
