package model;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

@ExcelSheet("Comentarios")
public class Comentarios {
    @ExcelCellName("Key")
    private String Key;
    @ExcelCellName("Comentarios")
    private String Comentarios;

    public String getKey() {
        return Key;
    }

    public String getComentarios() {
        return Comentarios;
    }
}
