package exception;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 20:08 2017/11/21
 * @Modified By:
 */
public class CustomException extends Exception{
    //用来创建无参数对象
    public CustomException(){}
    //用来创建指定参数对象
    public CustomException(String message){
        super(message);
    }
}
