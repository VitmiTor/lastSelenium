package model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("UserInfo")
public class UserInfo {
    @ExcelCellName("Key")
    private String Key;
    @ExcelCellName("User")
    private String User;
    @ExcelCellName("email")
    private String email;
    @ExcelCellName("password")
    private String password;

    public String getKey() {
        return Key;
    }

    public String getUser() {
        return User;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
