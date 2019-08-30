import javax.sound.midi.Soundbank;

/**
 * @author : LIUTAO
 * create at : 2019-08-29 17:25
 * @description: 临时测试类
 **/
public class TempTest {
    public static void main(String[] args) {
        String excelValue = "a/b/";
        char c = excelValue.charAt(excelValue.length() - 1);
        System.out.println(c);
        excelValue = excelValue.substring(0, excelValue.length() - 1);
        System.out.println(excelValue);
    }
}
