package model.entity;

public class User {

    private long id;
    private String name;
    private String login;
    private String password;
    private ROLE role;


    public enum ROLE{
        UNKNOWN,
        USER,
        MANAGER,
        MASTER
    }


    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.login = builder.login;
        this.password = builder.password;
        this.role = builder.role;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role.toString();
    }


    public static class Builder {
        private long id = 0;
        private String name = "";
        private String login = "";
        private String password = "";
        private ROLE role = ROLE.UNKNOWN;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setRole(String stringRole) {
            this.role = ROLE.valueOf(stringRole.toUpperCase());
            return this;
        }

        public User build(){
            return new User(this);
        }

    }
}
