import java.util.HashMap;
import java.util.Map;

public class UserAuthentication {
    private static final Map<String, String> userDatabase = new HashMap<>();

    public static void RegisterUser(String username, String password) {
        userDatabase.put(username, password);
    }

    public static boolean Login(String cpf, String password) {
        return userDatabase.containsKey(cpf) && userDatabase.get(cpf).equals(password);
    }
}
