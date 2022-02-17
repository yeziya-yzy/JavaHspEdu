package 案例.HomeWork.hspdeuHomeWork.ExceptionHomeWork;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class CustomException {
    public static void main(String[] args) {
        int a = 60 ;
        if (!(a < 20 || a > 80)){
            throw new AgeException("年龄不正确");
        }
    }
}

class AgeException extends RuntimeException{
    public AgeException(String message) {
        super(message);
    }
}