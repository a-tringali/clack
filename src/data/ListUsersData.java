package data;

public class ListUsersData extends ClackData {

    String users;

    public ListUsersData( String users ) {
        super("server", 0);
        this.users = users;
    }
    @Override
    public String getData() {
        return users;
    }

    @Override
    public String getData(String key) {
        return null;
    }

}