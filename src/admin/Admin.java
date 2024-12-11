package admin;

import Models.Room;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void updateRoomDetails(int roomId, Room newDetails) {
        // Logic to update room details
    }
}
