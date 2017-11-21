package entity.domain;

public class UserEntity {

    private String username;
    private boolean deactivated;

    public UserEntity(String username) {
        this.username = username;
    }
    public UserEntity(String username, boolean deactivated) {
        this.username = username;
        this.deactivated = deactivated;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public boolean isDeactivated() {
        return deactivated;
    }
    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }
}
