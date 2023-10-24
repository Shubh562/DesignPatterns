import java.util.HashMap;
import java.util.Map;

public class ChildrenRegistry {
    Map<String,Children> Registry=new HashMap<>();

    public void register(String key, Children children){
        Registry.put(key,children);
    }

    public Children get(String key){
        return Registry.get(key);
    }
}
