package controller.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:L1ANN
 * @Description:
 * @Date:Created in 14:09 2017/11/20
 * @Modified By:
 */
public class CustomDateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String source){
        try{
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
