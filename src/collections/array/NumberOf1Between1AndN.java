package collections.array;

/**
 * @ClassName NumberOf1Between1AndN
 * @Descrption TODO
 * @Author lt
 * @Date 2019/6/23 9:59
 * @Version 1.0
 **/
public class NumberOf1Between1AndN {
        // 1  --- 10(不包括自己) ；  n : 0 - 1  ;  F(n) = 1 + 0
        // 10 --- 100(不包括自己) :   n : 1 - 2  ; F(n) = 1 * 10 + 1
        // 100  --- 1000(不包括自己) ；  n : 2 - 3  ;  F(n) = 11 * 10 + 10
        // 100、101 109  10 + 1 = 11
        // 110、111、112 119 20 + 1 = 21
        // 120、121、122 129  10 +1 = 11
        // 190 ... 199 = 10 +1 = 11
}
