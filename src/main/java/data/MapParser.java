package data;

import model.ErrorMessage;
import model.UserInfo;
import utilities.Logs;

import java.util.HashMap;

public class MapParser {
    private Logs logs = new Logs();
    private ExcelReader excelReader = new ExcelReader();

    public HashMap<String, ErrorMessage> getErrorMessageMap() {
        logs.debug("creating errorMessage Map");
        var map = new HashMap<String, ErrorMessage>();
        var errorMessageList = excelReader.getErrorMessageList();
        for (var errorMessage : errorMessageList) {
            map.put(errorMessage.getKey(), errorMessage);
        }
        return map;
    }

    public HashMap<String, UserInfo> getuserInfoMap() {
        logs.debug("creating user info MAP");
        var map = new HashMap<String, UserInfo>();
        var userInfoList = excelReader.getUserInfo();
        for (var userInfo : userInfoList) {
            map.put(userInfo.getKey(), userInfo);
        }
        return map;
    }
}
