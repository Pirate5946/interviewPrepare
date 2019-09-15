package onjava8;

/**
 * @author : LIUTAO
 * create at : 2019-09-03 14:31
 * @description: 子类
 **/
public class SonClass {
    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
//        System.out.println(parentClass.parentPrivateString);
        System.out.println(parentClass.parentProtectedString + parentClass.parentPackageString);
    }
}
