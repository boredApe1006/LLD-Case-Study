package ecommerce.data;

public class User {

    private final int id;
    private final String name;
    private final String email;
    private final String phoneNum;

    public User(int id, String name, String email, String phoneNum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
    }
}
