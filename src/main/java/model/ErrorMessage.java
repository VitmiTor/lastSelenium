package model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("ErrorMessage")
public class ErrorMessage {
    @ExcelCellName("Key")
    private String Key;
    @ExcelCellName("errorMessage")
    private String errorMessage;

    public String getKey() {
        return Key;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
