package data;

import com.poiji.bind.Poiji;
import model.ErrorMessage;
import model.UserInfo;
import utilities.Logs;

import java.io.File;
import java.util.List;

public class ExcelReader {
    private Logs logs = new Logs();
    private final String excelPath = "src/test/resources/data/Mensajes.xlsx";

    public List<ErrorMessage> getErrorMessageList() {
        logs.debug("Reading Excel error Message");
        return Poiji.fromExcel(new File(excelPath), ErrorMessage.class);
    }

    public List<UserInfo> getUserInfo() {
        logs.debug("Reading Excel userInfo Hardcoded");
        return Poiji.fromExcel(new File(excelPath), UserInfo.class);
    }
}
