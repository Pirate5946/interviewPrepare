package onjava82;

import onjava8.ParentClass;

/**
 * @author : LIUTAO
 * create at : 2019-09-03 15:57
 * @description: 测试类1
 **/
public class TestClass1 extends ParentClass{
    public static void main(String[] args) {
        ParentClass parentClass = new ParentClass();
        TestClass1 testClass1 = new TestClass1();
        System.out.println(testClass1.parentProtectedString);
//        System.out.println(parentClass.parentProtectedString);
    }
}
