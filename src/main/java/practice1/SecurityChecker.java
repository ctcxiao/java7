package practice1;

public class SecurityChecker {
    public  boolean checkPermission(User user, Permission permission) {
        //todo code
        if (user == null){
            return false;
        }
        if (permission == null){
            return false;
        }
        return true;
    }

    public boolean isAdmin() {
        //todo code
        return false;
    }
}
