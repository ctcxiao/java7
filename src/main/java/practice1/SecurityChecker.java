package practice1;

public class SecurityChecker {
    public  boolean checkPermission(User user, Permission permission) {
        //todo code
        if (user == null){
            return false;
        }
        return permission != null;
    }

    public boolean isAdmin() {
        //todo code
        return false;
    }
}
