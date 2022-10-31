package data;

import model.UserInfo;
import model.UserInformation;
import org.testng.annotations.DataProvider;
import utilities.Logs;

public class DataProviders {
    private final Logs logs = new Logs();
    private final MapParser mapParser = new MapParser();
    private final ExcelReader excelReader = new ExcelReader();
    public final static String USER_INFORMATION_DP = "user information data provider";

    @DataProvider(name = USER_INFORMATION_DP)
    public Object[][] userInformationDataProvider() {
        var userInformation = new UserInformation();
        var errorMessage = mapParser.getErrorMessageMap();
        var username = userInformation.getUserName();
        var email = userInformation.getEmail();
        var password = userInformation.getPassword();
        var empty = "";

        return new Object[][]{
                {empty, email, password, errorMessage.get("usernameMissing").getErrorMessage()},
                {username, empty, password, errorMessage.get("emailMissing").getErrorMessage()},
                {username, email, empty, errorMessage.get("passwordMissing").getErrorMessage()}
        };
    }

    public UserInfo getUserInfoHardcoded() {
        logs.debug("getting Key userInfo Hardcoded");
        return mapParser.getuserInfoMap().get("valid");
    }
}
